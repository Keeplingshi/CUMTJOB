<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>个人推荐</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="css/index.css" rel="stylesheet">
<link rel="stylesheet" href="css/recommend.css">
<script type="text/javascript" src="js/jquery-1.7.2.js"> </script> 
</head>
<body>
    <!-- 头部开始 -->
    <div class="head"><img src="image/head.jpg"></div>
    <!-- 头部结束 -->
    <!-- 导航栏开始 -->
    <div class="nav">
        <ul>
            <li>就业进展
                <ul class="list">
                    <li><a href="histCollege.jsp">学院进展</a></li>
                    <li><a href="histMajor.jsp">专业进展</a></li>
                </ul>
            </li>
            <li><a href="recme.jsp">个人自荐</a></li>
            <li><a href="recother.jsp">推荐信息</a></li>
            <li>联系我们
                <ul>
                    <li><a href="link.jsp">就业联系人</a></li>
                    <li><a href="http://jyzd.cumt.edu.cn/">就业指导</a></li>
                </ul>
            </li>
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
            <input type="button" value="上一页" />
            <input type="button" value="下一页" />
        </div>
    </div>

    <!-- 脚部开始 -->
    <div class="foot"><img src="image/foot.jpg"></div>
    <!-- 脚部结束 -->

    <script src="js/function.js"></script>
    <script src="js/recother.js"></script>
</body>
</html>