package com.json;

import java.util.ArrayList;
import java.util.List;

import com.info.RateCount;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PieJson {

	/**
	 * 返回json数据，供前台解析
	 * @return
	 */
	public static String pieJson()
	{	
		List<String[]> cPercent=chartSql();
		
		String[] cIswork={"就业","求职中","升学"};
		String[] cType={"all","undergraduate","postgraduate"};
		
		JSONObject jObject=new JSONObject();
		for(int i=0;i<cType.length;i++)
		{
	    	JSONArray jsonArray = new JSONArray();
	    	JSONObject jsonObject=new JSONObject();
	    	for(int j=0;j<cIswork.length;j++)
	    	{
	        	jsonObject.put("name", cIswork[j]);
	        	jsonObject.put("value", cPercent.get(i)[j]);
	        	jsonArray.add(jsonObject);    		
	    	}		
	    	
	    	jObject.put(cType[i], jsonArray);
		}
		
		return jObject.toString(); 
	}
	
	/**
	 * 返回饼图比例的统计数据
	 * @return
	 */
	private static List<String[]> chartSql()
	{
		List<String[]> cPercent=new ArrayList<String[]>();
		
		for(int i=0;i<3;i++)
		{
			String[] temp={RateCount.jobCount(i)+"",RateCount.notEmployCount(i)+"",RateCount.upEduCount(i)+""};

			cPercent.add(temp);
		}
		
		return cPercent;
	}
}
