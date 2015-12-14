<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<link rel="Shortcut Icon" href="image/favicon.ico" />
	<link href="css/histogram.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.7.2.js"> </script> 
	<title>学院就业进度条</title>
</head>

<body>
	<!-- 头部 -->
	<div class="head">
		<a href="http://www.cumt.edu.cn/"><img src="image/head.jpg"></a>
	</div>
	<!-- 头部 -->

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


	<div class="navcenter">
		<div class="centerTop makeCenter">
			<!-- 1212 -->
			<h2>中国矿业大学2016届毕业生分学院就业率</h2>
			<h4>数据截至日期：2015年12月3日</h4>
			<!-- 1212 -->
		</div>

		<div class="centerMiddle makeCenter">
			<ul class="clear">
				<li class="college">学院</li>
				<li class="allNum">总人数</li>
				<li class="upSchool">升学</li>
				<li class="employment">已就业</li>
				<li class="abroad">出国</li>
				<li class="unEmployment">未就业</li>
				<li class="employmentRate clear">
					<div class="clear employmentRateTop">
						<span class="rate">就业率</span>
						<span class="rateDown"></span>
						<span class="rateUp"></span>
					</div>
				</li>
			</ul>
		</div>

		<div class="centerBottom makeCenter">
			<!-- <ul class="listInformation clear dan">
				<li class="college"></li>
				<li class="allNum"></li>
				<li class="upSchool"></li>
				<li class="employment"></li>
				<li class="abroad"></li>
				<li class="unEmployment"></li>
				<li class="employmentRate clear">
					<div class="rateWhite" title="点击查看该学院具体就业情况">
						<div class="rateBlue" style="width:100px;"></div>
						<span class="rateFont">0%</span>
					</div>
				</li>
			</ul> -->
		</div>
		<div class="loading show">
			<img src="image/loading.gif" class="loadingImg" />
		</div>
	</div>


	<!--尾部开始-->
	<div class="foot">
		<img src="image/foot.jpg">
	</div>
	<!--尾部结束-->

	<script src="js/histcollege.js"></script>
	<script src="js/function.js"></script>
</body>
</html>