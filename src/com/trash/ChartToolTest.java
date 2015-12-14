package com.trash;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.sql.SqlModel;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ChartToolTest {
	
	/**
	 * 传入二维数组cPercent，返回json数据，供前台解析
	 * @param cPercent
	 * @return
	 */
	public static String chartJson()
	{
		//获取多少种工作状态，例如 求职，就业，出国等
    	String sql="select name from t_dm_job";
		List<String> cName=SqlModel.QueryArray(sql);
		
		List<String[]> cPercent=chartSql(cName);
		
		String[] cType={"all","undergraduate","postgraduate"};
		JSONObject jObject=new JSONObject();
		
		for(int i=0;i<3;i++)
		{
	    	JSONArray jsonArray = new JSONArray();
	    	JSONObject jsonObject=new JSONObject();
	    	for(int j=0;j<cName.size();j++)
	    	{
	        	jsonObject.put("name", cName.get(j));
	        	jsonObject.put("value", cPercent.get(i)[j]);
	        	jsonArray.add(jsonObject);    		
	    	}		
	    	
	    	jObject.put(cType[i], jsonArray);
		}
		
    	return jObject.toString(); 
	}
	
	private static List<String[]> chartSql(List<String> cName)
	{
		List<String[]> cPercent=new ArrayList<String[]>();
		DecimalFormat df= new DecimalFormat("######0.00");   
		
		String allSql="select count(*) from t_stu_info as a,t_dm_job as b where a.job_dm=b.dm";
		String allCount=SqlModel.getInfo(allSql);
		double allCountNumber=Double.parseDouble(allCount);
		
		for(int i=0;i<3;i++)
		{
			String[] s=new String[cName.size()];
			for(int j=0;j<cName.size();j++)
			{
				String sql="";
				if(i==0){
					sql="select count(*) from t_stu_info as a,t_dm_job as b where a.job_dm=b.dm and b.name='"+cName.get(j)+"'";
				}else if(i==1){
					sql="select count(*) from t_stu_info as a,t_dm_job as b where a.job_dm=b.dm and a.degree='0' and b.name='"+cName.get(j)+"'";
				}else{
					sql="select count(*) from t_stu_info as a,t_dm_job as b where a.job_dm=b.dm and a.degree='1' and b.name='"+cName.get(j)+"'";
				}
				
				double countNumber=Double.parseDouble(SqlModel.getInfo(sql));
				double percent=(countNumber/allCountNumber)*100;
				df.format(percent);
				s[j]=String.valueOf(percent); 
				
			}
			cPercent.add(s);
		}
		
		System.out.println("------------------------");
		for(String[] s:cPercent)
		{
			for(String c:s){
				System.out.print(c+"\t");
			}
			System.out.println();
		}
		System.out.println("------------------------");
		return cPercent;
	}
}
