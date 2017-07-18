$(function() {

	var hobbyType = comm.getUrlParameter("play");
	var sportEvent = null;
	var chooseAll = comm.getUrlParameter("All");// ?????null
	$("#bingqiu").click(function() {
		// 每个按钮执行的操作
		sportEvent = "BQ";// 冰球
		submit(sportEvent);
	});

	$("#huayang").click(function() {
		sportEvent = "HY";// 花样
		submit(sportEvent);
	});

	$("#suhua").click(function() {
		sportEvent = "SH";// 速滑
		submit(sportEvent);
	});

	$("#binghu").click(function() {
		sportEvent = "BH";// 冰壶
		submit(sportEvent);
	});

	// 此函数是为了获取url上携带的参数
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}

	// 提交用户选择的信息
	function submit(sportEvent) {
		var r = confirm("确认要提交吗？");
		if (r == true) {
			var data = {
				play : hobbyType,
				ice_play : sportEvent,
				userid : GetQueryString('userid')
			};

			// alert(JSON.stringify(data));
			// alert(hobbyType);
			// alert(chooseAll);
			// if(chooseAll){
			// window.location.href = "hobbySelectSnow.html?hobbyType=SNOW";
			// }else{
			// alert("提交成功");
			// }

			// 请求后台保存数据
			// alert(ICEURL);
			$.getJSON(ICEURL, data, function(result) {
				// TODO 处理后台返回的结果
				var jsonReturn = JSON.parse(result);
				if (jsonReturn.result == "0") {
					// 提交成功之后进行的操作
					alert(comm.getUrlParameter("ALL"));
					// if(comm.getUrlParameter("ALL")=='true'){
					// window.location.href =
					// "hobbySelectSnow.html?hobbyType=SNOW";
					// }else{
					// window.location.href = "../roleChoose/role.html";
					// }
					alert(jsonReturn.userid);
					if(hobbyType=="ICESNOW"){
						window.location.href = "hobbySelectSnow.html?play="+hobbyType+"&userid="+jsonReturn.userid+"&ice_play="+sportEvent;
					}else{
						window.location.href = "../roleChoose/role.html";
					}

				} else {
					alert("内部处理错误");
				}
			});
		} else {

		}

	}
	;

});