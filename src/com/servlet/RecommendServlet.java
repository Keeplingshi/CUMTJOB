package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.RecommendJson;
import com.util.StrTool;

public class RecommendServlet extends HttpServlet{

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         //Add some codes
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=UTF-8");
    	
    	String page = request.getParameter("page");
    	String college_name = StrTool.UTF82String(request.getParameter("college_name"));
    	String major_name = StrTool.UTF82String(request.getParameter("major_name"));
    	
    	System.out.println(page+" "+college_name+" "+major_name);

    	response.getWriter().write(RecommendJson.RecInfoJson(page,college_name,major_name));
    }
	
}
