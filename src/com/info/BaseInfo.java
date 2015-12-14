package com.info;

import java.util.List;

import com.sql.SqlModel;

public class BaseInfo {

	/**
	 * 获取所有学院名称
	 * @return
	 */
	public static List<String> getCollege()
	{
		String sql="select name from t_dm_college";
		List<String> collegelist= SqlModel.QueryArray(sql);
		
		return collegelist;
	}
	
	/**
	 * 获取所有专业代码
	 * @return
	 */
	public static List<String> getMajorDM()
	{
		String sql="select major_dm from t_rate";
		List<String> majorList=SqlModel.QueryArray(sql);
		
		return majorList;
	}
	
	/**
	 * 根据学院名称在就业率统计表里获取相应专业代码
	 * @param college_name
	 * @return
	 */
	public static List<String> getMajorDMInRate(String college_name)
	{
		String college_sql="select dm from t_dm_college where name='"+college_name+"'";
		String college_dm=SqlModel.getInfo(college_sql);
		String sql="select major_dm from t_rate where college_dm='"+college_dm+"'";
		List<String> majorList=SqlModel.QueryArray(sql);
		
		return majorList;
	}
	
	/**
	 * 根据学院名称获取该学院所有专业
	 * @param collegeName
	 * @return
	 */
	public static String getmajorAllName(String college_name)
	{
		List<String> majordmList=getMajorDMInRate(college_name);
		
		String major="";
		for(String dm:majordmList){
			major+=getMajorByDM(dm)+",";
		}
		if(major.length()<1){
			return major;
		}
		String returnStr=major.substring(0, major.length()-1);
		return returnStr;
	}
	
	/**
	 * 根据专业代码查询专业名称
	 * @param major_dm
	 * @return
	 */
	public static String getMajorByDM(String major_dm)
	{
		String sql="select name from t_dm_major where dm='"+major_dm+"'";
		
		return SqlModel.getInfo(sql);
	}
	
	/**
	 * 根据学院名称查找代码
	 * @param college_name
	 * @return
	 */
	public static String getCollegeDMByName(String college_name)
	{
		String sql="select dm from t_dm_college where name='"+college_name+"'";
		
		return SqlModel.getInfo(sql);
	}
	
	/**
	 * 通过专业名称获取专业代码
	 * @param major_name
	 * @return
	 */
	public static String getDMByMajor(String major_name)
	{
		String sql="select dm from t_dm_major where name='"+major_name+"'";
		
		return SqlModel.getInfo(sql);
	}

	/**
	 * 获取该专业所有专业
	 * @param college_dm
	 * @param major_dm
	 * @return
	 */
	public static List<String[]> getMajorStuInfoList(String college_dm,String major_dm) {
		// TODO Auto-generated method stub
		
		//select t_stu_info.name,t_dm_job.name from t_stu_info,t_dm_job where college_dm='12' and major_dm='38' and t_stu_info.job_dm=t_dm_job.dm
		String sql="select t_stu_info.name,t_dm_job.name,t_stu_info.id from t_stu_info,t_dm_job where college_dm='"+college_dm+"' and major_dm='"+major_dm+"' and t_stu_info.job_dm=t_dm_job.dm and t_dm_job.dm='0'";
		List<String[]> list=SqlModel.QueryList(sql);
		
		return list;
	}

	/**
	 * 通过代码获取学院名称
	 * @param collegedm
	 * @return
	 */
	public static String getCollegeNameByDM(String collegedm) {
		// TODO Auto-generated method stub
		
		String sql="select name from t_dm_college where dm='"+collegedm+"'";
		return SqlModel.getInfo(sql);
	}
	
	/**
	 * 查询学生基本信息
	 * @param id
	 * @return
	 */
	public static String[] getStuInfo(String id)
	{
//		var json = [
//        {
//        "name":"肖高阳",
//        "profession":"计算机科学与技术",
//        "telNumber":"15651461019",
//        "eMail":"345745764@qq.com",
//        "intent":"我是用户填写的就业意向",
//        "briefIntroduce":"我是用户的个人简介",
//        "personRecommend":"我是用户的个人推荐，此处应为用户上传的个人推荐的文件的下载链接",
//        "collegeRecommend":"我是学院推荐的文字",
//        "schoolRecommend":"我是学校推荐的文字",
//        "userFace":"我是用户头像图片的路径"
//       },
//    ];
		
		
//		姓名			name                name(t_stu_info)
//		专业			profession          name(t_dm_major)通过major_dm(t_stu_info)=dm(t_dm_major)
//		负责人电话		telNumber			tel(t_linkman)通过college_dm(t_stu_info)=college_dm(t_linkman)且business='1'
//		负责人邮箱		eMail				email(t_linkman)通过college_dm(t_stu_info)=college_dm(t_linkman)且business='1'
//		就业意向		intent				employment(t_stu_info)
//		个人简介		briefIntroduce		intro(t_stu_info)
//		个人推荐材料	personRecommend		url(t_other)通过id(t_stu_info)=snum(t_other)
//		学院意见		collegeRecommend	recom_college(t_stu_info)
//		学校意见		schoolRecommend		recom_school(t_stu_info)
//		头像			userFace			userFace(t_stu_info)
		
		String returnStr[]=new String[10];
		
		String sql="select name,major_dm,employment,intro,recom_college,recom_school,userFace from t_stu_info where id='"+id+"'";
		List<String[]> list=SqlModel.QueryList(sql);
		String[] stu=list.get(0);
		
		returnStr[0]=stu[0];
		returnStr[1]=BaseInfo.getMajorByDM(stu[1]);
		returnStr[2]=getDuiltyTelNumber(id);
		returnStr[3]=getDuiltyEmail(id);
		returnStr[4]=stu[2];
		returnStr[5]=stu[3];
		returnStr[6]=getPersonRecommend(id);
		returnStr[7]=stu[4];
		returnStr[8]=stu[5];
		returnStr[9]=stu[6];
		
		for(int i=0;i<returnStr.length;i++){
			if(returnStr[i]==null){
				returnStr[i]="";
			}
		}
		
		return returnStr;
	}
	
	/**
	 * 查询学生个人推荐材料
	 * @param id
	 * @return
	 */
	public static String getPersonRecommend(String id)
	{
		String sql="select url from t_recommend where snum='"+id+"'";
		String result=SqlModel.getInfo(sql);
		
		return result;
	}
	
	/**
	 * 通过学生学号查询所在学院负责人的联系方式
	 * @param id
	 * @return
	 */
	public static String getDuiltyTelNumber(String id)
	{
		String s="select t_linkman.tel from t_stu_info,t_linkman where t_linkman.college_dm=t_stu_info.college_dm and t_linkman.business='1' and t_stu_info.id='"+id+"'";
		return SqlModel.getInfo(s);
	}
	
	/**
	 * 通过学生学号查询所在学院负责人的邮箱
	 * @param id
	 * @return
	 */
	public static String getDuiltyEmail(String id)
	{
		String s="select t_linkman.email from t_stu_info,t_linkman where t_linkman.college_dm=t_stu_info.college_dm and t_linkman.business='1' and t_stu_info.id='"+id+"'";
		return SqlModel.getInfo(s);
	}

	/**
	 * 通过专业代码查询学院
	 * @param major_dm
	 * @return
	 */
	public static String getCollegeByMajor(String major_dm) {
		// TODO Auto-generated method stub
		String sql="select t_dm_college.name from t_dm_college,t_rate where t_dm_college.dm=t_rate.college_dm and t_rate.major_dm='"+major_dm+"'";
		
		return SqlModel.getInfo(sql);
	}

	public static String getCollegeMajorNum(String major_dm) {
		// TODO Auto-generated method stub
		
		String college_name=getCollegeByMajor(major_dm);
		String college_dm=getCollegeDMByName(college_name);
		String sql="select count(*) from t_rate where college_dm='"+college_dm+"' and major_dm<>'79'";
		
		return SqlModel.getInfo(sql);
	}
}
