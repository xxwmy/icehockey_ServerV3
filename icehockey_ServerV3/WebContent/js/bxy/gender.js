/**
 * 
 */
$(function(){
	$('.man').click(function(){
		var sex=1;
		var url = '../jsp/bxy/gender.jsp';
		var data={
				sex : sex
		};
		$.post(url,data,function(result){
			alter(typeof result+",返回内容是："+result);
			if (result != null) {
				var jsonReturn = JSON.parse(result);// 将JSON字符串转换为对象
				alert(typeof jsonReturn + " 转换后内容  " + jsonReturn);
				// 解析JSON对象
				alert(jsonReturn.userName + " , " + jsonReturn.password);
			}
		},"json");
	});
});