/**
 * Created by Administrator on 2017/7/4.
 */
$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});
	// 点击"下一步"按钮
	$(".next").click(function() {
		var time = $(".time").val();
		var touwei = $(".touwei").val();
		var bichang = $(".bichang").val();
		var tuichang = $(".tuichang").val();
		var xiaojiaochang = $(".xiaojiaochang").val();
		var jiaochang= $(".jiaochang").val();
		var jiaoxing= $(".jiaoxing").val();

		if (touwei == "") {
			alert("请输入您的头围!");
			return false;
		}
		if (bichang == "") {
			alert("请输入您的臂长!");
			return false;
		}
		if (tuichang == "") {
			alert("请输入您的腿长!");
			return false;
		}
		if (xiaojiaochang == "") {
			alert("请输入您的小腿长!");
			return false;
		}
		if (jiaochang == "") {
			alert("请输入您的脚长!");
			return false;
		}
		if (jiaoxing == "") {
			alert("请输入您的脚型!");
			return false;
		}
		// 请求后台服务
		var data ={
			time : time,
		 	touwei : touwei,
			bichang : bichang ,
			tuichang : tuichang,
			xiaojiaochang :xiaojiaochang ,
			jiaochang : jiaochang ,
			jiaoxing : jiaoxing
			};
		alert(JSON.stringify(data));
			$.post(  bodyurl ,data,function(result) {
				alert(typeof result + " ,返回的内容为  "+ result);
				if (result != null) {
					var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
				}
			}, "json");
		});
});