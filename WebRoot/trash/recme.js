window.onload = function(){

	var page="1";
	var json='';
	$.ajax({
		async: false,
		type:"POST",
		data:"page="+page,
		url:"/CUMTJOB/recomMeServlet.do",
		error:function(){
			alert("数据载入失败");
		},
		success:function(data){
			json = new Function("return" + data)();
		}
	});

/*
	var json = [
		{"recommendTime":"2010.12.9","studentId":"08143177","studentName":"肖高阳","profession":"计算机科学与技术","detailed":"此处应该为个人自荐信息的链接"},
		{"recommendTime":"2010.12.10","studentId":"08143178","studentName":"肖高阳2","profession":"网络工程","detailed":"此处应该为个人自荐信息的链接",},
		{"recommendTime":"2010.12.11","studentId":"08143179","studentName":"肖高阳3","profession":"信息安全","detailed":"此处应该为个人自荐信息的链接"},
		{"recommendTime":"2010.12.12","studentId":"08143180","studentName":"肖高阳4","profession":"信息科学与技术","detailed":"此处应该为个人自荐信息的链接"},
		{"recommendTime":"2010.12.13","studentId":"08143181","studentName":"肖高阳5","profession":"计算机科学与技术","detailed":"此处应该为个人自荐信息的链接"},
		{"recommendTime":"2010.12.13","studentId":"08143181","studentName":"肖高阳5","profession":"计算机科学与技术","detailed":"此处应该为个人自荐信息的链接"},
	];
*/
	//推荐时间，学号，姓名，专业，详细信息链接，用户信息链接

	var oTable = getByClass(document,'table','informationTable')[0];
	addEmployInformation(oTable,json);
}

function addEmployInformation(obj,json) {
	var string = '<tr><th>推荐时间</th><th>学号</th><th>姓名</th><th>学科专业</th><th>推荐材料</th></tr>';

	for(var i=0;i<json.length;i++) {
		string += '<tr><td>'+json[i].recommendTime+'</td><td>'+json[i].studentId+'</td><td>'+json[i].studentName+'</td><td>'+json[i].profession+'</td><td><a href="javascript:;">查看</a></td></tr>';
	}

	obj.innerHTML = string;
}