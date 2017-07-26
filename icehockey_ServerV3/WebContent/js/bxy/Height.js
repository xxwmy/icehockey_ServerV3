$(function(){
	$('body').css({
		'min-height':$(window).height()
	});
	$('.next').click(function(){  // ---> 注意function为小写
		var height = $("#points").val();//得到height的值
		//submit('height');  ---> 这样写 是将'height'字符串传入到 submit中
		submit(height);
		//alert(JSON.stringify(data));  ---> data 不存在 会报错
		alert(height);
	});
	
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
	function submit(height) {
		var data = {
			height  : height,
			userid : urlUserId
		};
		alert(JSON.stringify(data));	
		
		// 请求后台保存数据
		$.getJSON(MANHEIGHTURL, data, function(result) {
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
				if (jsonReturn.result == "0") {
					window.location.href = "?userid="+jsonReturn.userid;
				}
		},"json");
	}
});








//$(function(){
//	$('body').css({
//		'min-height':$(window).height()
//	});
//	
//	//点击‘提交’
//	$(".submitBtn").click(function(){
//		var height = $("#points").val();
//		
//		// 请求后台服务
//		var data = {
//			height  : height 
//			};
//		alert(JSON.stringify(data));	
//		
//		$.post("MANHEIGHTURL",data,function(result) {
//			alert(typeof result + " ,返回的内容为  "+ result);
//		}, "json");
//		//不需要写跳转代码，此页面中有上一步下一步按钮执行跳转。只需要提交数据
//	});
//})
