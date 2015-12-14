window.onload = function() {
	var oLoading = getByClass(document, 'div', 'loading')[0];
	//=============================================================
	var sortType = "no";
	var json = '';
	$.ajax({
		async: false,
		type: "POST",
		url: "/CUMTJOB/histCollegeServlet.do",
		data: "sort=" + sortType,
		error: function() {
			alert("数据载入失败");
		},
		success: function(data) {
			json = new Function("return" + data)();
			console.log(oLoading)
			addClass(oLoading, 'hidden');
			removeClass(oLoading, 'show');
		}
	});
	//================================================================

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
function addEmployInformation(obj, json) {
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
	//添加点击事件
	collegeClick(aListInformation);
	rateWhiteClick(aRateWhite);
}

//点击学院对应的函数
function collegeClick(aCollege) {
	for (var i = 0; i < aCollege.length; i++) {
		aCollege[i].index = i; //索引
		aCollege[i].onclick = function() {
			var arrClassName = this.className.split(' ');
			var _index = arrIndexOf(arrClassName, 'collegeActive');
			if (_index == -1) { //之前没点过，显示二级菜单
				addClass(this, 'collegeActive'); //给点击后的学院添加一个类名
				//==============================================================================
				//console.log(this.innerHTML);//给后端的数据
				var college_name = this.innerHTML;
				var json2 = '';
				$.ajax({
					async: false,
					type: "POST",
					url: "/CUMTJOB/histMajorServlet.do",
					data: "college=" + college_name,
					error: function() {
						alert("数据载入失败");
					},
					success: function(data) {

						json2 = new Function("return" + data)();

					}
				});
				//=============================================================================
				var string = '<span class="triangle"></span>'; //存放innerHTML的字符串
				this.oSecondLevel = document.createElement('div');
				this.oSecondLevel.className = 'secondLevel';
				for (var i = 0; i < json2.length; i++) {
					if (json2[i].college.length < 12) {
						string += '<ul class="listInformation clear"><li class="college">' + json2[i].college + '</li><li class="allNum">' + json2[i].allNum + '</li><li class="upSchool">' + json2[i].upSchool + '</li><li class="employment">' + json2[i].employment + '</li><li class="abroad">' + json2[i].abroad + '</li><li class="unEmployment">' + json2[i].unEmployment + '</li><li class="employmentRate clear"><div class="rateWhite"><div class="rateBlue" style="width:' + 2.4 * parseFloat(json2[i].rateFont) + 'px;"></div><span class="rateFont">' + json2[i].rateFont + '</span></div></li></ul>';
					} else {
						string += '<ul class="listInformation clear"><li class="college" style="font-size:14px;">' + json2[i].college + '</li><li class="allNum">' + json2[i].allNum + '</li><li class="upSchool">' + json2[i].upSchool + '</li><li class="employment">' + json2[i].employment + '</li><li class="abroad">' + json2[i].abroad + '</li><li class="unEmployment">' + json2[i].unEmployment + '</li><li class="employmentRate clear"><div class="rateWhite"><div class="rateBlue" style="width:' + 2.4 * parseFloat(json2[i].rateFont) + 'px;"></div><span class="rateFont">' + json2[i].rateFont + '</span></div></li></ul>';
					}
				}
				this.oSecondLevel.innerHTML = string;
				if (this.index + 1 >= aCollege.length) {
					this.parentNode.parentNode.appendChild(this.oSecondLevel);
				} else {
					this.parentNode.parentNode.insertBefore(this.oSecondLevel, aCollege[this.index + 1].parentNode);
				}
			} else { //之前点过，删除二级菜单
				this.parentNode.parentNode.removeChild(this.oSecondLevel);
				removeClass(this, 'collegeActive');
			}
		}
	}
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

//		addClass(oLoading, 'show');
//		removeClass(oLoading, 'hidden');
//		var json = '';
//		$.ajax({
//			async: false,
//			type: "POST",
//			url: "/CUMTJOB/histCollegeServlet.do",
//			data: "sort=" + sortType,
//			error: function() {
//				alert("数据载入失败");
//			},
//			success: function(data) {
//
//				json = new Function("return" + data)();
//				addClass(oLoading, 'hidden');
//				removeClass(oLoading, 'show');
//
//			}
//		});
		if(sortType == 'down'){
			_json = sort(_json);			
		}else{
			_json = sort2(_json);
		}
		//===============以上用ajax传送并接受数据,接收到的数据保存到变量json里============//
		addEmployInformation(oCenterBottom, _json);
	}
}

//点击进度条跳转功能实现的函数
function rateWhiteClick(aRateWhite) {
	for (var i = 0; i < aRateWhite.length; i++) {
		aRateWhite[i].onclick = function() {
			//=========以下数据用ajax传给后端，然后进行页面跳转==============//
			console.log(this.parentNode.parentNode.children[0].innerHTML);

			var college_name = this.parentNode.parentNode.children[0].innerHTML;
			$.ajax({
				async: false,
				type: "POST",
				url: "/CUMTJOB/gotoCollegeServlet.do",
				data: "college_name=" + college_name,
				error: function() {
					alert("跳转失败");
				},
				success: function(data) {
					window.location.href = "majoremploy.jsp?college=" + data;
				}
			});

			//=========以上数据用ajax传给后端，然后进行页面跳转==============//
		}
	}
}