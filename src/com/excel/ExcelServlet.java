package com.excel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ExcelServlet extends HttpServlet{
	
    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException  
    {  
    	doPost(request,response);
    }  
  
    @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException  
    {  
        // TODO Auto-generated method stub  
    	request.setCharacterEncoding("utf-8");
    	String savePath=ExcelDo.doSave(request);
		List<ArrayList<String>> excelList=ExcelDo.getData(savePath);
		boolean b=ExcelDo.saveData(excelList); 
        
        response.setContentType("text/html"); 
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter(); 
        if(b){
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"); 
            out.println("<HTML>"); 
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>"); 
            out.println("  <BODY>"); 
            out.print("文件保存在："+savePath);
            out.print("数据写入数据库成功");
            out.println("  </BODY>"); 
            out.println("</HTML>"); 
            out.flush(); 
            out.close();        	
        }else{
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"); 
            out.println("<HTML>"); 
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>"); 
            out.println("  <BODY>");
            out.print("数据写入失败");
            out.println("  </BODY>"); 
            out.println("</HTML>"); 
            out.flush(); 
            out.close();
        }  
    } 

}
