/**
 * Created by Administrator on 2017/7/4.
 */
$(function(){
    $('body').css({'min-height':$(window).height()})
    
    //点击登录
    $(".submitBtn").click(function(){
    	
    	var phoneNumber = $("#phoneNumber").val();
    	var verificationCode = $("#verificationCode").val();
    	if(phoneNumber == ""){
    		alert("请输入手机号码");
    		return false;
    	}
    	
    	if (verificationCode == "") {
    		alert("验证码不能为空!");
    		return false;
    	}
    	
    	//请求后台服务
    	var url ='http://127.0.0.1:8080/icehockey_ServerV3/jsp/login.jsp';
    	var data = {
    		phoneNumber : phoneNumber,
    		verificationCode : verificationCode
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
					alert(typeof jsonReturn + " 转换后内容  " + jsonReturn);
					// 解析JSON对象
					alert(jsonReturn.userName + " , " + jsonReturn.password);
					//session
	                //判断  result 的返回值 ,isFirst 为后台添加的属性,如果是第一次登陆则至hobbyChoose.html
					if(jsonReturn.result=='isFirst'){
						window.location.href = "./page/hobbyChoose.html";
					}else{
						window.location.href = "./main.html";
					}
					
					
				} //else {
				//	alert("手机号码为：" + phoneNumber + "的用户不存在");
				
				//}
		    }, "json");
    	
    })
    
});