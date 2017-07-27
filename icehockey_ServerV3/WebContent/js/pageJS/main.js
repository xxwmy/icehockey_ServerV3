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
	window.location.href="../views/main.html";
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
	window.location.href="../views/imformation/mycommunity.html"
}
/*消息点击效果*/
function infoClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给消息界面设置活动*/
	$(".div_info").addClass("active");
		window.location.href="../views/imformation/oscenter.html"

	
}
/*我的点击效果*/
function mineClick(){
	/*清除当前界面的active*/
	$(".main_top_pages>div").removeClass("active");
	/*给我的界面设置活动*/
	$(".div_mine").addClass("active");
	window.location.href="../views/imformation.html";
	var urlUserId=comm.getUrlParameter("userid");//解析url中的参数获取userid的值
	var dataurl="";
	var data={
		userid:urlUserId,
		
	}
	$.post(dataurl,data,function(reasult){
		var jsonReturn = JSON.parse(result);//处理后台返回的结果
		if(jsonReturn.result="0"){
			if(jsonReturn.roleName=="教练员")//判断角色类别跳转相应页面教练员的跳转
			window.location.href="../views/imformation/coachinfo.html"+"&userid=" + jsonReturn.userid;
			if(jsonReturn.roleName=="守门员"){//守门员的跳转
			window.location.href="../views/imformation.html"+"&userid=" + jsonReturn.userid;
			document.getElementById("userName").innerHTML=jsonReturn.userName;
    		document.getElementById("userbody").innerHTML=jsonReturn.height+"/"+jsonReturn.weight;
   	 		document.getElementById("usercountry").innerHTML=jsonReturn.country;
			}
			if(jsonReturn.roleName=="球员")//球员的跳转
			window.location.href="../views/imformation/qiuyuan.html"+"&userid=" + jsonReturn.userid;
			if(jsonReturn.roleName="");//其他成员
			
			
		}
		else if(jsonReturn=="-1"){//未接收到返回数据的处理
			
		}
	},"json");

}