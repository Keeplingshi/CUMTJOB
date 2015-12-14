package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sql.SqlModel;
import com.util.MD5Util;

public class Sign_In extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Sign_In() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("username");
		String password = MD5Util.MD5(request.getParameter("password"));
		String type = request.getParameter("RadioButtonList1");
		if("学生".equals(type)){
			
			String sqlIsExist="select id from t_stu_account where id='"+id+"'";
			String isExistsResult=SqlModel.getInfo(sqlIsExist);
			if((!isExistsResult.equals(""))&&(isExistsResult!=null)){
				String sql = "select password from t_stu_account where id = '" + id + "';";
				if(password.equals(SqlModel.getInfo(sql))){
					request.getSession().setAttribute("id", id);
					//request.getSession().setAttribute("type", type);
					response.sendRedirect("updateInfo.jsp");
				}else{
					out.write("<script language='javascript'>alert('用户名或密码错误'); window.location.href='sclogin.jsp'; </script>");

					out.close();
				}				
			}else{
				out.write("<script language='javascript'>alert('用户名不存在'); window.location.href='sclogin.jsp'; </script>");
			}
			

		}else if("学校".equals(type)||"学院".equals(type)){
			
			String sqlIsExist="select id from t_admin_account where id='"+id+"'";
			String isExistsResult=SqlModel.getInfo(sqlIsExist);
			if((!isExistsResult.equals(""))&&(isExistsResult!=null)){
				String sql = "select password from t_admin_account where id = '" + id +"';";
				if(password.equals(SqlModel.getInfo(sql))){
					request.getSession().setAttribute("id", id);
					request.getSession().setAttribute("type", type);
					response.sendRedirect("password.jsp");
				}else{
					out.write("<script language='javascript'>alert('用户名或密码错误'); window.location.href='sclogin.jsp'; </script>");

					out.close();
				}				
			}else{
				out.write("<script language='javascript'>alert('用户名不存在'); window.location.href='sclogin.jsp'; </script>");
			}

		}else{
			out.write("<script language='javascript'>alert('登录信息出错'); window.location.href='sclogin.jsp'; </script>");
			out.close();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
