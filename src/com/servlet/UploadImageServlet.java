package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sql.SqlModel;

public class UploadImageServlet extends HttpServlet{

	List piclist=new ArrayList();  //放上传的图片名
	
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
    	System.out.println("是否调用");
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=UTF-8");
    	String id="";
    	
    	String path=request.getSession().getServletContext().getRealPath("/")+"recommend/";
    	System.out.println(path);
        File file=new File(path);
        if(!file.exists()){
        	file.mkdirs();
        }
        
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload sfu=new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");  //处理中文问题
        sfu.setSizeMax(1024*1024);   //限制文件大小
        
        try {
            List<FileItem> fileItems= sfu.parseRequest(request);  //解码请求 得到所有表单元素
            for (FileItem fi : fileItems) {
                //有可能是 文件，也可能是普通文字 
                if (fi.isFormField()) { //这个选项是 文字 
                	if(fi.getFieldName().equals("uid")){
                		id=fi.getString();
                	}
                }else{
                    // 是文件
                    String fn=fi.getName();
                    String fname=System.currentTimeMillis()+".jpg";
                    
                    System.out.println("文件名是："+fn);  //文件名 
                    // fn 是可能是这样的 c:\abc\de\tt\fish.jpg
                    fi.write(new File(path,fname));
                    if (fname.endsWith(".jpg")) {
                    	piclist.add(fname);  //把图片放入集合
                    }
                    
                    String sql="update t_recommend set url='"+fname+"' where snum='"+id+"'";
                    SqlModel.Update(sql);
                }                
            }    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(id);
    }
	
}
