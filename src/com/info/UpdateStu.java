package com.info;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sql.SqlModel;

public class UpdateStu {

	/**
	 * 更新信息
	 * @param id
	 * @param teachername
	 * @param intent
	 * @param intro
	 * @return
	 */
	public static boolean updateInfo(String id,String teachername,String intent,String intro)
	{
		//System.out.println(id+" "+teachername+" "+intent+" "+intro);
		String sqlInfo="update t_stu_info set employment='"+intent+"',intro='"+intro+"' where id='"+id+"'";
		String sqlRec="";
		
		if(isExist(id)){
			sqlRec="update t_recommend set teachername='"+teachername+"' where snum='"+id+"'";
		}else{
		    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		    String date=sdformat.format(new Date());
		    
			String state="0";
			if((!teachername.equals(""))||teachername!=null){
				state="1";
			}
			sqlRec="insert into t_recommend (snum,time,teachername,state) values ('"+id+"','"+date+"','"+teachername+"','"+state+"')";
		}
		
		boolean b=SqlModel.Update(sqlInfo);
		boolean c=SqlModel.Update(sqlRec);
		
		if(b&&c){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static boolean isExist(String id)
	{
		String sql="select id from t_recommend where snum='"+id+"'";
		String result=SqlModel.getInfo(sql);
		if(result==null||result.equals("")){
			return false;
		}
		
		return true;
	}
	
}
