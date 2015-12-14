<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="Shortcut Icon" href="image/favicon.ico" />
<script type="text/javascript" src="js/md5.js"></script> 
  </head>
 
  <body>
     <div class="top">
    

  <div style="position:relative;">
   <img src="image/beijing2.jpg" width="100%" height="700" />
   <div style="position:absolute; left:700px; top:290px; /* border:#000 solid 1px; */">
   请登录：
    <form name="form1" method="post" action="Sign_In" >
    
    
 账号:
 
 <input id="name" name="username" type="text" size="15"><br />
 密码: 
 <input id="pass" name="password" type="password" size="15"  ">
 <br />

 
 <table id="RadioButtonList1" border="0">
<tbody>
<tr>
<td>
<input id="RadioButtonList1_0" type="radio" tabindex="4" value="学校" name="RadioButtonList1">
<label for="RadioButtonList1_0">学校</label>
</td>
<td>
<input id="RadioButtonList1_1" type="radio" tabindex="4" value="学院" name="RadioButtonList1">
<label for="RadioButtonList1_1">学院</label>
</td>
<td>
<input id="RadioButtonList1_2" type="radio" tabindex="4" checked="checked" value="学生" name="RadioButtonList1">
<label for="RadioButtonList1_2">学生</label>
</td>
<td>
</tr>
</tbody>
</table>

<input name="submit" type="submit" value="提交" size="15"   onclick="check()" />
 
 </form>
   </div>
</div>
  </body>
</html>
