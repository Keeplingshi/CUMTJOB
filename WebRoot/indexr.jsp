<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<link rel="Shortcut Icon" href="image/favicon.ico" />
	<!-- <link href="css/index.css" rel="stylesheet"> -->
	<link href="css/histogram.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.7.2.js"> </script>
	<script src="js/html5shiv.js"></script> 
	<style type="text/css">
#Main,#Main2,#Main3{
	float:left;
	width: 370px;
	height: 300px;
	/* height:266px; */
	border: 1px solid #ccc;
	margin: 0 auto;
	margin-top: 50px;
	margin-bottom:60px;
	margin-left:20px;
	overflow:hidden;
	/*background: rgb(157,157,157);*/
}
#Main{margin-left:20px;}
#mainDiv,#mainDiv1,#mainDiv2 {
	width:100%;
	height:500px;
	margin-top:-120px;
}
/*12.12*/
.navcenter { text-align:center; }
.navcenter h2 { margin:45px auto 0; }
/*12.12*/

</style>
	<title>首页</title>
	<style type="text/css">.ie6fixed3{position:fixed;right:0;bottom:0}
			
* html .ie6fixed3{position:absolute;left:expression(eval(document.documentElement.scrollLeft+document.documentElement.clientWidth-this.offsetWidth)-(parseInt(this.currentStyle.marginLeft,10)||0)-(parseInt(this.currentStyle.marginRight,10)||0));top:expression(eval(document.documentElement.scrollTop+document.documentElement.clientHeight-this.offsetHeight-(parseInt(this.currentStyle.marginTop,10)||0)-(parseInt(this.currentStyle.marginBottom,10)||0)))}</style>
	<!--[if lt IE 9]>
	<script type="text/javascript">
	alert("你正在使用IE8以下低版本的IE浏览器，在本页面的显示效果可能有差异。建议您升级到IE8以上或者使用Firefox/Chrom/Safari/Opera浏览器。若您正在使用360浏览器，请调整到极速模式查看本页。");
	</script>
	<![endif]-->
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
	<div class="navcenter">
		<h2>中国矿业大学2016届毕业生就业情况一览表</h2>
		<div style="width=200px;height=200px">
			<div style="position: absolute; left: -1px; bottom: -1px; z-index: 0; width: 0px; height: 0px; overflow: hidden; visibility: hidden; display: none;" id="BAIDU_DUP_fp_wrapper">
				<iframe style="width: 0px; height: 0px; visibility: hidden; display: none;" src="amchart%E9%A5%BC%E7%8A%B6%E5%9B%BE%E4%BD%BF%E7%94%A8%E8%AF%A6%E8%A7%A3_files/o.htm" id="BAIDU_DUP_fp_iframe"></iframe>
			</div>
	
			<!-- 第一个 -->
			<div id="Main">
			<p style="text-align:center;margin-top:30px;font-family:黑体;">全校就业情况</p>
				<div style="overflow: hidden; text-align: left;" id="mainDiv">
					<div style="overflow: hidden; position: relative; text-align: left; width: 800px; height: 500px;">
						<svg version="1.1" style="position: absolute; width: 800px; height: 500px; left: 0.5px;">
						</svg>
					</div>
				</div>
				<div style="margin:0px auto;margin-top:-188px;height:30px;line-height:30px;font-size:8px;text-align:center;">数据截止日期：2015-12-3</div>
			</div>
	
			<!-- 第二个 -->
			<div id="Main2">
			<p style="text-align:center;margin-top:30px;font-family:黑体;">本科生就业情况</p>
				<div style="overflow: hidden; text-align: left;" id="mainDiv1">
					<div style="overflow: hidden; position: relative; text-align: left; width: 800px; height: 500px;">
						<svg version="1.1" style="position: absolute; width: 800px; height: 500px; left: 0.5px;">
						</svg>
					</div>
				</div>
				<div style="margin:0px auto;margin-top:-188px;height:30px;line-height:30px;font-size:8px;text-align:center;">数据截止日期：2015-12-3</div>
			</div>
	
			<!-- 第三个 -->
			<div id="Main3">
			<p style="text-align:center;margin-top:30px;font-family:黑体;">研究生就业情况</p>
				<div style="overflow: hidden; text-align: left;" id="mainDiv2">
					<div style="overflow: hidden; position: relative; text-align: left; width: 800px; height: 500px;">
						<svg version="1.1" style="position: absolute; width: 800px; height: 500px; left: 0.5px;">
						</svg>
					</div>
				</div>
				<div style="margin:0px auto;margin-top:-188px;height:30px;line-height:30px;font-size:8px;text-align:center;">数据截止日期：2015-12-3</div>
			</div>
		</div>
	</div>
	<!--尾部开始-->
	<div class="foot"><img src="image/foot.jpg"></div>
	<!--尾部结束-->
	
	<div class="floatVideo smallFloatVideo">
        <div class="close hidden" title="缩小">X</div>
        <div class="videoFont smallVideoFont hidden">双击可放大</div>
        <video src="video/jiuye.MP4" loop="loop" autoplay="autoplay" class="video smallVideo"></video>
    </div>

	<script src="js/function.js"></script>
	<script type="text/javascript" src="js/amcharts.js"></script>
	<script type="text/javascript">
window.onload=function(){
	$.ajax({
		type:"POST",
		url:"/CUMTJOB/pieServlet.do",
		data:{},
		error:function(){
			alert("数据载入失败");
		},
		success:function(data){
			
			var obj = new Function("return" + data)();
			var all = JSON.stringify(obj.all);
			MakeChart(all,'mainDiv');
			var undergraduate = JSON.stringify(obj.undergraduate);
			MakeChart(undergraduate,'mainDiv1');
			var postgraduate = JSON.stringify(obj.postgraduate);
			MakeChart(postgraduate,'mainDiv2');
		}
	   });
	
	var wh = {
		width:document.body.clientWidth,
		height:document.body.clientHeight
	};
	 
	
	var oFloatVideo = getByClass(document, 'div', 'floatVideo')[0];
    var oVideo = oFloatVideo.getElementsByTagName('video')[0];
    var oFont = getByClass(document, 'div', 'videoFont')[0];
    var oClose = getByClass(document, 'div', 'close')[0];
    var position = '';
    var onOff = true;

    addEvent(oFloatVideo, 'mouseover', mouseoverVideo);
    addEvent(oFloatVideo, 'mouseout', mouseoutVideo);
    addEvent(oFloatVideo, 'mousedown', dragDown);
    addEvent(oFloatVideo, 'dblclick', function() {
        removeEvent(oFloatVideo, 'mouseover', mouseoverVideo);
        removeEvent(oFloatVideo, 'mouseout', mouseoutVideo);

        removeClass(oFloatVideo, 'smallFloatVideo');
        removeClass(oFont, 'smallVideoFont');
        removeClass(oVideo, 'smallVideo');
        removeClass(oClose, 'hidden');

        addClass(oFloatVideo, 'bigFloatVideo');
        addClass(oFont, 'hidden');
        addClass(oVideo, 'bigVideo');

        oVideo.play();

        position = this.style.cssText;
        this.style.cssText = '';

        removeEvent(oFloatVideo, 'mousedown', dragDown);
    });
    addEvent(oClose, 'click', function() {
        addEvent(oFloatVideo, 'mouseover', mouseoverVideo);
        addEvent(oFloatVideo, 'mouseout', mouseoutVideo);

        addClass(oFloatVideo, 'smallFloatVideo');
        addClass(oFont, 'smallVideoFont');
        addClass(oVideo, 'smallVideo');
        addClass(oClose, 'hidden');

        removeClass(oFloatVideo, 'bigFloatVideo');
        removeClass(oFont, 'hidden');
        removeClass(oVideo, 'bigVideo');

        addEvent(oFloatVideo, 'mousedown', dragDown);

        oFloatVideo.style.cssText = position;
    });
    
    addEvent(oFloatVideo,'click',function(){
    	if(onOff){
    		oVideo.pause();
    	}else{
    		oVideo.play();
    	}
    	onOff = !onOff;
    });

    function mouseoverVideo() {
        removeClass(oFont, 'hidden');
        //oVideo.play();
        
    }

    function mouseoutVideo() {
        addClass(oFont, 'hidden');
        //oVideo.play();
    }

    function dragDown(ev) {
        var ev = ev || window.event;
        disX = ev.clientX - oFloatVideo.offsetLeft;
        disY = ev.clientY - oFloatVideo.offsetTop;
        if (oFloatVideo.setCapture) {
            oFloatVideo.setCapture();
        }
        document.onmousemove = function(ev) {
            var ev = ev || window.event;
            oFloatVideo.style.left = ev.clientX - disX + 'px';
            oFloatVideo.style.top = ev.clientY - disY + 'px';
        };
        document.onmouseup = function() {
            document.onmousemove = null;
            document.onmouseup = null;
            if (oFloatVideo.releaseCapture) {
                oFloatVideo.releaseCapture();
            }
        };
        return false;
    }
}

//根据json数据生成饼状图，并将饼状图显示到div中
function MakeChart(value,id) {
    chartData = eval(value);
	//饼状图
    chart = new AmCharts.AmPieChart();
    chart.dataProvider = chartData;
	//标题数据
    chart.titleField = "name";
	//值数据
    chart.valueField = "value";
	//边框线颜色
    chart.outlineColor = "#fff";
	//边框线的透明度
    chart.outlineAlpha = .8;
	//边框线的狂宽度
    chart.outlineThickness = 1;
    chart.depth3D = 10;
    chart.angle = 30;
    chart.radius = 70;
    chart.labelRadius = 5;
    var colors = [
				"#133A61",	//已就业
				"#FF0000",	//求职中
				"#008000"	//升学
              	
              ];
              chart.colors = colors;
    chart.write(id);
}

</script>

</body>
</html>