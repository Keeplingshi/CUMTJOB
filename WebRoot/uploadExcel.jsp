<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传excel</title>
  </head>
  
	<body>
    
    <form name="uploadform" method="POST" action="/CUMTJOB/excelServlet.do" ENCTYPE="multipart/form-data">

		<input name="fileUpload" size="40" type="file">
        <br/><br/>
        <input name="upload" type="submit" value="开始上传"/>
	</form>

	</body>
  