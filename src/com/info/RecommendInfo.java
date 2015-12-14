package com.info;

import java.util.List;

import com.sql.SqlModel;

public class RecommendInfo {
	
	/**
	 * 推荐表基本信息
	 * @param id
	 * @return
	 */
	public static List<String[]> getRecInfo(int id,String major_dm,String college_dm)
	{
		// select * from t_recommend limit 1,10
		String sql="select a.id,a.time,a.snum,a.teachername from t_recommend as a,t_stu_info as b where a.snum=b.id and b.major_dm='"+major_dm+"' and b.college_dm='"+college_dm+"'  limit "+id+",20";
		List<String[]> list=SqlModel.QueryList(sql);
		
		return list;
	}
	
	/**
	 * 返回推荐表里学生姓名
	 * @param id
	 * @return
	 */
	public static String getRecStuName(String sId)
	{
		String sql="select name from t_stu_info where id='"+sId+"'";
		String name=SqlModel.getInfo(sql);
		
		return name;
	}
	
	/**
	 * 返回他荐表里的学生专业
	 * @param id
	 * @return
	 */
	public static String getRecStuMajor(String sId)
	{
		String sql="select major_dm from t_stu_info where id='"+sId+"'";
		String major_dm=SqlModel.getInfo(sql);
		
		return BaseInfo.getMajorByDM(major_dm);
	}
	
	/**
	 * 返回最后一位同学
	 * @return
	 */
	public static String getRecMaxId()
	{
		String sql="select max(id) from t_recommend";
		//id最大值
		String idMax=SqlModel.getInfo(sql);
		
		return idMax;
	}
	
	//---------------------------------------------------------//
	
	/**
	 * 自荐表里的时间
	 * @param id 自荐表里的自增的id
	 * @return
	 */
	public static String getRecoMeTime(int id)
	{
		String sql="select time from t_self where id='"+id+"'";
		String timeStr=SqlModel.getInfo(sql);
		
		String[] s=timeStr.split(" ");
		
		return s[0];
	}
	
	/**
	 * 他荐表里的时间
	 * @param id
	 * @return
	 */
	public static String getRecOtherTime(int id)
	{
		String sql="select time from t_other where id='"+id+"'";
		String timeStr=SqlModel.getInfo(sql);
		
		String[] s=timeStr.split(" ");
		
		return s[0];
	}
	
	/**
	 * 自荐表里的学号
	 * @param id 自荐表里的自增的id
	 * @return
	 */
	public static String getRecMeStuId(int id)
	{
		String sql="select snum from t_self where id='"+id+"'";
		String snum=SqlModel.getInfo(sql);
		return snum;
	}
	
	/**
	 * 他荐表里的学号
	 * @param id
	 * @return
	 */
	public static String getRecOtherStuId(int id)
	{
		String sql="select snum from t_other where id='"+id+"'";
		String snum=SqlModel.getInfo(sql);
		return snum;
	}
	
	/**
	 * 返回学生姓名
	 * @param id 推荐表里的自增的id
	 * @return
	 */
	public static String getStuMeName(int id)
	{
		//获取学号
		String sId= getRecMeStuId(id);
		String sql="select name from t_stu_info where id='"+sId+"'";
		String name=SqlModel.getInfo(sql);
		
		return name;
	}
	
	/**
	 * 返回他荐表里学生姓名
	 * @param id
	 * @return
	 */
	public static String getStuOtherName(int id)
	{
		//获取学号
		String sId= getRecOtherStuId(id);
		String sql="select name from t_stu_info where id='"+sId+"'";
		String name=SqlModel.getInfo(sql);
		
		return name;
	}
	
	/**
	 * 根据id查询专业名称
	 * @param id
	 * @return
	 */
	public static String getStuMeMajor(int id)
	{
		String sId= getRecMeStuId(id);
		String sql="select major_dm from t_stu_info where id='"+sId+"'";
		String major_dm=SqlModel.getInfo(sql);
		
		return BaseInfo.getMajorByDM(major_dm);
	}
	
	/**
	 * 返回他荐表里的学生专业
	 * @param id
	 * @return
	 */
	public static String getStuOtherMajor(int id)
	{
		String sId= getRecOtherStuId(id);
		String sql="select major_dm from t_stu_info where id='"+sId+"'";
		String major_dm=SqlModel.getInfo(sql);
		
		return BaseInfo.getMajorByDM(major_dm);
	}
	
	/**
	 * 返回他荐表学生姓名
	 * @param id
	 * @return
	 */
	public static String getStuOtherTeaName(int id)
	{
		String sql="select teachername from t_other where id='"+id+"'";
		String teacherName=SqlModel.getInfo(sql);
		
		return teacherName;
	}
	
	/**
	 * 获取自荐表最大id
	 * @return
	 */
	public static int getRecMeMaxId()
	{
		String sql="select max(id) from t_self";
		//id最大值
		String idMax=SqlModel.getInfo(sql);
		//String page=(Integer.valueOf(idMax)/20+1)+"";
		
		return Integer.valueOf(idMax);
	}
	
	/**
	 * 获取他荐表最大id
	 * @return
	 */
	public static int getRecOtherMaxId()
	{
		String sql="select max(id) from t_other";
		//id最大值
		String idMax=SqlModel.getInfo(sql);
		
		return Integer.valueOf(idMax);
	}
}
