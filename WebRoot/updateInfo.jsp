<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<link rel="Shortcut Icon" href="image/favicon.ico" />
	<link href="css/histogram.css" rel="stylesheet">
    <link rel="stylesheet" href="css/uploadPage.css">
    <link rel="stylesheet" type="text/css" href="css/webuploader.css">
    
	<title>个人信息</title>
</head>
<body>
	
	<script>
		var id ="<%=session.getAttribute("id")%>";
		//var id="08123315";
	</script>
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
			<li class="right"><a href="#">修改密码</a></li>
            <li class="right"><a href="#">欢迎您！张三</a></li>
		</ul>
	</div>
    <!--导航栏结束-->
    <!--中间开始-->
    <div class="center clear" id="navmid">
        <div class="centerLeft">
            <img src="image/ac1.jpg" />
        </div>
        <div class="centerRight">
            <ul class="basicMessage">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
            <div class="teacherName">
            	<span>推荐教师：</span><input type="text" class="teacherNameInput" placeholder="如果没有可以不填" />
            </div>
            <div class="intent">
                <h2>就业意向</h2>
                <input type="text" class="intentInput" placeholder="意向，岗位，地点，薪资，30字以内" />
            </div>
            <div class="briefIntroduce">
                <h2>个人简介</h2>
                <textarea class="briefIntroduceInput" placeholder="300字以内"></textarea>
            </div>
            <div class="personRecommend">
                <h2>推荐材料</h2>
                
                
                <div id="uploader" class="wu-example">
                	<div id="fileList" class="uploader-list"></div>
                	<div class="btns">
                		<div id="filePicker">选择图片 </div>
                	</div>
                	<div>图片最大允许上传2M</div>
                </div>
                
            </div>
            <input type="button" value="提交" class="submitMessage" />
        </div>
    <!--中间结束-->
    <!--尾部开始-->
    <div class="foot"><img src="image/foot.jpg"></div>
    <!--尾部结束-->
    <script type="text/javascript" src="js/jquery-1.7.2.js"> </script> 
    <script src="js/function.js"></script>
    <script type="text/javascript" src="js/webuploader.js"></script>
    <script src="js/decode.js"></script>
    <script type="text/javascript" src="js/uploadPage.js"></script>
    
</body>
</html>