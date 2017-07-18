$(function() {

	$('body').css({
		'min-height' : $(window).height()
	});
	// 玩冰点击事件
	$("#playice").click(function() {
		submit('ICE');
		// window.location.href = "hobbySelectIce.html?hobbyType=ICE";
	});

	// 玩雪点击事件
	$("#playsnow").click(function() {
		submit('SNOW');
		// window.location.href = "hobbySelectSnow.html?hobbyType=SNOW";
	});

	// 玩冰又玩雪点击事件
	$("#playboth").click(function() {
		submit('ICESNOW');
		// window.location.href = "hobbySelectIce.html?hobbyType=ICE&All=true";
	});
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}

	// 请求后台服务
	function submit(play) {
		var ICEURL = "http://127.0.0.1:8080/icehockey_ServerV3/jsp/hobbyChoose.jsp";
		var data = {
			play : play,			
			userid : GetQueryString('userid')
		};
		alert(JSON.stringify(data));
		//  请求后台保存数据
		$.getJSON(ICEURL, data, function(result) {
			//  处理后台返回的结果
			var jsonReturn = JSON.parse(result);
			if (jsonReturn.result == "0") {
				if (play == "ICE") {
					window.location.href = "hobbySelectIce.html?play="
							+ play+"&userid="+jsonReturn.userid;
				} else if (play == "SNOW"){
					window.location.href = "hobbySelectSnow.html?play="
							+ play+"&userid="+jsonReturn.userid;
				}else if (play == "ICESNOW"){
					window.location.href = "hobbySelectIce.html?play="
						+ play+"&All=true"+"&userid="+jsonReturn.userid;
			}
				// window.open
			} else if (jsonReturn.result == "-1") {
				window.location.href = "./page/hobbyChoose.html";
			}
		});
	}
});
