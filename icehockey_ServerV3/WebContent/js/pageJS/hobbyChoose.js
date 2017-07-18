$(function(){ 
 
	$('body').css({'min-height':$(window).height()})
	//玩冰点击事件
	$("#playice").click(function(){
		submit('ICE');
		//window.location.href = "hobbySelectIce.html?hobbyType=ICE";
	});
	
	//玩雪点击事件
	$("#playsnow").click(function(){
		submit('SNOW');
		//window.location.href = "hobbySelectSnow.html?hobbyType=SNOW";
	});
	
	//玩冰又玩雪点击事件
	$("#playboth").click(function(){
		submit('ICESNOW');
	//window.location.href = "hobbySelectIce.html?hobbyType=ICE&All=true";
	});
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}

	//请求后台服务
	function submit(play) {
		var ICEURL="http://127.0.0.1:8080/icehockey_ServerV3/jsp/hobbyChoose.jsp"
		var data = {
			play:play,
			add:window.location.search,
			userid:GetQueryString('userid')
		};
		alert(JSON.stringify(data));
		//window.location.href = "hobbySelectIce.html?hobbyType="+play;
		
		//TODO 请求后台保存数据
		$.getJSON(ICEURL,data,function(result){
			//TODO 处理后台返回的结果
			var jsonReturn = JSON.parse(result);
			if(jsonReturn.result=="0"){
				if(play!="SNOW"){
					//window.location.href = "hobbySelectIce.html?hobbyType="+play;
					self.location="hobbySelectIce.html?hobbyType="+play;
				}else {
					window.location.href = "hobbySelectSnow.html?hobbyType="+play;
				}
				//window.open
			}else if(jsonReturn.result=="-1"){
				window.location.href = "./page/hobbyChoose.html";
			}
		});
	}
	
	/*function submit(play) {
	var url = '../jsp/hobbyChoose.jsp';
	var data = {
		play : play,// 第一个是传入的属性名，第二个是前端获取的值
	};

	$.post(url, data, function(result) {

		// alert(result);
		alert(typeof result + " ,返回的内容为  " + result);
		// alert(result.username+" , "+result.password);
		// var jsonReturn = this.result;
		// var jsonReturn = eval("("+result+")");
		// var jsonReturn = $.parseJSON(result);
		if (result != null) {
			var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
			// alert(typeof jsonReturn + " 转换后内容 " + jsonReturn);
			// 解析JSON对象
			// alert(jsonReturn.userName + " , " + jsonReturn.password);
			// session
		} else {
			alert("手机号码为：的用户不存在");
		}

	}, "json");
}*/
});
