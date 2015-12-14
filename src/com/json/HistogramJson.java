package com.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.info.BaseInfo;
import com.info.RateCount;
import com.sql.SqlModel;
import com.util.JsonComparator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HistogramJson {

	/**
	 * 学院json
	 * @return
	 */
	public static String histogramCollegeJson(String sortType)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		List<String> collegeList=BaseInfo.getCollege();
		
		for(String college:collegeList)
		{
			jsonObject.put("college", college);
			jsonObject.put("allNum", RateCount.collegeCount(college));
			jsonObject.put("upSchool", RateCount.upEduByCollegeCount(college));
			jsonObject.put("employment", RateCount.employByCollegeCount(college));
			jsonObject.put("abroad", RateCount.abroadByCollegeCount(college));
			jsonObject.put("unEmployment", RateCount.unEmployByCollegeCount(college));
			jsonObject.put("rateFont", RateCount.employPercent(college));
			
			jsonArray.add(jsonObject);
		}
		
		if(sortType.equals("no")){
			return jsonArray.toString();
		}else{
			return sortJsonArray(jsonArray,"rateFont",sortType).toString();
		}
		
	}
	
	/**
	 * 专业json数据
	 * @param college_name
	 * @return
	 */
	public static String histogramMajorJson(String college_name)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		List<String> majorList=BaseInfo.getMajorDMInRate(college_name);
		String college_dm=BaseInfo.getCollegeDMByName(college_name);
		
		//遍历专业代码
		for(String major_dm:majorList)
		{
			jsonObject.put("college", BaseInfo.getMajorByDM(major_dm));
			jsonObject.put("allNum", RateCount.majorCount(major_dm,college_dm));
			jsonObject.put("upSchool", RateCount.upEduByMajorCount(major_dm,college_dm));
			jsonObject.put("employment", RateCount.employByMajorCount(major_dm,college_dm));
			jsonObject.put("abroad", RateCount.abroadByMajorCount(major_dm,college_dm));
			jsonObject.put("unEmployment", RateCount.unEmployByMajorCount(major_dm,college_dm));
			jsonObject.put("rateFont", RateCount.employByMajorPercent(major_dm,college_dm));
			
			jsonArray.add(jsonObject);
		}
		
		return jsonArray.toString();
	}
	
	/**
	 * 返回所有专业的json
	 * @return
	 */
	public static String histAllMajorJson(String sortType)
	{
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]
		List<String> majorList=BaseInfo.getMajorDM();
		//String college_dm=BaseInfo.getCollegeDMByName(college_name);
		
		//遍历专业代码
		for(String major_dm:majorList)
		{
			if(major_dm.equals("79")){
				continue;
			}
			jsonObject.put("college", BaseInfo.getMajorByDM(major_dm));
			jsonObject.put("allNum", RateCount.majorCount(major_dm));
			jsonObject.put("upSchool", RateCount.upEduByMajorCount(major_dm));
			jsonObject.put("employment", RateCount.employByMajorCount(major_dm));
			jsonObject.put("abroad", RateCount.abroadByMajorCount(major_dm));
			jsonObject.put("unEmployment", RateCount.unEmployByMajorCount(major_dm));
			jsonObject.put("college_name", BaseInfo.getCollegeByMajor(major_dm));
			jsonObject.put("college_number", BaseInfo.getCollegeMajorNum(major_dm));
			jsonObject.put("rateFont", RateCount.employByMajorPercent(major_dm));
			
			jsonArray.add(jsonObject);
		}
		
		if(sortType.equals("no")){
			return jsonArray.toString();
		}else{
			return sortJsonArray(jsonArray,"rateFont",sortType).toString();
		}
		
		//return jsonArray.toString();
	}
	
	/**
	 * json排序
	 * @param mJSONArray
	 * @param dateName
	 */
	public static JSONArray sortJsonArray(JSONArray mJSONArray,String dateName,String sortType)
	{
	    List<JSONObject> list = new ArrayList<JSONObject> ();
	    JSONObject jsonObj = null;
	    for (int i = 0; i < mJSONArray.size(); i++) {
	        jsonObj = mJSONArray.optJSONObject(i);
	        list.add(jsonObj);
	    }
	    //排序操作
	    JsonComparator pComparator =  new JsonComparator(dateName);
	    Collections.sort(list, pComparator);
	    
	    //把数据放回去 
	    mJSONArray = new JSONArray();
	    
	    if(sortType.equals("up")){
		    for (int i = 0; i < list.size(); i++) {
		        jsonObj = list.get(i);
		        mJSONArray.add(jsonObj);
		    }    	
	    }else{
		    for (int i = list.size()-1; i >=0 ; i--) {
		        jsonObj = list.get(i);
		        mJSONArray.add(jsonObj);
		    }
	    }
	    
	    return mJSONArray;
	}
}
