package com.json;

import com.info.BaseInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class CMDetailJson {

	/**
	 * 获取学院以及相应专业的json
	 * @param collegeName
	 * @return
	 */
	public static String CollegeDetailJson(String collegedm)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		
		String collegeName=BaseInfo.getCollegeNameByDM(collegedm);
		
		jsonObject.put("collegeName", collegeName);
		jsonObject.put("profession", BaseInfo.getmajorAllName(collegeName));
		
		jsonArray.add(jsonObject);
		
		return jsonArray.toString();
	}
	
	/**
	 * 获取单专业信息
	 * @param major_dm
	 * @return
	 */
	public static String MajorDetailJson(String major_dm)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		
		String collegeName=BaseInfo.getCollegeByMajor(major_dm);
		
		jsonObject.put("collegeName", collegeName);
		jsonObject.put("profession", BaseInfo.getMajorByDM(major_dm));
		
		jsonArray.add(jsonObject);
		
		return jsonArray.toString();
	}
	
}
