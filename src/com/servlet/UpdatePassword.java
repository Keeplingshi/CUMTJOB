package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sql.SqlModel;
import com.util.MD5Util;

public class UpdatePassword extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdatePassword() {
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
		
		
		if(request.getSession().getAttribute("id")!=null){
			String id = (String) request.getSession().getAttribute("id");
			System.out.println(request.getParameter("oldpassword"));
			String oldpassword = MD5Util.MD5(request.getParameter("oldpassword"));
			String newpassword = MD5Util.MD5(request.getParameter("newpassword"));
			if(request.getSession().getAttribute("type")!=null&&request.getSession().getAttribute("type").equals("学生")){
				String sql = "select password from t_stu_account where id = '"+ id +"'";
				if(oldpassword.equals(SqlModel.getInfo(sql))){
					boolean b = SqlModel.Update("update t_stu_account set password='" + newpassword + "' where id='" + id +"'");
					if(b){
						out.write("<script language='javascript'>alert('更改密码成功'); window.location.href='histogram.html'; </script>");
					}else{
						out.write("<script language='javascript'>alert('更改密码失败'); window.location.href='password.html'; </script>");
					}
				}else {
					
				out.write("<script language='javascript'>alert('原始密码错误'); window.location.href='password.html'; </script>");
				}
			}else if(request.getSession().getAttribute("type")!=null&&(request.getSession().getAttribute("type").equals("学院")||request.getSession().getAttribute("type").equals("学校")||request.getSession().getAttribute("type").equals("3"))){
				String sql = "select password from t_admin_account where id = '"+ id +"'";
				int type =  Integer.parseInt((String) request.getSession().getAttribute("type"));
				if(oldpassword.equals(SqlModel.getInfo(sql))){
					boolean b = SqlModel.Update("update t_admin_account set password='" + newpassword + "' where id='" + id +"'");
					if(b){
						out.write("<script language='javascript'>alert('更改密码成功'); window.location.href='histogram.html'; </script>");
					}else{
						out.write("<script language='javascript'>alert('更改密码失败'); window.location.href='password.html'; </script>");
					}
				}else{
					out.write("<script language='javascript'>alert('原始密码错误'); window.location.href='password.html'; </script>");
				}
				
			}else{
				System.out.println(request.getSession().getAttribute("type"));
				out.write("<script language='javascript'>alert('登录状态未识别'); window.location.href='sclogin.jsp'; </script>");

			}
		}else{
			response.sendRedirect("#");
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
