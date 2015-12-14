window.onload = function(){
	var page = 0;
	var json = getJson('down');

	//往表格里添加数据
	var oTable = getByClass(document,'table','informationTable')[0];
	addEmployInformation(oTable,json);

	//上下页的点击效果
	var aInput = document.getElementsByTagName('input');
	aInput[0].onclick = function(){//上一页
		if(page>=2){//只有页码大于等于第二页才能翻上一页
			var json = getJson('up');
			addEmployInformation(oTable,json);
		}
	}
	aInput[1].onclick = function(){//下一页
		var json = getJson('down');
		addEmployInformation(oTable,json);
	}

	function getJson(way){
		if(way == 'down') page++;
		else page--;
		console.log(page);
		//===================先直接传page过去，获得json===========================//
		
		var json='';
		$.ajax({
			async: false,
			type:"POST",
			data:"page="+page,
			url:"/CUMTJOB/recOtherServlet.do",
			error:function(){
				alert("数据载入失败");
			},
			success:function(data){
				json = new Function("return" + data)();
			}
		});
		
		//============================================================//
		return json;
	}
}

function addEmployInformation(obj,json) {
	var string = '<tr><th>推荐时间</th><th>学号</th><th>姓名</th><th>学科专业</th><th>推荐老师</th><th>推荐材料</th></tr>';

	for(var i=0;i<20;i++) {//循环20条数据
		string += '<tr><td>'+json[i].recommendTime+'</td><td>'+json[i].studentId+'</td><td>'+json[i].studentName+'</td><td>'+json[i].profession+'</td><td>'+json[i].teacherName+'</td><td><a href="javascript:;">查看</a></td></tr>';
	}

	obj.innerHTML = string;
}