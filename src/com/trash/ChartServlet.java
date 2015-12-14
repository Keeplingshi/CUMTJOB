package com.trash;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.HistogramJson;
import com.json.PieJson;

public class ChartServlet extends HttpServlet{

	public ChartServlet(){
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
    	
    	//System.out.println(ChartTool.chartJson());
    	//response.getWriter().write(ChartTool.chartJson());
    	//response.getWriter().write(PieTool.chartJson());
    	//response.getWriter().write(HistogramTool.histogramCollegeJson());
    	response.getWriter().write(HistogramJson.histogramMajorJson("安全学院"));
    }
	
}
