package com.sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlModel {
	
	/**
	 * 根据sql语句查询信息
	 * @param sql
	 * @return
	 */
	public static String getInfo(String sql)
	{
		String content="";
		SqlHelper sh=new SqlHelper();
		ResultSet rs=sh.Query(sql);
		
		try {
			while(rs.next())
			{
				content=rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sh.close();
		}
		
		return content;
		//return content;
	}
	
	/**
	 * 查询某一字段的所有数据，以list形式返回
	 * @param sql
	 * @return
	 */
	public static List<String> QueryArray(String sql)
	{
		List<String> list=new ArrayList<String>();
		SqlHelper sh=new SqlHelper();
		ResultSet rs=sh.Query(sql);
		
		try {
			while(rs.next())
			{
				list.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sh.close();
		}
		
		return list;
	}
	
	/**
	 * 根据多个字段查询数据库，以List<String[]> 返回
	 * @param sql
	 * @param paras
	 * @return
	 */
	public static List<String[]> QueryList(String sql)
	{
		List<String[]> list=new ArrayList<String[]>();
		SqlHelper sh=new SqlHelper();
		ResultSet rs=sh.Query(sql);
		
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			while(rs.next())
			{
				String[] temp=new String[metaData.getColumnCount()];
				for(int i=0;i<metaData.getColumnCount();i++)
				{
					temp[i]=rs.getString(i+1);
				}
				list.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sh.close();
		}
		return list;
	}
	
	/**
	 * 更新单句sql语句
	 * @param sql
	 * @return
	 */
	public static boolean Update(String sql)
	{
		boolean b = true;
		SqlHelper sh = new SqlHelper();
		try {
			b = sh.Update(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		} finally {
			sh.close();
		}
		return b;
	}
	
	/**
	 * 多字段查询
	 * @param sql
	 * @param paras
	 * @return
	 */
	public static String Query(String sql,String paras[]) {
		String str = "";
		SqlHelper sh = new SqlHelper();

		ResultSet rs = sh.Query(sql, paras);
		try {
			while (rs.next()) {
				str = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sh.close();
		}
		return str;
	}
	
	/**
	 * 多字段更新
	 * @param sql
	 * @param paras
	 * @return
	 */
	public static boolean Update(String sql,String[] paras )
	{
		boolean b = true;
		SqlHelper sh = new SqlHelper();
		try {
			b = sh.Update(sql,paras);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		} finally {
			sh.close();
		}
		return b;
	}
}
