var comm = {
	getUrlParameter : function(name){
		 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     	
     	
     	/*这个正则是寻找&+url参数名字=值+&
&可以不存在。*/
     	if(r!=null)return  unescape(r[2]); return null;
     	var r = window.location.search.substr(1).match(reg);
     	
     	/*这里是开始匹配，找到了返回对应url值，没找到返回null。*/
	}
}
/*这个方法是获得页面url的某个url参数的方法*/