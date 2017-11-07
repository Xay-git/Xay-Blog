/*

@Name：不落阁整站模板源码 
@Author：Absolutely 
@Site：http://www.lyblogs.cn

*/

layui.use(['element', 'jquery', 'form', 'layedit',], function () {
    var element = layui.element();
    var form = layui.form();
    var $ = layui.jquery;
    var layedit = layui.layedit;
 
    var user = $('#user').val();
    
    
   

    //评论和留言的编辑器
    var editIndex = layedit.build('remarkEditor', {
        height: 150,
        tool: ['face', '|', 'left', 'center', 'right', '|', 'link'],
    });
    //评论和留言的编辑器的验证
    layui.form().verify({
        content: function (value) {
            value = $.trim(layedit.getText(editIndex));
            if (value == "") return "自少得有一个字吧";
            layedit.sync(editIndex);
        }
    });

//    //Hash地址的定位
//    var layid = location.hash.replace(/^#tabIndex=/, '');
//    if (layid == "") {
//        element.tabChange('tabAbout', 1);
//    }
//    element.tabChange('tabAbout', layid);
//
//    element.on('tab(tabAbout)', function (elem) {
//        location.hash = 'tabIndex=' + $(this).attr('lay-id');
//    });

    //监听留言提交
    form.on('submit(formLeaveMessage)', function (data) {
     
        //模拟留言提交
        if(user=='null'){
        	layer.msg('请登陆后重试');
        }else{
        	   var index = layer.load(1);
        	   setTimeout(function () {
              	 $.post('../about/add',data.field,function(res){
                  	 layer.close(index);
                  	 var time = getDateDiff(getDateTimeStamp(res.time))
                  	 var html = '<li id='+res.id+'><div class="comment-parent"><img src="../upload/u=2869996995,1435385406&fm=27&gp=03.jpg"alt="模拟留言"/><div class="info"><span class="username">'+res.userName+'</span></div><div class="content">' + res.content + '</div><p class="info info-footer"><span class="time">'+time+'</span><a class="btn-reply"href="javascript:;" onclick="btnReplyClick(this)">回复</a>   <a style="color:pink;"  href="javascript:;" onclick="remove('+res.id+')">删除</a></p></div><!--回复表单默认隐藏--><div class="replycontainer layui-hide"><form class="layui-form"action=""><input type="hidden" class="m_time1" name="m1.m_time"><input type="hidden"  value="'+res.id+'" name="m1.m_pid"><div class="layui-form-item"><textarea name="m1.m_content"lay-verify="m1.m_content"placeholder="请输入回复内容"class="layui-textarea"style="min-height:80px;"></textarea></div><div class="layui-form-item"><button class="layui-btn layui-btn-mini"lay-submit="formReply"lay-filter="formReply">提交</button></div></form></div></li>';
                       $('.blog-comment').append(html);
                       $('#remarkEditor').val('');
                       editIndex = layui.layedit.build('remarkEditor', {
                         height: 150,
                         tool: ['face', '|', 'left', 'center', 'right', '|', 'link'],
                         });
                       layer.msg("留言成功", { icon: 1 });
              	  
                  })
              }, 100);
        }
        
       
        return false;
    });

    //监听留言回复提交
    form.on('submit(formReply)', function (data) {
        var index = layer.load(1);
        //模拟留言回复
        setTimeout(function () {
       	 $.post('../about/add1',data.field,function(res){
            layer.close(index);
            var time = getDateDiff(getDateTimeStamp(res.time))
            var html = '<div class="comment-child"><img src="../upload/u=2869996995,1435385406&fm=27&gp=03.jpg"alt="Absolutely"/><div class="info"><span class="username">'+res.userName+'</span><span>' + res.content + '</span></div><p class="info"><span class="time">'+time+'</span></p></div>';
            $(data.form).find('textarea').val('');
            $(data.form).parent('.replycontainer').after(html).siblings('.comment-parent').children('p').children('a').click();
            layer.msg("回复成功", { icon: 1 });
            
        })
        }, 500);
        return false;
    });
});
function btnReplyClick(elem) {
    var $ = layui.jquery;
    $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
    if ($(elem).text() == '回复') {
        $(elem).text('收起')
    } else {
        $(elem).text('回复')
    }
}
systemTime();

function systemTime() {
    //获取系统时间。
    var dateTime = new Date();
    var year = dateTime.getFullYear();
    var month = dateTime.getMonth() + 1;
    var day = dateTime.getDate();
    var hh = dateTime.getHours();
    var mm = dateTime.getMinutes();
    var ss = dateTime.getSeconds();

    //分秒时间是一位数字，在数字前补0。
    mm = extra(mm);
    ss = extra(ss);

    //将时间显示到ID为time的位置，时间格式形如：19:18:02
    document.getElementById("itime").innerHTML = year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
    $('#m_time').val(year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss);
    $('.m_time1').val(year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss);
    //每隔1000ms执行方法systemTime()。
    setTimeout("systemTime()", 1000);
    
}

//补位函数。
function extra(x) {
    //如果传入数字小于10，数字前补一位0。
    if (x < 10) {
        return "0" + x;
    }
    else {
        return x;
    }
}

function remove(id){
	var url="../about/delete/"+id;
	var div = $('#'+id+'');

	
	layer.confirm('确定删除么？', {
		  btn: ['是的','点错了'] //按钮
		}, function(){
			 $.ajax({
			        type : 'get',
			        url :url,
			        success : function (res){
			           if(res.msg=='1'){
			        	   layer.msg('删除成功', {icon: 1});
			        	   div.remove()	        	   
			           }else{
			        	  layer.msg('删除失败', {icon: 3});
			           }
			        }   
			    	});
		}, function(){
	
		});
	


}



function getDateDiff(dateTimeStamp){ 
var minute = 1000 * 60; 
var hour = minute * 60; 
var day = hour * 24; 
var halfamonth = day * 15; 
var month = day * 30; 
var now = new Date().getTime(); 
var diffValue = now - dateTimeStamp; 
if(diffValue < 0){ 
 //若日期不符则弹出窗口告之 
 //alert("结束日期不能小于开始日期！"); 
 } 
var monthC =diffValue/month; 
var weekC =diffValue/(7*day); 
var dayC =diffValue/day; 
var hourC =diffValue/hour; 
var minC =diffValue/minute; 
if(monthC>=1){ 
 result="发表于" + parseInt(monthC) + "个月前"; 
 } 
 else if(weekC>=1){ 
 result="发表于"  + parseInt(weekC) + "周前"; 
 } 
 else if(dayC>=1){ 
 result="发表于" + parseInt(dayC) +"天前"; 
 } 
 else if(hourC>=1){ 
 result="发表于" + parseInt(hourC) +"个小时前"; 
 } 
 else if(minC>=1){ 
 result="发表于" + parseInt(minC) +"分钟前"; 
 }else 
 result="发表于刚刚"; 
return result; 
} 

function getDateTimeStamp(dateStr){
	var arr = dateStr.split(/[- :]/);
	    return new Date(arr[0], arr[1]-1, arr[2], arr[3], arr[4], arr[5]);
	}


$(document).ready(function(){
	var url = "../about/view"
		
	
	$.ajax({
        type : 'post',
        url :url,
        success : function (res){
        	
        	$.each(res, function(index, item){
        		var blogli = $('#'+item.m_pid+'');
        		var time = getDateDiff(getDateTimeStamp(item.m_time));
        		var html = '<div class="comment-child"><img src="../upload/u=2869996995,1435385406&amp;fm=27&amp;gp=03.jpg" alt="Absolutely"><div class="info"><span class="username">'+item.m_userName+'</span><div>'+item.m_content+'</div></div><p class="info"><span class="time">'+time+'</span></p></div>';
        		blogli.append(html);

        	
        		   });
        }   
    	});


	 $(".time").each(function(){
		    var times = $(this).text();
		    $(this).text((getDateDiff(getDateTimeStamp(times))));
		  });



   
})