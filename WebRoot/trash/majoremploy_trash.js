window.onload = function(){
	//==============================================
	//此处为后端传过来的学院名称以及专业名称
	
	var college_name="文法学院";
	var jsonCollegeName='';
	$.ajax({
		async: false,
		type:"POST",
		url:"/CUMTJOB/collegeDetailServlet.do",
		data:"college_name="+college_name,
		error:function(){
			alert("数据载入失败");
		},
		success:function(data){
			jsonCollegeName = new Function("return" + data)();
		}
	});
	
	var oCenter = getByClass(document,'div','centers')[0];
	var oCollegeLeft = getByClass(oCenter,'div','collegeLeft')[0];
	var oCollegeRight = getByClass(oCenter,'div','collegeRight')[0];
	var oCenterH2 = oCollegeLeft.getElementsByTagName('h2')[0];
	var oCollegeLeftUl = getByClass(oCollegeLeft,'ul','collegeLeftUl')[0];
	var oCollegeRightUl = getByClass(oCollegeRight,'ul','collegeRightUl')[0];

	addProfession(jsonCollegeName,oCollegeLeftUl);//左侧添加专业名称
	var aLi = oCollegeLeftUl.getElementsByTagName('li');
	var json = getJson(aLi[0].innerHTML,0,jsonCollegeName[0].collegeName);
	addInformation(json,oCollegeRight);

	//为左侧专业名称添加点击事件
	for(var i=0;i<aLi.length;i++) {
		aLi[i].index = i;
		aLi[i].onclick = function(){
			var json = getJson(this.innerHTML,this.index,jsonCollegeName[0].collegeName);
			addInformation(json,oCollegeRight);
		}
	}
}

//获取json的函数
function getJson(college,index,collegeName){
	//=======================================================
	console.log(college,collegeName);//将这两个数据发送给后端(两个参数分别为专业名称，学院名称)
	//172-315行为模拟后端返回的json数据
	
	var json='';
	$.ajax({
		async: false,
		type:"POST",
		url:"/CUMTJOB/majorEmployServlet.do",
		data:{"major":college,"collegename":collegeName},
		error:function(){
			alert("数据载入失败");
		},
		success:function(data){
			json = new Function("return" + data)();
		}
	});
	
	return json;
}

//往右边添加学生就业信息的函数
function addInformation(json,oCollegeRight) {
	var string = '';
	for (var i = 0; i < json.length; i++) {
		string += '<li>' + json[i].studentName + '(' + json[i].employmentStatus + ')</li>';
	}
	oCollegeRight.innerHTML = string;
}

//往左边添加各专业名称的函数
function addProfession(json,ul){
	var arrProName = json[0].profession.split(',');
	var string = '';
	for(var i=0;i<arrProName.length;i++) {
		string += '<li>'+arrProName[i]+'</li>';
	}
	ul.innerHTML = string;
}