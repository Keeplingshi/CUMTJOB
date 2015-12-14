package com.json;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.info.BaseInfo;

/**
 * majorEmployServlet.do  majoremploy.jsp页面
 * 某专业学生就业状态
 * @author Keeplingshi
 *
 */
public class MajorEmployJson {

	/**
	 * 专业就业状态json
	 * @param college_name
	 * @param major_name
	 * @return
	 */
	public static String EmployJson(String college_name,String major_name)
	{
		
		JSONObject jsonObject=new JSONObject();	//{}
		JSONArray jsonArray=new JSONArray();	//[]	
		
		String major_dm=BaseInfo.getDMByMajor(major_name);
		String college_dm=BaseInfo.getCollegeDMByName(college_name);
		
		List<String[]> jsonList=BaseInfo.getMajorStuInfoList(college_dm,major_dm); 
		for(String[] s:jsonList)
		{
			jsonObject.put("studentName", s[0]);
			jsonObject.put("employmentStatus", s[1]);
			jsonObject.put("studentId", s[2]);
			
			jsonArray.add(jsonObject);
		}
		
		//System.out.println(jsonArray.toString());
		return jsonArray.toString();
	}
	
	
}
