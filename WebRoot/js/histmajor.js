window.onload = function() {
	var oLoading = getByClass(document, 'div', 'loading')[0];
	//=======================================================
	var sortType = "no";
	var json = '';
	$.ajax({
		async: false,
		type: "POST",
		url: "/CUMTJOB/histMajorServlets.do",
		data: "sort=" + sortType,
		error: function() {
			alert("数据载入失败");
		},
		success: function(data) {
			//console.log(data);
			json = new Function("return" + data)();
			addClass(oLoading, 'hidden');
			removeClass(oLoading, 'show');
		}
	});
	//======================================================

	var oCenterMiddle = getByClass(document, 'div', 'centerMiddle')[0];
	var oCenterBottom = getByClass(document, 'div', 'centerBottom')[0];
	addEmployInformation(oCenterBottom, json);

	//排序处点击功能的实现
	var oRateDown = getByClass(oCenterMiddle, 'span', 'rateDown')[0];
	var oRateUp = getByClass(oCenterMiddle, 'span', 'rateUp')[0];
	rateClick(oCenterBottom, oRateUp,json);
	rateClick(oCenterBottom, oRateDown,json);
}

//添加就业信息的函数，一行信息为一个ul
function addEmployInformation2(obj, json) {
	var string = '';

	for (var i = 0; i < json.length; i++) {
		if (json[i].college.length < 12) {
			string += '<ul class="listInformation clear"><li class="college">' + json[i].college + '</li><li class="allNum">' + json[i].allNum + '</li><li class="upSchool">' + json[i].upSchool + '</li><li class="employment">' + json[i].employment + '</li><li class="abroad">' + json[i].abroad + '</li><li class="unEmployment">' + json[i].unEmployment + '</li><li class="employmentRate clear"><div class="rateWhite" title="点击查看该学院具体就业情况"><div class="rateBlue" style="width:' + 2.4 * parseFloat(json[i].rateFont) + 'px;"></div><span class="rateFont">' + json[i].rateFont + '</span></div></li></ul>';
		} else {
			string += '<ul class="listInformation clear"><li class="college" style="font-size:14px;">' + json[i].college + '</li><li class="allNum">' + json[i].allNum + '</li><li class="upSchool">' + json[i].upSchool + '</li><li class="employment">' + json[i].employment + '</li><li class="abroad">' + json[i].abroad + '</li><li class="unEmployment">' + json[i].unEmployment + '</li><li class="employmentRate clear"><div class="rateWhite" title="点击查看该学院具体就业情况"><div class="rateBlue" style="width:' + 2.4 * parseFloat(json[i].rateFont) + 'px;"></div><span class="rateFont">' + json[i].rateFont + '</span></div></li></ul>';
		}
	}

	obj.innerHTML = string;

	//获取每一行信息的学院
	var aListInformation = getByClass(obj, 'li', 'college');
	var aRateWhite = getByClass(obj, 'div', 'rateWhite');
	//下面这段数据为用json动态写入html里面的基本html结构单元
	console.log('ss')
	rateWhiteClick(aRateWhite);
	rateWhiteClick2(aListInformation);
}

//添加就业信息的函数，一行信息为一个ul
function addEmployInformation(obj,json) {
	var j=0;
	for(var i=0;i<20;i++) {//20个学院
		var string = '';
		var oSecondLevel = document.createElement('div');
		if (i%2 == 0){
			oSecondLevel.className = 'secondLevel color1';
		}else{
			oSecondLevel.className = 'secondLevel color2';
		}
		var b = parseInt(json[j].college_number);
		for (var num=0; num < b; num++) {//学院下对应的专业数目
			if (json[j].college.length < 12) {
				string += '<ul class="listInformation clear"><li class="college">' + json[j].college + '</li><li class="allNum">' + json[j].allNum + '</li><li class="upSchool">' + json[j].upSchool + '</li><li class="employment">' + json[j].employment + '</li><li class="abroad">' + json[j].abroad + '</li><li class="unEmployment">' + json[j].unEmployment + '</li><li class="employmentRate clear"><div class="rateWhite" title="点击查看该学院具体就业情况"><div class="rateBlue" style="width:' + 2.4 * parseFloat(json[j].rateFont) + 'px;"></div><span class="rateFont">' + json[j].rateFont + '</span></div></li></ul>';
			} else {
				string += '<ul class="listInformation clear"><li class="college" style="font-size:14px;">' + json[j].college + '</li><li class="allNum">' + json[j].allNum + '</li><li class="upSchool">' + json[j].upSchool + '</li><li class="employment">' + json[j].employment + '</li><li class="abroad">' + json[j].abroad + '</li><li class="unEmployment">' + json[j].unEmployment + '</li><li class="employmentRate clear"><div class="rateWhite" title="点击查看该学院具体就业情况"><div class="rateBlue" style="width:' + 2.4 * parseFloat(json[j].rateFont) + 'px;"></div><span class="rateFont">' + json[j].rateFont + '</span></div></li></ul>';
			}
			j++;//记录第几次循环
			//if(j== json.length) break;
		}
		oSecondLevel.innerHTML = string;
		obj.appendChild(oSecondLevel);
	}
	
	//获取每一行信息的学院
	var aListInformation = getByClass(obj, 'li', 'college');
	var aRateWhite = getByClass(obj, 'div', 'rateWhite');
	//下面这段数据为用json动态写入html里面的基本html结构单元
	console.log('ss')
	rateWhiteClick(aRateWhite);
	rateWhiteClick2(aListInformation);

}


//点击排序的函数
function rateClick(oCenterBottom, obj,json) {
	var _json = json;
	obj.onclick = function() {
		
		oCenterBottom.innerHTML = '';
		var string = '';
		//===============以下用ajax传送并接受数据,接收到的数据保存到变量json里============//
		//向后端传送数据obj.className,该值为"rateDown"的话代表降序，为"rateUp"的话代表升序
		//模拟传送过来的数据
		var sortType = 'no';
		if (obj.className == 'rateDown') {
			sortType = 'down';
		} else if (obj.className == 'rateUp') {
			sortType = 'up';
		}
//		
//		//addClass(oLoading, 'show');
//		//removeClass(oLoading, 'hidden');
//		var json = '';
//		
//		$.ajax({
//			async: false,
//			type: "POST",
//			url: "/CUMTJOB/histMajorServlets.do",
//			data: "sort=" + sortType,
//			error: function() {
//				alert("数据载入失败");
//			},
//			success: function(data) {
//				//alert(data);
//				json = new Function("return" + data)();
//				//addClass(oLoading, 'hidden');
//				//removeClass(oLoading, 'show');
//			}
//		});
		if(sortType == 'down'){
			_json = sort(_json);			
		}else{
			_json = sort2(_json);
		}
		for(var i=0;i<_json.length;i++){
			console.log(_json[i].rateFont);
		}
		//===============以上用ajax传送并接受数据,接收到的数据保存到变量json里============//
		addEmployInformation2(oCenterBottom, _json);
	}
}

//点击进度条跳转功能实现的函数
function rateWhiteClick(aRateWhite) {
	for (var i = 0; i < aRateWhite.length; i++) {
		aRateWhite[i].onclick = function() {
			//=========以下数据用ajax传给后端，然后进行页面跳转==============//
			console.log(this.parentNode.parentNode.children[0].innerHTML);

			var major_name = this.parentNode.parentNode.children[0].innerHTML;
			$.ajax({
				async: false,
				type: "POST",
				url: "/CUMTJOB/gotoMajorServlet.do",
				data: "major_name=" + major_name,
				error: function() {
					alert("跳转失败");
				},
				success: function(data) {
					//返回专业代码，到majoremploy2.jsp页面
					window.location.href = "majoremploy2.jsp?major=" + data;
				}
			});

			//=========以上数据用ajax传给后端，然后进行页面跳转==============//
		}
	}
}

function rateWhiteClick2(aRateWhite) {
	for (var i = 0; i < aRateWhite.length; i++) {
		aRateWhite[i].onclick = function() {
			//=========以下数据用ajax传给后端，然后进行页面跳转==============//
			console.log(this.innerHTML);

			var major_name = this.innerHTML;
			$.ajax({
				async: false,
				type: "POST",
				url: "/CUMTJOB/gotoMajorServlet.do",
				data: "major_name=" + major_name,
				error: function() {
					alert("跳转失败");
				},
				success: function(data) {
					//返回专业代码，到majoremploy2.jsp页面
					window.location.href = "majoremploy2.jsp?major=" + data;
				}
			});
			//=========以上数据用ajax传给后端，然后进行页面跳转==============//
		}
	}
}