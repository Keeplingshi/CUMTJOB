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
	var page = 0;
	var json = getJson('down');

	//往表格里添加数据
	var oTable = getByClass(document,'table','informationTable')[0];
	addEmployInformation(oTable,json);

	//上下页的点击效果
	var aInput = getByClass(document,'input','pageTurning');
	aInput[0].onclick = function(){//上一页
		oTable.haveEnd = false;
		if(page>=2){//只有页码大于等于第二页才能翻上一页
			var json = getJson('up');
			addEmployInformation(oTable,json);
		}else{
			alert('已经是第一页了！');
		}
	}
	aInput[1].onclick = function(){//下一页
		if(oTable.haveEnd){
			alert('已经是最后一页了！');
		}else{
			var json = getJson('down');
			addEmployInformation(oTable,json);
		}
	}

	function getJson(way){
		if(way == 'down') page++;
		else page--;
		console.log(page);
		//===================先直接传page过去，获得json===========================//
		//通过if来模拟不同页码不同数据
		
		var Request = new Object();
		Request = GetRequest();
		var college_name= Request["college"];
		var major_name=Request["major"];
		
		var json='';
		$.ajax({
			async: false,
			type:"POST",
			data:{"page":page,"college_name":college_name,"major_name":major_name},
			url:"/CUMTJOB/recommendServlet.do",
			error:function(){
				alert("数据载入失败");
			},
			success:function(data){
				json = new Function("return" + data)();
			}
		});

		//======================================================================//
		return json;
	}
}

function addEmployInformation(obj,json) {
	var string = '<tr><th>推荐时间</th><th>学号</th><th>姓名</th><th>学科专业</th><th>推荐老师</th><th>推荐材料</th></tr>';
	for(var i=0;i<json.length;i++) {//循环20条数据
		string += '<tr><td>'+json[i].recommendTime+'</td><td>'+json[i].studentId+'</td><td>'+json[i].studentName+'</td><td>'+json[i].profession+'</td><td>'+json[i].teacherName+'</td><td><a href="javascript:;">查看</a></td></tr>';
		if(json[i].isEnd == 1) obj.haveEnd = true;
	}

	obj.innerHTML = string;
	var aA = obj.getElementsByTagName('a');
	aAClick(aA);
}

function aAClick(aA){
	for(var i=0;i<aA.length;i++){
		aA[i].onclick = function(){
			//================================================================
			//console.log(this.parentNode.parentNode.children[1].innerHTML);
			var studentId=this.parentNode.parentNode.children[1].innerHTML;
			var encodeId=base64encode(studentId);
			window.location.href = "personalInfo.jsp?studentId=" + encodeId;
			//================================================================
		}
	}
}