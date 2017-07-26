
//$(document).ready(function(){
//	  $(".button_Myself").click(function(){
//	    var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
//		var url="../../demo_test.asp";
////		var data={
////		userid : urlUserId,
////		weChatId : weChatId,
////		telephone : telephone,
////		userName : 李雷,
////		sex : sex,
////		birthday : birthday,
////		country : country,
////		city : city,
////		height : height,
////		weight : weight,
////		play : play,
////		ice_play : ice_play,
////		snow_play : snow_play,
////		roleId : roleId,
////		handlingId : handlingId,
////	  };
//	  	$get(url,function(data,status){
//		alert("Data: " + data + "\nStatus: " + status);
//	});
//	});
//	})
//$(document).ready(function(){
//$(".button_Myself").click(function(){
//	var data={
//		userid : "urlUserId",
//		weChatId : "weChatId",
//		telephone : "telephone",
//		userName : "userName",
//		sex : "sex",
//		birthday : "birthday",
//		country : "country",
//		city : "city",
//		height : "height",
//		weight : "weight",
//		play : "play",
//		ice_play : "ice_play",
//		snow_play : "snow_play",
//		roleId : "roleId",
//		handlingId : "handlingId",
//	  };
//  $.post("../demo_test.asp",data,function(data,status){
//  	
////	  document.getElementById("userName").innerHTML=data.userName;
//    alert("数据：" + data + "\n状态：" + status);
//  });
//});
//});
function mainClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给赛程界面设置活动*/
	$(".div_schedule").addClass("active");
	window.location.href="../views/main.html";
}
function mineClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给我的界面设置活动*/
	$(".div_mine").addClass("active");
	
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
	var weChatId=comm.getUrlParameter("wechatid");
	var telephone=comm.getUrlParameter("telephone");
	var userName=comm.getUrlParameter("username");
		var birthday=comm.getUrlParameter("birthday");
	var sex=comm.getUrlParameter("sex");
	var country=comm.getUrlParameter("country");
	var city=comm.getUrlParameter("city");
	var height=comm.getUrlParameter("height");
	var weight=comm.getUrlParameter("weight");
	var play=comm.getUrlParameter("play");
	var ice_play=comm.getUrlParameter("ice_play");
	var snow_play=comm.getUrlParameter("snow_play");
	var roleId=comm.getUrlParameter("roleId");
	var handlingId=comm.getUrlParameter("handlingId");
	var dataurl="";
  	var data={
  	userid : urlUserId,
		weChatId : weChatId,
		telephone : telephone,
		userName : "张杰",
		sex : sex,
		birthday : "123456",
		country : "中国",
		city : "香港",
		height : "175CM",
		weight : "75KG",
		play : play,
		ice_play : ice_play,
		snow_play : snow_play,
		roleId : roleId,
		handlingId : handlingId
  	};
    $.post(dataurl,data,function(data,status){
      alert("数据：" + data + "\n状态：" + status);
    });
    document.getElementById("userName").innerHTML=data.userName;
    document.getElementById("userbody").innerHTML=data.height+"/"+data.weight;
    document.getElementById("usercountry").innerHTML=data.country;

}
$(document).ready(function(){
//$(".div_mine").click(function(){
//	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
//	var weChatId=comm.getUrlParameter("wechatid");
//	var telephone=comm.getUrlParameter("telephone");
//	var userName=comm.getUrlParameter("username");
//		var birthday=comm.getUrlParameter("birthday");
//	var sex=comm.getUrlParameter("sex");
//	var country=comm.getUrlParameter("country");
//	var city=comm.getUrlParameter("city");
//	var height=comm.getUrlParameter("height");
//	var weight=comm.getUrlParameter("weight");
//	var play=comm.getUrlParameter("play");
//	var ice_play=comm.getUrlParameter("ice_play");
//	var snow_play=comm.getUrlParameter("snow_play");
//	var roleId=comm.getUrlParameter("roleId");
//	var handlingId=comm.getUrlParameter("handlingId");
//	
//
//	
//	var dataurl="";
//	var data={
//	userid : urlUserId,
//		weChatId : weChatId,
//		telephone : telephone,
//		userName : "张杰",
//		sex : sex,
//		birthday : "123456",
//		country : "中国",
//		city : "香港",
//		height : "175CM",
//		weight : "75KG",
//		play : play,
//		ice_play : ice_play,
//		snow_play : snow_play,
//		roleId : roleId,
//		handlingId : handlingId
//	};
//  $.post(dataurl,data,function(data,status){
//    alert("数据：" + data + "\n状态：" + status);
//  });
//  document.getElementById("userName").innerHTML=data.userName;
//  document.getElementById("userbody").innerHTML=data.height+"/"+data.weight;
//  document.getElementById("usercountry").innerHTML=data.country;
//  
//});
  $(".button_next1").click(function(){
		    window.location.href="../views/essentiainfo.html";});
});
$(document).ready(function(){
  

	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
	var weChatId=comm.getUrlParameter("wechatid");
	var telephone=comm.getUrlParameter("telephone");
	var userName=comm.getUrlParameter("username");
		var birthday=comm.getUrlParameter("birthday");
	var sex=comm.getUrlParameter("sex");
	var country=comm.getUrlParameter("country");
	var city=comm.getUrlParameter("city");
	var height=comm.getUrlParameter("height");
	var weight=comm.getUrlParameter("weight");
	var play=comm.getUrlParameter("play");
	var ice_play=comm.getUrlParameter("ice_play");
	var snow_play=comm.getUrlParameter("snow_play");
	var roleId=comm.getUrlParameter("roleId");
	var handlingId=comm.getUrlParameter("handlingId");
	var dataurl="";
  	var data={
  	userid : urlUserId,
		weChatId : weChatId,
		telephone : telephone,
		userName : "张杰",
		sex : sex,
		birthday : "123456",
		country : "中国",
		city : "香港",
		height : "175CM",
		weight : "75KG",
		play : play,
		ice_play : ice_play,
		snow_play : snow_play,
		roleId : roleId,
		handlingId : handlingId
  	};
    $.post(dataurl,data,function(data,status){
      alert("数据：" + data + "\n状态：" + status);
    });
    document.getElementById("userName1").innerHTML="姓名："+data.userName;
    document.getElementById("userbody1").innerHTML="身高体重："+data.height+"/"+data.weight;
    
        document.getElementById("usersex1").innerHTML="性别："+data.sex;
            document.getElementById("birthday1").innerHTML="出生年月："+data.birthday;
                document.getElementById("usercountry1").innerHTML="国家："+data.country;
                    document.getElementById("usercity1").innerHTML="籍贯："+data.city;
                        document.getElementById("userplay1").innerHTML="paly:"+data.play;
                            document.getElementById("userice_play1").innerHTML="ice_play:"+data.ice_play;
                                document.getElementById("usersnow_play1").innerHTML="snow:"+data.snow_play;
                                    document.getElementById("userroleId1").innerHTML="roleId:"+data.roleId;
                                        document.getElementById("userhandlingId1").innerHTML="handlingId:"+data.handlingId;








 });
