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

window.onload = function() {
    //===================================================//
    //此处为后端返回的用户个人数据
	
	var Request = new Object();
	Request = GetRequest();
	var encodeId=Request["studentId"];
	var id=base64decode(encodeId);
	
	var json='';
	$.ajax({
		async: false,
		type:"POST",
		data:"id="+id,
		url:"/CUMTJOB/stuInfoServlet.do",
		error:function(){
			alert("数据载入失败");
		},
		success:function(data){
			json = new Function("return" + data)();
		}
	});
	
	/*
    var json = [
        {"name":"肖高阳","profession":"计算机科学与技术","telNumber":"15651461019","eMail":"345745764@qq.com","intent":"我是用户填写的就业意向","briefIntroduce":"我是用户的个人简介","personRecommend":"我是用户的个人推荐，此处应为用户上传的个人推荐的文件的下载链接","collegeRecommend":"我是学院推荐的文字","schoolRecommend":"我是学校推荐的文字","userFace":"我是用户头像图片的路径"},
    ];
    */
    //===================================================//

    var oCenter = getByClass(document,'div','center')[0];
    var oCenterLeft = getByClass(oCenter,'div','centerLeft')[0];
    var oCenterRight = getByClass(oCenter,'div','centerRight')[0];
    var oCenterLeftImg = oCenter.getElementsByTagName('img')[0];
    var oBasicMessage = getByClass(oCenterRight,'ul','basicMessage')[0];

    var oIntent = getByClass(oCenterRight,'div','intent')[0];
    var oBriefIntroduce = getByClass(oCenterRight,'div','briefIntroduce')[0];
    var oPersonRecommend = getByClass(oCenterRight,'div','personRecommend')[0];
    var oCollegeRecommend = getByClass(oCenterRight,'div','collegeRecommend')[0];
    var oSchoolRecommend = getByClass(oCenterRight,'div','schoolRecommend')[0];

    //基础信息这一块的数据填充
    var aLi = oBasicMessage.getElementsByTagName('li');
    aLi[0].innerHTML = '姓名：<span>'+ json[0].name +'</span>';
    aLi[1].innerHTML = '专业：<span>'+ json[0].profession +'</span>';
    aLi[2].innerHTML = '学院就业负责人电话：<span>'+json[0].telNumber+'</span>';
    aLi[3].innerHTML = '学院就业负责人邮箱：<span>'+json[0].eMail+'</span>';

    //就业意向数据填充
    var oIntentP = oIntent.getElementsByTagName('p')[0];
    if(json[0].intent == '') json[0].intent = '该用户没有填写';
    oIntentP.innerHTML = json[0].intent;

    //个人简介
    var oBriefIntroduceP = oBriefIntroduce.getElementsByTagName('p')[0];
    if(json[0].briefIntroduce == '') json[0].briefIntroduce = '该用户没有填写';
    oBriefIntroduceP.innerHTML = json[0].briefIntroduce;
    //个人推荐
    var oPersonRecommendP = oPersonRecommend.getElementsByTagName('p')[0];
    if(json[0].personRecommend == '') {
    	oPersonRecommendP.innerHTML = '该用户没有自荐信息' ;
    }else{
    	oPersonRecommendP.innerHTML = '<img src="recommend/'+json[0].personRecommend+'" width="400px" height="300px">' ;
    }
    

    //学院推荐
    var oCollegeRecommendP = oCollegeRecommend.getElementsByTagName('p')[0];
    if(json[0].collegeRecommend == '') json[0].collegeRecommend = '该用户没有填写';
    oCollegeRecommendP.innerHTML = json[0].collegeRecommend;

    //学校推荐
    var oSchoolRecommendP = oSchoolRecommend.getElementsByTagName('p')[0];
    if(json[0].schoolRecommend == '') json[0].schoolRecommend = '该用户没有填写';
    oSchoolRecommendP.innerHTML = json[0].schoolRecommend;

}