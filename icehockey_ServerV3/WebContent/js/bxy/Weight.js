$(function() {
	$('body').css({
		'min-height' : $(window).height()
	});
	$('.next').click(function() { // ---> 注意function为小写
		var weight = $("#points").val();// 得到weight的值
		// submit('weight'); ---> 这样写 是将'weight'字符串传入到 submit中
		submit(weight);
		// alert(JSON.stringify(data)); ---> data 不存在 会报错
		alert(weight);
	});

	var urlUserId = comm.getUrlParameter("userid");// 解析url中的参数获取userid的值
	var urlGender = comm.getUrlParameter("gender");
	function submit(weight) {
		var data = {
			weight : weight,
			userid : urlUserId,
			gender : urlGender
		};
		alert(JSON.stringify(data));

		// 请求后台保存数据
		$.getJSON(MANWEIGHTURL, data, function(result) {
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			if (jsonReturn.result == "0") {
				if (gender == "man") {// 如果选择'man'，跳转man体重面
					window.location.href = "manHeight.html?userid="
							+ jsonReturn.userid;
				} else if (gender == "lady") {// 如果选择‘lady''，跳转lady体重页面
					window.location.href = "ladyHeight.html?userid="
							+ jsonReturn.userid;
				}
			} else if (jsonReturn.result == "-1") {
				alert("当前没有登录用户");
			}
		}, "json");
	}
});
