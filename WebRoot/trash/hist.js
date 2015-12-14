window.onload = function() {
	var sortType="down";
	$.ajax({
		type:"POST",
		url:"/CUMTJOB/histCollegeServlet.do",
		data:"sort="+sortType,
		error:function(){
			alert("数据载入失败");
		},
		success:function(data){
			
			var json = new Function("return" + data)();
			var oCenterBottom = getByClass(document,'div','centerBottom')[0];
			addEmployInformation(oCenterBottom,json);
		}
	});
}

//添加就业信息的函数，一行信息为一个ul
function addEmployInformation(obj,json) {
	var string = '';

	for(var i=0;i<json.length;i++) {
		string += '<ul class="listInformation clear"><li class="college">'+json[i].college+'</li><li class="allNum">'+json[i].allNum+'</li><li class="upSchool">'+json[i].upSchool+'</li><li class="employment">'+json[i].employment+'</li><li class="abroad">'+json[i].abroad+'</li><li class="unEmployment">'+json[i].unEmployment+'</li><li class="employmentRate clear"><div class="rateWhite"><div class="rateBlue" style="width:'+2.4*parseFloat(json[i].rateFont)+'px;"></div><span class="rateFont">'+json[i].rateFont+'</span></div></li></ul>';
	}

	obj.innerHTML = string;

	//获取每一行信息的学院
	var aListInformation = getByClass(obj,'li','college');
	//添加点击事件
	collegeClick(aListInformation);
}

//点击学院对应的函数
function collegeClick(aCollege) {
	for(var i=0;i<aCollege.length;i++) {
		aCollege[i].index = i;//索引
		aCollege[i].onclick = function(){
			var arrClassName = this.className.split(' ');
			var _index = arrIndexOf(arrClassName,'collegeActive');
			if(_index == -1) {//之前没点过，显示二级菜单
				addClass(this,'collegeActive');//给点击后的学院添加一个类名
				//console.log(this.innerHTML);//给后端的数据
				var college_name=this.innerHTML;
				
				var json2='';
				$.ajax({
					async: false,
					type:"POST",
					url:"/CUMTJOB/histMajorServlet.do",
					data:"college="+college_name,
					error:function(){
						alert("数据载入失败");
					},
					success:function(data){
						
						json2 = new Function("return" + data)();
						
					}
				});
				
				var string = '<span class="triangle"></span>';//存放innerHTML的字符串
				this.oSecondLevel = document.createElement('div');
				this.oSecondLevel.className = 'secondLevel';
				for( var i=0;i<json2.length;i++ ) {
					string += '<ul class="listInformation clear"><li class="college">'+json2[i].college+'</li><li class="allNum">'+json2[i].allNum+'</li><li class="upSchool">'+json2[i].upSchool+'</li><li class="employment">'+json2[i].employment+'</li><li class="abroad">'+json2[i].abroad+'</li><li class="unEmployment">'+json2[i].unEmployment+'</li><li class="employmentRate clear"><div class="rateWhite"><div class="rateBlue" style="width:'+2.4*parseFloat(json2[i].rateFont)+'px;"></div><span class="rateFont">'+json2[i].rateFont+'</span></div></li></ul>';
				}
				this.oSecondLevel.innerHTML = string;
				if(this.index+1 >= aCollege.length){
					this.parentNode.parentNode.appendChild(this.oSecondLevel);
				}else{
					this.parentNode.parentNode.insertBefore(this.oSecondLevel,aCollege[this.index+1].parentNode);
				}
			} else {//之前点过，删除二级菜单
				this.parentNode.parentNode.removeChild(this.oSecondLevel);
				removeClass(this,'collegeActive');
			}
		}
	}
}