<%@page import="com.icehockey.entity.User"%>
<%@page import="com.icehockey.service.UserService"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="com.icehockey.service.BaseSevice"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setContentType("application/json");
		/**
		 * response.getWriter();
		 * 获取了一个输出流 输出的对象是页面 
		 * 这就像System.out.print（）一样 
		 * 只不过这个输出对象的是命令提示符窗口  他们都是包装好的 实际用输出流时 之前应该指向一个文件的 
		 * */
		 
		PrintWriter writer = response.getWriter();
		BaseSevice baseSevice=new BaseSevice();
		UserService userService=new UserService();
		User user=null;
		//拿到$("#editform").serialize();
		String jsonString =baseSevice.getStringFromReq(request) ;
		System.out.println("jsonString..."+jsonString);

		//通过拿到的querystring转换为map
		Map<String, Object> map = baseSevice.getMapFromQueryString(jsonString);
		System.out.println("map:"+map);
		
		//遍历map得到前端传入的值
		String telephone=null;
		String password=null;
		Iterator<Entry<String,Object>> iter = map.entrySet().iterator(); 
	    while(iter.hasNext()){ 
	        Entry<String,Object> entry = iter.next(); 
	        String key = entry.getKey(); 
	        Object value = entry.getValue();
	        if(key.equals("phoneNumber")){      	 
	        	telephone=(String)value;
	        }
	        if(key.equals("verificationCode")){
	        	password=(String)value;
	        }        
	        System.out.println(key+" "+value); 
	    }
	    //登录函数
	    user=userService.loginByTelepone(telephone, password);
	    
	    if(user!=null){
	    	System.out.println(user);
	    	
	    	map.put("userId", user.getUserId());
	    	map.put("weChatId", user.getWeChatId());
	    	map.put("telephone", user.getTelephone());
	    	map.put("userName", user.getUserName());
	    	map.put("sex", user.getSex());
	    	map.put("password", user.getPassword());
	    	map.put("birthday", user.getBirthday());
	    	map.put("country", user.getCountry());
	    	map.put("city", user.getCity());
	    	map.put("play", user.getPlay());
	    	map.put("ice_play", user.getIce_player());
	    	map.put("snow_play", user.getSnow_play());
	    	map.put("roleId", user.getRoleId());
	    	map.put("handlingId", user.getHandlingId());
	    	map.put("image", user.getImage());
	    	
	    	System.out.println("map找到啦..."+map);
	    }else{
	    	System.out.println("map未找到...");
	    	map=null;
	    }
		//将转换得到的map转换为json并返回
		ObjectMapper objectMapper = new ObjectMapper();
		String resultJson = objectMapper.writeValueAsString(map);
		
		//此处直接返回JSON object对象，JSP可直接使用data.key
		System.out.println("resultJson ..."+resultJson);

		resultJson = resultJson.replace("\"", "\\\"");
		resultJson = "\""+resultJson+"\"";
		//此处返回JSON 字符串 string对象;JSP需要解析才能使用data.key
		System.out.println("resultJson ..."+resultJson);

		writer.print(resultJson);
		writer.flush();
		writer.close();
	%>
</body>
</html>