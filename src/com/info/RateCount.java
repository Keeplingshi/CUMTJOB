package com.info;

import java.text.DecimalFormat;
import java.util.List;

import com.sql.SqlModel;

public class RateCount {

	/**
	 * 根据专业代码查询该专业人数  在就业率统计表中
	 * @param major_dm
	 * @return
	 */
	public static int majorCount(String major_dm,String college_dm)
	{
		String sql="select postgraduate,exam,abroad,work,not_employed,officer from t_rate where major_dm='"+major_dm+"' and college_dm='"+college_dm+"'";
		return count(sql);
	}
	
	/**
	 * 查询专业人数
	 * @param major_dm
	 * @return
	 */
	public static int majorCount(String major_dm)
	{
		String sql="select postgraduate,exam,abroad,work,not_employed,officer from t_rate where major_dm='"+major_dm+"'";
		return count(sql);
	}
	
	/**
	 * 查询学院总人数
	 * @param college_dm
	 * @return
	 */
	public static int collegeCount(String college_name)
	{
		String college_sql="select dm from t_dm_college where name='"+college_name+"'";
		String college_dm=SqlModel.getInfo(college_sql);
		
		String sql="select postgraduate,exam,abroad,work,not_employed,officer from t_rate where college_dm='"+college_dm+"'";
		return count(sql);
	}
	
	/**
	 * 查询学校人数
	 * @return
	 */
	public static int schoolCount()
	{
		String sql="select postgraduate,exam,abroad,work,not_employed,officer from t_rate";
		return count(sql);
	}
	
	/**
	 * 本科生
	 */
	public static int underGraduateCount()
	{
		int count=schoolCount()-postGraduateCount();
//		System.out.println(count);
		return count;
	}
	
	/**
	 * 研究生总人数
	 * @return
	 */
	public static int postGraduateCount()
	{
		String sql="select postgraduate,exam,abroad,work,not_employed,officer from t_rate where major_dm='79'";
		return count(sql);
	}
	
	/**
	 * 统计已就业人数 
	 * 0 全校   1 本科生  2 研究生
	 * @return
	 */
	public static int jobCount(int type)
	{
		String sql=null;
		if(type==0){
			//全校
			sql="select work,officer from t_rate";
		}else if(type==1){
			//本科生
			sql="select work,officer from t_rate where major_dm <> 79;";
		}else{
			//研究生
			sql="select work,officer from t_rate where major_dm='79'";
		}
		return count(sql);
	}
	
	/**
	 * 统计未就业人数 
	 * 0 全校   1 本科生  2 研究生
	 * @return
	 */
	public static int notEmployCount(int type)
	{
		String sql=null;
		if(type==0){
			//全校
			sql="select not_employed from t_rate";
		}else if(type==1){
			//本科生
			sql="select not_employed from t_rate where major_dm <> 79;";
		}else{
			//研究生
			sql="select not_employed from t_rate where major_dm='79'";
		}
		return count(sql);
	}
	
	/**
	 * 统计升学人数 
	 * 0 全校   1 本科生  2 研究生
	 * @return
	 */
	public static int upEduCount(int type)
	{
		String sql=null;
		if(type==0){
			//全校
			sql="select postgraduate,exam,abroad from t_rate";
		}else if(type==1){
			//本科生
			sql="select postgraduate,exam,abroad from t_rate where major_dm <> 79;";
		}else{
			//研究生
			sql="select postgraduate,exam,abroad from t_rate where major_dm='79'";
		}
		return count(sql);
	}
	
	/**
	 * 根据学院名称查找学院升学人数
	 * @param college_name
	 * @return
	 */
	public static int upEduByCollegeCount(String college_name)
	{
		String college_sql="select dm from t_dm_college where name='"+college_name+"'";
		String college_dm=SqlModel.getInfo(college_sql);
		String sql="select postgraduate,exam from t_rate where college_dm='"+college_dm+"'";
		
		return count(sql);
	}
	
	/**
	 * 根据学院名称查找该学员出国人数
	 * @param college_name
	 * @return
	 */
	public static int abroadByCollegeCount(String college_name)
	{
		String college_sql="select dm from t_dm_college where name='"+college_name+"'";
		String college_dm=SqlModel.getInfo(college_sql);
		String sql="select abroad from t_rate where college_dm='"+college_dm+"'";
		
		return count(sql);
	}
	
	/**
	 * 根据学院名称查找已就业人数
	 * @param college_name
	 * @return
	 */
	public static int employByCollegeCount(String college_name)
	{
		String college_sql="select dm from t_dm_college where name='"+college_name+"'";
		String college_dm=SqlModel.getInfo(college_sql);
		String sql="select work,officer from t_rate where college_dm='"+college_dm+"'";
		
		return count(sql);
	}
	
	public static int employByCollegeCountPercent(String college_name)
	{
		String college_sql="select dm from t_dm_college where name='"+college_name+"'";
		String college_dm=SqlModel.getInfo(college_sql);
		String sql="select work,officer,postgraduate,exam,abroad from t_rate where college_dm='"+college_dm+"'";
		
		return count(sql);
	}
	
	/**
	 * 根据学院名称查找学院未就业人数
	 * @param college_name
	 * @return
	 */
	public static int unEmployByCollegeCount(String college_name)
	{
		String college_sql="select dm from t_dm_college where name='"+college_name+"'";
		String college_dm=SqlModel.getInfo(college_sql);
		String sql="select not_employed from t_rate where college_dm='"+college_dm+"'";
		
		return count(sql);
	}
	
	/**
	 * 已就业百分比
	 * @param college_name
	 * @return
	 */
	public static String employPercent(String college_name)
	{
		int employCount=employByCollegeCountPercent(college_name);
		int collegeCount=collegeCount(college_name);
		
		double rate=(double)employCount/(double)collegeCount*100;
		DecimalFormat df = new DecimalFormat("#.00");  
		String s=df.format(rate)+"%";
		return s;
	}
	
	/**
	 * 专业升学总人数统计
	 * @param major_dm
	 * @return
	 */
	public static int upEduByMajorCount(String major_dm,String college_dm)
	{
		String sql="select postgraduate,exam from t_rate where major_dm='"+major_dm+"' and college_dm='"+college_dm+"'";
		return count(sql);
	}
	
	/**
	 * 专业升学人数
	 * @param major_dm
	 * @return
	 */
	public static int upEduByMajorCount(String major_dm)
	{
		String sql="select postgraduate,exam from t_rate where major_dm='"+major_dm+"'";
		return count(sql);
	}
	
	/**
	 * 专业就业人数统计
	 * @param major_dm
	 * @return
	 */
	public static int employByMajorCount(String major_dm,String college_dm) {
		// TODO Auto-generated method stub
		String sql="select work,officer from t_rate where major_dm='"+major_dm+"' and college_dm='"+college_dm+"'";	
		return count(sql);
	}
	
	/**
	 * 
	 * @param major_dm
	 * @param college_dm
	 * @return
	 */
	public static int employByMajorCountPercent(String major_dm,String college_dm) {
		// TODO Auto-generated method stub
		String sql="select work,officer,postgraduate,exam,abroad from t_rate where major_dm='"+major_dm+"' and college_dm='"+college_dm+"'";	
		return count(sql);
	}
	
	/**
	 * 专业就业人数
	 * @param major_dm
	 * @return
	 */
	public static int employByMajorCount(String major_dm) {
		// TODO Auto-generated method stub
		String sql="select work,officer from t_rate where major_dm='"+major_dm+"'";	
		return count(sql);
	}
	
	/**
	 * 专业出国人数统计
	 * @param major_dm
	 * @return
	 */
	public static int abroadByMajorCount(String major_dm,String college_dm)
	{
		String sql="select abroad from t_rate where major_dm='"+major_dm+"' and college_dm='"+college_dm+"'";
		return count(sql);
	}
	
	/**
	 * 专业出国人数
	 * @param major_dm
	 * @return
	 */
	public static int abroadByMajorCount(String major_dm)
	{
		String sql="select abroad from t_rate where major_dm='"+major_dm+"'";
		return count(sql);
	}
	
	/**
	 * 专业未就业人数统计
	 * @param major_dm
	 * @return
	 */
	public static int unEmployByMajorCount(String major_dm,String college_dm)
	{
		String sql="select not_employed from t_rate where major_dm='"+major_dm+"' and college_dm='"+college_dm+"'";
		return count(sql);
	}
	
	/**
	 * 专业未就业人数
	 * @param major_dm
	 * @return
	 */
	public static int unEmployByMajorCount(String major_dm)
	{
		String sql="select not_employed from t_rate where major_dm='"+major_dm+"'";
		return count(sql);
	}
	
	/**
	 * 已就业百分比
	 * @param major_dm
	 * @return
	 */
	public static String employByMajorPercent(String major_dm,String college_dm)
	{
		int employCount=employByMajorCountPercent(major_dm,college_dm);
		int majorCount=majorCount(major_dm,college_dm);
		
		double rate=(double)employCount/(double)majorCount*100;
		DecimalFormat df = new DecimalFormat("#.00");  
		String s=df.format(rate)+"%";
		if(s.equals(".00%")){
			return "0.00%";
		}
		return s;
	}
	
	/**
	 * 专业就业百分比
	 * @param major_dm
	 * @return
	 */
	public static String employByMajorPercent(String major_dm)
	{
		//int employCount=employByMajorCount(major_dm);
		int employCount=employByMajorCountHist(major_dm);
		int majorCount=majorCount(major_dm);
		
		double rate=(double)employCount/(double)majorCount*100;
		DecimalFormat df = new DecimalFormat("#.00");  
		String s=df.format(rate)+"%";
		if(s.equals(".00%")){
			return "0.00%";
		}
		return s;
	}
	
	private static int employByMajorCountHist(String major_dm) {
		// TODO Auto-generated method stub
		String sql="select work,officer,postgraduate,exam,abroad from t_rate where major_dm='"+major_dm+"'";	
		return count(sql);
	}

	/**
	 * 根据sql语句计算人数
	 * @param sql
	 * @return
	 */
	private static int count(String sql)
	{
		List<String[]> list=SqlModel.QueryList(sql);
		
		int count=0;
		
		for(String[] s:list)
		{
			for(String c:s){
				count+=Integer.valueOf(c);
			}
		}
		
		return count;		
	}


}
