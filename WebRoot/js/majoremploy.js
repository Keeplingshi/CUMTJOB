function GetRequest() {
  
  var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      }
   }
   return theRequest;
}

window.onload = function(){
	//==============================================
	//此处为后端传过来的学院名称以及专业名称
	//var jsonCollegeName = [
	//	{"collegeName":"计算机科学与技术学院","profession":"信息安全,计算机科学与技术,网络工程,电子信息科学与技术"}
	//];
	//==============================================
	var Request = new Object();
	Request = GetRequest();
	var a= Request["college"];
	
	var college_dm=a;
	var jsonCollegeName='';
	$.ajax({
		async: false,
		type:"POST",
		url:"/CUMTJOB/collegeDetailServlet.do",
		data:"college_name="+college_dm,
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
			//alert(data);
			json = new Function("return" + data)();
		}
	});
	//======================================================
	return json;
}

//往右边添加学生就业信息的函数
function addInformation(json,oCollegeRight) {
	var string = '';
	oCollegeRight.arrStudentId = [];
	for (var i = 0; i < json.length; i++) {
		if(json[i].studentName.length == 2) {
			var arr = json[i].studentName.split('');
			json[i].studentName = arr[0] + '&nbsp;' + arr[1];
			//console.log(json[i].studentName)
		}
		string += '<li><a href="javascript:;">' + json[i].studentName + '(' + json[i].employmentStatus + ')</a></li>';
		oCollegeRight.arrStudentId.push(json[i].studentId);
	}

	oCollegeRight.innerHTML = string;
	
	var aRightLi = oCollegeRight.getElementsByTagName('li');
	rightLiClick(aRightLi,oCollegeRight);
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

//右侧名字li的点击事件
function rightLiClick(aRightLi,oCollegeRight){
	for(var i=0;i<aRightLi.length;i++) {
		aRightLi[i].index = i;
		aRightLi[i].onclick = function(){
			//===========================================================================================
			console.log(oCollegeRight.arrStudentId[this.index]);//将此数据发送给后端，然后跳转到个人信息页面
			
			var studentId=oCollegeRight.arrStudentId[this.index];
			
			var encodeId=base64encode(studentId);
/*			alert(encodeId);
			var decodeId=base64decode(encodeId)
			alert(decodeId);*/
			window.location.href = "personalInfo.jsp?studentId=" + encodeId;
			//===========================================================================================
		}
	}
}