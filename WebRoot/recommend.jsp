<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>学生信息</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="Shortcut Icon" href="image/favicon.ico" />
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.7.2.js"> </script> 
<link rel="stylesheet" href="css/recommend.css">
</head>
<body>
    <!-- 头部开始 -->
    <div class="head"><a href="http://www.cumt.edu.cn/"><img src="image/head.jpg"></a></div>
    <!-- 头部结束 -->
    <!-- 导航栏开始 -->
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
    <!-- 导航栏结束 -->

    <!-- 中间部分 -->
    <div class="centers">
        <div class="info-head makeCenter">
            <h2>推荐信息</h2>
        </div>
        <div class="info">
            <table border="1" class="informationTable"></table>
            <div class="turning">
            	<input class="pageTurning" value="上一页" type="button" />
            	<input class="pageTurning" value="下一页" type="button" />
            </div>
        </div>
    </div>
    <!-- 中间部分 -->

    <!-- 脚部开始 -->
    <div class="foot"><img src="image/foot.jpg"></div>
    <!-- 脚部结束 -->

    <script src="js/function.js"></script>
    <script src="js/recommend.js"></script>
</body>
</html>