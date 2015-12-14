<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>修改密码</title>
<link rel="Shortcut Icon" href="image/favicon.ico" />
<meta name="description" content="">
<meta name="keywords" content="">
<link href="css/password.css" rel="stylesheet">
</head>
<body>
    <!-- 头部 -->
    <div class="head"><img src="image/head.jpg"></div>
<!-- 导航栏部分 -->
    <div class="nav">
		<ul>
			<li><a href="http://www.cumt.edu.cn/">首页</a></li>
			<li>
				就业进展
				<ul class="list">
					<li><a href="histCollege.jsp">学院进展</a></li>
					<li><a href="histMajor.jsp">专业进展</a></li>
					<li><a href="index.jsp">全校概览</a></li>
				</ul>
			</li>
			<li><a href="tuijian.jsp">学生信息</a></li>
			<li>
				联系我们
				<ul>
					<li><a href="link.jsp">就业联系人</a></li>
					<li><a href="http://cumt.91job.gov.cn/">就业指导</a></li>
				</ul>
			</li>
			<li  style="float:right;"><a href="sclogin.jsp">登录</a></li>
		</ul>
    </div>
<!--导航栏结束-->
<!--中间开始-->
<div class="navcenter">
    <div class="navmiddle">
    
    <img src="image/password.jpg">
    <div class="navRight">
    <h2>修改密码</h2>
    <form method="post" action="UpdatePassword">
    <p>请输入旧密码：<input type="password" id="old" name = "oldpassword"><span class="hidden">密码不能为空！</span></p>
    <p>请输入新密码：<input type="password" id="new" name = "newpassword"></p>
    <p>请确认新密码：<input type="password" id="renew"><span class="hidden">两次输入的密码不一致！</span></p>
    <div class="obutton">
    <input type="submit" value="提交" class="obtn"><input type="reset" value="取消" class="obtn">
    </div>
    </form>
    </div>
    
    </div>
</div>
<!--中间结束-->
<!--尾部开始-->
<div class="foot"><img src="image/foot.jpg"></div>
<!--尾部结束-->
<script type="text/javascript">
window.onload = function(){
    var oSubmit = document.getElementsByTagName('input');
    var oSpan = document.getElementsByTagName('span')
    oSubmit[3].onclick = function(){
        if(oSubmit[0].value == ''){oSpan[0].className = 'appear'}
            else{oSpan[0].className = 'hidden'};
        if(oSubmit[1].value != oSubmit[2].value){oSpan[1].className = 'appear'}
            else{oSpan[1].className = 'hidden'};
    }
}
</script>

</body>
</html>