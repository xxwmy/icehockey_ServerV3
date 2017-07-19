$(function(){
	
	//玩冰点击事件
	$("#playice").click(function(){
		submit('ICE');
		window.location.href = "hobbySelectIce.html?hobbyType=ICE";
	});
	
	//玩雪点击事件
	$("#playsnow").click(function(){
		submit('SNOW');
		window.location.href = "hobbySelectSnow.html?hobbyType=SNOW";
	});
	
	//玩冰又玩雪点击事件
	$("#playboth").click(function(){
		//submit('ICESNOW');
	window.location.href = "hobbySelectIce.html?hobbyType=ICE&All=true";
	});
	
	//请求后台服务
	function submit(play) {
		var data = {
			play:play
		};
        return;
		alert(JSON.stringify(data));
		
		//TODO 请求后台保存数据
		$.getJSON(ICEURL,data,function(result){
			//TODO 处理后台返回的结果
			if(result.result!==null){
				//提交成功之后进行的操作
				window.location.href = "hobbySelectIce.html?hobbyType="+play;
			}
		});
	}
});
