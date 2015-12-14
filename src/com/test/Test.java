package com.test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.info.BaseInfo;
import com.info.RateCount;
import com.info.RecommendInfo;
import com.info.UpdateStu;
import com.json.CMDetailJson;
import com.json.HistogramJson;
import com.json.MajorEmployJson;
import com.json.PieJson;
import com.json.RecommendJson;
import com.json.StudentInfoJson;
import com.sql.SqlModel;
import com.util.JsonCompare;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Test();
		
	}

	public Test()
	{
		System.out.println(UpdateStu.isExist("08123315"));
		//System.out.println(RecommendJson.RecommendJson("5"));
//		String[] stu=BaseInfo.getStuInfo("01100180");
//		for(String s:stu){
//			System.out.println(s);
//		}
		//System.out.println(MajorEmployJson.EmployJson("计算机学院","计算机科学与技术"));
		//MajorEmployJson.EmployJson("计算机学院","计算机科学与技术" );
		//System.out.println(CollegeDetailTool.CollegeDetailJson("计算机学院"));
		//System.out.println(RecommendInfo.getStuMeName(2));
		
//		JSONObject jsonObject=new JSONObject();	//{}
//		JSONArray jsonArray=new JSONArray();	//[]
//		
//		jsonObject.put("recommendTime", "2012-09-08");
//		jsonArray.add(jsonObject);
//		jsonObject.put("recommendTime", "2013-09-08");
//		jsonArray.add(jsonObject);
//		jsonObject.put("recommendTime", "2015-01-12");
//		jsonArray.add(jsonObject);
//		jsonObject.put("recommendTime", "2014-12-01");
//		jsonArray.add(jsonObject);
//		jsonObject.put("recommendTime", "2014-09-08");
//		jsonArray.add(jsonObject);
//		jsonObject.put("recommendTime", "2013-01-24");
//		jsonArray.add(jsonObject);
//		
//		System.out.println(jsonArray.toString());
//		
//		System.out.println(sortJsonArrayByDate(jsonArray,"recommendTime").toString());
//		
//		
//		String a="50.34%";
//		String[] s=a.split("%");
//		
//		for(int i=0;i<s.length;i++){
//			System.out.println(s[i]);
//		}
		
//		System.out.println(HistogramTool.histogramCollegeJson("no"));
		//System.out.println(RateCount.majorCount("01", "1"));
		
//		JSONObject jsonObject=new JSONObject();	//{}
//		JSONArray jsonArray=new JSONArray();	//[]
//		List<String> majorList=BaseInfo.getMajorDMInRate("矿业学院");
//		
//		for(String major_dm:majorList)
//		{
//			jsonObject.put("college", BaseInfo.getMajorByDM(major_dm));
//			jsonObject.put("allNum", RateCount.majorCount(major_dm));
//			jsonObject.put("upSchool", RateCount.upEduByMajorCount(major_dm));
//			jsonObject.put("employment", RateCount.employByMajorCount(major_dm));
//			jsonObject.put("abroad", RateCount.abroadByMajorCount(major_dm));
//			jsonObject.put("unEmployment", RateCount.unEmployByMajorCount(major_dm));
//			jsonObject.put("rateFont", RateCount.employByMajorPercent(major_dm));
//			
//			jsonArray.add(jsonObject);
//		}
//		System.out.println(jsonArray.toString());
//		
//		HistogramTool.sortJsonArrayByDate(jsonArray, "rateFont");
		
		//System.out.println(jsonArray.toString());
		//jsonArray.toString();
		
//		String sql="select count(*) from t_stu_info";
//		System.out.println(SqlModel.getInfo(sql));
//		String sql0="select count(*) from t_stu_info where job_dm='0'";
//		System.out.println(SqlModel.getInfo(sql0));
		
//    	String sql="select dm,name from t_dm_job";
//		SqlModel.QueryArray(sql);
		
		
		
//		String sql="select dm,name from t_dm_job";
//		List<String[]> list=SqlModel.QueryList(sql);
//		
//		for(String[] s:list)
//		{
//			for(String c:s){
//				System.out.print(c+"\t");
//			}
//			System.out.println();
//		}
		
//		RateCount.schoolCount();
//		RateCount.collegeCount("1");
//		RateCount.majorCount("50");
//		RateCount.postGraduateCount();
//		RateCount.underGraduateCount();
		
//		PieTool.chartJson();
		
//		System.out.println(HistogramTool.histogramJson());
		
//		List<String> list=HistogramTool.getCollege();
//		for(String s:list)
//		{
//			System.out.println(s);
//		}
		
//		List<String> collegeList=HistogramTool.getCollege();
//		
//		for(String college:collegeList)
//		{
//			System.out.println(RateCount.collegeCount(college));
//		}
		
//		System.out.println(RateCount.employPercent("矿业学院"));
		
//		List<String> majorList=BaseInfo.getMajorDMInRate("安全学院");
//		
//		for(String major:majorList)
//		{
//			System.out.println(major);
//		}
		
//		System.out.println(RateCount.upEduByMajorCount("01"));
	}

	public JSONArray sortJsonArrayByDate(JSONArray mJSONArray,String dateName){
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
