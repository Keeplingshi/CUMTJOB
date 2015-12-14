package com.sql;

import java.sql.*;

import javax.swing.JOptionPane;

public class SqlHelper {

	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	String driver="com.mysql.jdbc.Driver";
	
//	String user="root";
//	String passwd="root";
//	String url="jdbc:mysql://202.119.206.69:3306/cumtjob?characterEncoding=utf8";
	
	String user="root";
	String passwd="root";
	String url="jdbc:mysql://localhost:3306/cumtjob?characterEncoding=utf8";
	
	/**
	 * 数据库驱动加载
	 */
	public void Driver()
	{
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "数据库连接错误");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * 数据库连接关闭
	 */
	public void close()
	{
		try {
			if(rs!=null) {rs.close();}
			if(ct!=null) {ct.close();}
			if(ps!=null) {ps.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询
	 * @param sql
	 * @return
	 */
	public ResultSet Query(String sql)
	{
		this.Driver();
		try{
			ps = ct.prepareStatement(sql);
			rs=ps.executeQuery();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 结果集
	 * @param sql
	 * @param paras
	 * @return
	 */
	public ResultSet Query(String sql,String []paras)
	{
		this.Driver();
		
		try{
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 更新数据
	 * @param sql
	 * @return
	 */
	public boolean Update(String sql)
	{
		this.Driver();
		boolean b=true;
		try{
			ps=ct.prepareStatement(sql);
			ps.executeUpdate();
		}catch (SQLException e){
			b=false;
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * 更新数据
	 * @param sql
	 * @param paras
	 * @return
	 */
	public boolean Update(String sql,String []paras)
	{
		this.Driver();
		boolean b=true;
		try{
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			ps.executeUpdate();
		}catch (SQLException e){
			b=false;
			e.printStackTrace();
		}
		return b;
	}
	
}
