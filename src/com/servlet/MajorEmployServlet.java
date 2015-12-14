package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.MajorEmployJson;

public class MajorEmployServlet extends HttpServlet{

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
    	
    	String major=request.getParameter("major");
    	String college=request.getParameter("collegename");
    	
    	response.getWriter().write(MajorEmployJson.EmployJson(college,major));
    	
//    	String page = request.getParameter("page");
//    	response.getWriter().write(RecommendTool.RecoMeJson(page));
    }
	
}
