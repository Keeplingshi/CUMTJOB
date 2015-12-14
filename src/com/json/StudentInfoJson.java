package com.json;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.info.BaseInfo;

public class StudentInfoJson {

	/**
	 * 学生基本信息的json
	 * @param id
	 * @return
	 */
	public static String stuInfoJson(String id)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		
		String[] stu=BaseInfo.getStuInfo(id);
		
		jsonObject.put("name", stu[0]);
		jsonObject.put("profession", stu[1]);
		jsonObject.put("telNumber", stu[2]);
		jsonObject.put("eMail", stu[3]);
		jsonObject.put("intent", stu[4]);
		jsonObject.put("briefIntroduce", stu[5]);
		jsonObject.put("personRecommend", stu[6]);
		jsonObject.put("collegeRecommend", stu[7]);
		jsonObject.put("schoolRecommend", stu[8]);
		jsonObject.put("userFace", stu[9]);
		
		jsonArray.add(jsonObject);
		return jsonArray.toString();
		
	}
	
	/**
	 * 提供给学生更新数据页面的json
	 * @param id
	 * @return
	 */
	public static String stuInfoUpdateJson(String id)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		
		String[] stu=BaseInfo.getStuInfo(id);
		
		jsonObject.put("name", stu[0]);
		jsonObject.put("profession", stu[1]);
		jsonObject.put("telNumber", stu[2]);
		jsonObject.put("eMail", stu[3]);
		jsonObject.put("studentId", id);
		jsonObject.put("userFace", stu[9]);
		
		jsonArray.add(jsonObject);
		return jsonArray.toString();
	}
	
}
