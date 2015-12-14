package com.trash;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.RecommendJson;

/**
 * 自荐信息的servlet
 * @author Keeplingshi
 *
 */
public class RecomMeServlet extends HttpServlet{

	public RecomMeServlet(){
		super();
	}
	
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
    	response.getWriter().write(RecommendJson.RecoMeJson(page));
    }
	
}
