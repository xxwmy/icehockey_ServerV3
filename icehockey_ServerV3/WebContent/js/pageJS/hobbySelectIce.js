$(function(){
	
	var hobbyType = comm.getUrlParameter("hobbyType");
	var sportEvent = null;
    var chooseAll=comm.getUrlParameter("All");
	$("#bingqiu").click(function(){
		//每个按钮执行的操作
		sportEvent = "BQ";
		submit(sportEvent)
	});
	
	$("#huayang").click(function(){
		sportEvent = "HY";
		submit(sportEvent)
	});
	
	$("#suhua").click(function(){
		sportEvent = "SH";
		submit(sportEvent)
	});
	
	$("#binghu").click(function(){
		sportEvent = "BH";
		submit(sportEvent)
	});
	
	//提交用户选择的信息
	function submit(sportEvent){
		var r=confirm("确认要提交吗？");
		if (r==true)
		{
			var data = {
				play : hobbyType,
				ice_play : sportEvent
			};

			alert(JSON.stringify(data));
			if(chooseAll){
				window.location.href = "hobbySelectSnow.html?hobbyType=SNOW";
			}else{
				alert("提交成功");
			}

			return;
			//TODO 请求后台保存数据
			$.getJSON(ICEURL,data,function(result){
				//TODO 处理后台返回的结果
				//if(result.result!="0"){
					//提交成功之后进行的操作
					if(comm.getUrlParameter("ALL")==='true'){
						window.location.href = "hobbySelectSnow.html?hobbyType=SNOW";
					}else{
						window.location.href = "../roleChoose/role.html";
					}

				//}
			});
		}
		else
		{

		}


		
	};
	
});