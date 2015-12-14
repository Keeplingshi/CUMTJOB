package com.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.info.BaseInfo;
import com.info.RecommendInfo;
import com.sql.SqlModel;
import com.util.JsonCompare;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RecommendJson {

	/**
	 * 根据页面查找推荐信息
	 * @param page
	 * @return
	 */
	public static String RecInfoJson(String page,String college_name,String major_name)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		
		int id=(Integer.valueOf(page)-1)*20;
		String major_dm=BaseInfo.getDMByMajor(major_name);
		String college_dm=BaseInfo.getCollegeDMByName(college_name);
		
		System.out.println("学院代码："+college_dm+"专业代码: "+major_dm);
		
		List<String[]> list=RecommendInfo.getRecInfo(id,major_dm,college_dm);
		for(int i=0;i<list.size();i++)
		{
			String[] sArray=list.get(i);
			
			String maxId=RecommendInfo.getRecMaxId();
			String isEnd="0";
			if(sArray[0].equals(maxId)){
				isEnd="1";
			}
			
			String[] s=sArray[1].split(" ");
			
			jsonObject.put("recommendTime", s[0]);
			jsonObject.put("studentId", sArray[2]);
			jsonObject.put("studentName", RecommendInfo.getRecStuName(sArray[2]));
			jsonObject.put("profession", RecommendInfo.getRecStuMajor(sArray[2]));
			jsonObject.put("teacherName", sArray[3]);
			jsonObject.put("isEnd", isEnd);	
			
			jsonArray.add(jsonObject);
		}
		
		System.out.println(jsonArray.toString());
		return jsonArray.toString();
		
//		JSONObject jsonObject=new JSONObject();	//{}
//		JSONArray jsonArray=new JSONArray();	//[]
//		
//		int maxId=RecommendInfo.getRecOtherMaxId();
//		
//		//求出起始id
//		int id=(Integer.valueOf(page)-1)*20+1;
//		for(int i=id;i<id+20;i++)
//		{
//			if(i>maxId){
//				break;
//			}
//			
//			String isEnd="0";
//			if(i==maxId){
//				isEnd="1";
//			}
//			
//			jsonObject.put("recommendTime", RecommendInfo.getRecOtherTime(i));
//			jsonObject.put("studentId", RecommendInfo.getRecOtherStuId(i));
//			jsonObject.put("studentName", RecommendInfo.getStuOtherName(i));
//			jsonObject.put("profession", RecommendInfo.getStuOtherMajor(i));
//			jsonObject.put("teacherName", RecommendInfo.getStuOtherTeaName(i));
//			jsonObject.put("isEnd", isEnd);	
//			//System.out.println(isEnd);
//			
//			jsonArray.add(jsonObject);
//		}
//		
//		//System.out.println(jsonArray.toString());
//		return sortJsonArrayByDate(jsonArray,"recommendTime").toString();
	}
	
	/**
	 * 自荐表需要的json
	 * @param page
	 * @return
	 */
	public static String RecoMeJson(String page)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		
		int maxId=RecommendInfo.getRecMeMaxId();
		
		//求出起始id
		int id=(Integer.valueOf(page)-1)*20+1;
		for(int i=id;i<id+20;i++)
		{
			if(i>maxId){
				break;
			}
			
			String isEnd="0";
			if(i==maxId){
				isEnd="1";
			}
			
			jsonObject.put("recommendTime", RecommendInfo.getRecoMeTime(i));
			jsonObject.put("studentId", RecommendInfo.getRecMeStuId(i));
			jsonObject.put("studentName", RecommendInfo.getStuMeName(i));
			jsonObject.put("profession", RecommendInfo.getStuMeMajor(i));
			jsonObject.put("isEnd", isEnd);		
			
			jsonArray.add(jsonObject);
		}
		
		return sortJsonArrayByDate(jsonArray,"recommendTime").toString();
	}
	
	/**
	 * 他荐需要的json
	 * @param page
	 * @return
	 */
	public static String RecoOtherJson(String page)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		
		int maxId=RecommendInfo.getRecOtherMaxId();
		
		//求出起始id
		int id=(Integer.valueOf(page)-1)*20+1;
		for(int i=id;i<id+20;i++)
		{
			if(i>maxId){
				break;
			}
			
			String isEnd="0";
			if(i==maxId){
				isEnd="1";
			}
			
			jsonObject.put("recommendTime", RecommendInfo.getRecOtherTime(i));
			jsonObject.put("studentId", RecommendInfo.getRecOtherStuId(i));
			jsonObject.put("studentName", RecommendInfo.getStuOtherName(i));
			jsonObject.put("profession", RecommendInfo.getStuOtherMajor(i));
			jsonObject.put("teacherName", RecommendInfo.getStuOtherTeaName(i));
			jsonObject.put("isEnd", isEnd);	
			//System.out.println(isEnd);
			
			jsonArray.add(jsonObject);
		}
		
		//System.out.println(jsonArray.toString());
		return sortJsonArrayByDate(jsonArray,"recommendTime").toString();
	}
	
	/**
	 * json排序
	 * @param mJSONArray
	 * @param dateName
	 * @return
	 */
	public static JSONArray sortJsonArrayByDate(JSONArray mJSONArray,String dateName){
	    List<JSONObject> list = new ArrayList<JSONObject> ();
	    JSONObject jsonObj = null;
	    for (int i = 0; i < mJSONArray.size(); i++) {
	        jsonObj = mJSONArray.optJSONObject(i);
	        list.add(jsonObj);
	    }
	    //排序操作
	    JsonCompare pComparator =  new JsonCompare(dateName);
	    Collections.sort(list, pComparator);
	    
	    //把数据放回去 
	    mJSONArray = new JSONArray();
	    for (int i = 0; i < list.size(); i++) {
	        jsonObj = list.get(i);
	        mJSONArray.add(jsonObj);
	    }
	    
	    return mJSONArray;
	}
	
}
