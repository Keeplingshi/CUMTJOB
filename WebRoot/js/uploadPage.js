var isUpload=0;//默认不上传

window.onload = function() {
    //===================================================//
    //此处为后端返回的用户个人数据

	var json = '';
	$.ajax({
		async: false,
		type: "POST",
		url: "/CUMTJOB/updateInfoServlet.do",
		data: "id=" + id,
		error: function() {
			alert("数据载入失败");
		},
		success: function(data) {
			console.log(data);
			json = new Function("return" + data)();
		}
	});
	
/*    var json = [{
        "name": "肖高阳",
        "profession": "计算机科学与技术",
        "telNumber": "15651461019",
        "eMail": "345745764@qq.com",
        "studentId":"08123315",
        "userFace": "我是用户头像图片的路径"
    }, ];*/
    //===================================================//

    var oCenter = getByClass(document, 'div', 'center')[0];
    var oCenterLeft = getByClass(oCenter, 'div', 'centerLeft')[0];
    var oCenterRight = getByClass(oCenter, 'div', 'centerRight')[0];
    var oCenterLeftImg = oCenter.getElementsByTagName('img')[0];
    var oBasicMessage = getByClass(oCenterRight, 'ul', 'basicMessage')[0];

    var oTeacherNameInput = getByClass(oCenter,'input','teacherNameInput')[0];
    var oIntentInput = getByClass(oCenterRight, 'input', 'intentInput')[0];
    var oBriefIntroduceInput = getByClass(oCenterRight, 'textarea', 'briefIntroduceInput')[0];

    //基础信息这一块的数据填充
    var aLi = oBasicMessage.getElementsByTagName('li');
    aLi[0].innerHTML = '姓名：<span>' + json[0].name + '</span>';
    aLi[1].innerHTML = '专业：<span>' + json[0].profession + '</span>';
    aLi[2].innerHTML = '学院就业负责人电话：<span>' + json[0].telNumber + '</span>';
    aLi[3].innerHTML = '学院就业负责人邮箱：<span>' + json[0].eMail + '</span>';
    
    var oBtn = getByClass(document,'input','submitMessage')[0];
    oBtn.onclick = function(){
    	
        //===================================================================================
        //传送给后端的数据
    	//推荐教师，就业意向，个人简介
        console.log(oTeacherNameInput.value,oIntentInput.value,oBriefIntroduceInput.value);
        //===================================================================================
    	var teachername=oTeacherNameInput.value;
    	var intent=oIntentInput.value;
    	var intro= oBriefIntroduceInput.value;
        $.ajax({
    		async: false,
    		type: "POST",
    		url: "/CUMTJOB/updateStuServlet.do",
    		data:{"id":window.id,"teachername":teachername,"intent":intent,"intro":intro},
    		error: function() {
    			alert("数据载入失败");
    		},
    		success: function(data) {
    			//alert(data);
    			window.uploader.upload();
    			if(isUpload==0){
    		    	var encodeId=base64encode(id);
    		    	window.location.href = "personalInfo.jsp?studentId=" + encodeId;
    			}
    		}
    	});
        
    };
}


//图片上传demo
jQuery(function() {
    var $ = jQuery,
        $list = $('#fileList'),
        // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,

        // 缩略图大小
        thumbnailWidth = 100 * ratio,
        thumbnailHeight = 100 * ratio,

        // Web Uploader实例
        uploader;

    // 初始化Web Uploader
    window.uploader = WebUploader.create({
    	//是否自动上传
    	//auto: true,
	    // swf文件路径
	    swf: '/js/Uploader.swf',
	    // 文件接收服务端
	    server: '/CUMTJOB/uploadImageServlet.do',
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#filePicker',
	    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	    resize: false,
	    formData: {     //上传图片时附带的参数
            uid: id
        },
	    // 只允许选择图片文件。
	    accept: {
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    }
    });

    // 当有文件添加进来的时候
    window.uploader.on( 'fileQueued', function( file ) {
    	
    	isUpload=1;
    	
        var $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                    '<img>' +
                    '<div class="info">' + file.name + '</div>' +
                '</div>'
                ),
            $img = $li.find('img');

        $list.append( $li );

        // 创建缩略图
        window.uploader.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, thumbnailWidth, thumbnailHeight );
    });

    // 文件上传过程中创建进度条实时显示。
    window.uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress span');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<p class="progress"><span></span></p>')
                    .appendTo( $li )
                    .find('span');
        }

        $percent.css( 'width', percentage * 100 + '%' );
    });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    window.uploader.on( 'uploadSuccess', function( file ) {

    });

    // 文件上传失败，现实上传出错。
    window.uploader.on( 'uploadError', function( file ) {
        var $li = $( '#'+file.id ),
            $error = $li.find('div.error');

        // 避免重复创建
        if ( !$error.length ) {
            $error = $('<div class="error"></div>').appendTo( $li );
        }

        $error.text('上传失败');
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    window.uploader.on( 'uploadComplete', function( file ) {
    	var encodeId=base64encode(id);
    	window.location.href = "personalInfo.jsp?studentId=" + encodeId;
        $( '#'+file.id ).addClass('upload-state-done');
        $( '#'+file.id ).find('.progress').remove();
    });
});