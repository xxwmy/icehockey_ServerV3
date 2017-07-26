$(function(){
	$('body').css({
		'min-height':$(window).height()
	});
	$('.next').click(function(){  // ---> 注意function为小写
		var weight = $("#points").val();//得到weight的值
		//submit('weight');  ---> 这样写 是将'weight'字符串传入到 submit中
		submit(weight);
		//alert(JSON.stringify(data));  ---> data 不存在 会报错
		alert(weight);
	});
	
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
	function submit(weight) {
		var data = {
			weight  : weight,
			userid : urlUserId
		};
		alert(JSON.stringify(data));	
		
		// 请求后台保存数据
		$.getJSON(MANWEIGHTURL, data, function(result) {
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
				if (jsonReturn.result == "0") {
					window.location.href = "manHeight.html?userid="+jsonReturn.userid;
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
//		var weight = $("#points").val();
//		
//		// 请求后台服务
//		var data = {
//			weight  : weight 
//			};
//		alert(JSON.stringify(data));	
//		
//		$.post("MANWEIGHTURL",data,function(result) {
//			alert(typeof result + " ,返回的内容为  "+ result);
//		}, "json");
//		//不需要写跳转代码，此页面中有上一步下一步按钮执行跳转。只需要提交数据
//	});
//})
