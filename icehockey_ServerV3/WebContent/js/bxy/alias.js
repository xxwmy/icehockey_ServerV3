/**
 * Created by Administrator on 2017/7/4.
 */
$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});

	// 点击'完成'按钮
	$(".submitBtn").click(function() {

		var touxiang = $("#touxiang").val();
		var name = $("#name").val();
		if (touxiang == "") {
			alert("请选择您的头像");
			return false;
		}
		if (name == "") {
			alert("请输入您的昵称!");
			return false;
		}
		// 请求后台服务
		var data = {
			touxiang : touxiang,
			name : name
			};
		alert(JSON.stringify(data));
		$.post(ALIASURL,data,function(result) {
			alert(typeof result + " ,返回的内容为  "+ result);
			if (result != null) {
				var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			}}, "json");
		});
});