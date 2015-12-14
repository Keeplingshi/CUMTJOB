package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.UpdateStu;
import com.json.StudentInfoJson;

public class UpdateStuServlet extends HttpServlet{

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
    	
    	//data:{"id":id,"teachername":teachername,"intent":intent,"intro":intro},
    	String id = request.getParameter("id");
    	String teachername=request.getParameter("teachername");
    	String intent=request.getParameter("intent");
    	String intro=request.getParameter("intro");
    	
    	if(UpdateStu.updateInfo(id, teachername, intent, intro)){
    		response.getWriter().write("修改成功");
    	}else{
    		response.getWriter().write("修改失败");
    	}
    	
    	
    	//response.getWriter().write(StudentInfoJson.stuInfoUpdateJson(id));
    }
	
}
