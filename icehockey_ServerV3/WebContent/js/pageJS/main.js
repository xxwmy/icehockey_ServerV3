function loadCarousel(){
	//获得slider插件对象
	var gallery = mui('.mui-slider');
	gallery.slider({
	  interval:5000//自动轮播周期，若为0则不自动播放，默认为0；
	});
}


/* 主页面上方六个功能*/
$(".saishizixun").click(function(){
		window.location.href = "mainUpPage/saishizixun.html";
		
	});
	
$(".jiaobingbibai").click(function(){
		window.location.href = "mainUpPage/jiaobingbibai.html";
	});

$(".hujvzhuangbei").click(function(){
		window.location.href = "mainUpPage/hujvzhuangbei.html";
	});
	
$(".jishutongji").click(function(){
		window.location.href = "mainUpPage/jishutongji.html";
	});

	
$(".jiaoxueziliao").click(function(){
		window.location.href = "mainUpPage/jiaoxueziliao.html";
	});
	
$(".my2016").click(function(){
		window.location.href = "mainUpPage/my2016.html";
	});


//页面中间内容展示页面,待开发
$(".content_out_div>.left_content_div>.content_div").click(function(){
	alert("待开发页面");
	
});
$(".content_out_div>.right_content_div>.content_div").click(function(){
	alert("待开发页面");
	
});




/*主页面点击效果*/
function mainClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给赛程界面设置活动*/
	$(".div_schedule").addClass("active");
}

/*赛程点击效果*/
function saichenClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给赛程界面设置活动*/
	$(".div_game").addClass("active");
}
/*工具箱点击效果*/
function gongjuClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给赛程界面设置活动*/
	$(".div_tool").addClass("active");
}
/*社区点击效果*/
function clubClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给社区界面设置活动*/
	$(".div_club").addClass("active");
}
/*消息点击效果*/
function infoClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给消息界面设置活动*/
	$(".div_info").addClass("active");
}
/*我的点击效果*/
function mineClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给我的界面设置活动*/
	$(".div_mine").addClass("active");
	window.location.href="imformation.html";
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
