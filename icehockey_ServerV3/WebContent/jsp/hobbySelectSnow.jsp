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
	<input id="userId" type="hidden" value="${user.userId}" />
	<%
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		/**
		 * response.getWriter();
		 * 获取了一个输出流 输出的对象是页面 
		 * 这就像System.out.print（）一样 
		 * 只不过这个输出对象的是命令提示符窗口  他们都是包装好的 实际用输出流时 之前应该指向一个文件的 
		 
		 * */
		System.out.println();
		System.out.println("------------------------hobbySelectSnow.html--------------------------------------");
		PrintWriter writer = response.getWriter();
		BaseSevice baseSevice = new BaseSevice();
		UserService userService = new UserService();
		User user = null;
		Map<String, Object> map = null;
		String name = "";
		
		//备用seesion
		user = (User) session.getAttribute("sessionUser");
		System.out.println("sessionUser:  " + user);
		//获取session的Id
		String sessionId = session.getId();
		//判断session是不是新创建的\
		int userId;
		if (session.isNew()) {
			userId = -1;
			System.out.println("session创建成功，session的id是：" + sessionId);
		} else {
			System.out.println("user:  " + user);
			userId = user.getUserId();
			System.out.println("服务器已经存在该session了，session的id是：" + sessionId);
		}
		
		name=request.getParameter("userid").toString();
		System.out.println("name...."+name);
	
		//获得当前会话中的用户
		//session = request.getSession(); 
		 
		
		//前端获取传入的data
		String play = request.getParameter("play");
		String userid = request.getParameter("userid");
		String ice_play = request.getParameter("ice_play");//ice_play
		String snow_play = request.getParameter("snow_play");//snow_play
		//转化Id
		userId=Integer.parseInt(userid);
		System.out.println("play:" + play);
		System.out.println("userid:" + userid);
		System.out.println("userId:" + userId);
		System.out.println("ice_play:" + ice_play);
		System.out.println("snow_play:" + snow_play);
		//String jsonString = baseSevice.getStringFromReq(request);
		//System.out.println("jsonString..." + jsonString);
		String jsonString = "play=" + play;	
		jsonString+="&ice_play=" + ice_play;
		jsonString+="&userid=" + userid;
		jsonString+="&snow_play=" + snow_play;
		System.out.println("jsonString..." + jsonString);
		if (jsonString.length() != 0) {
			System.out.println("jsonString..." + jsonString.length());
			//通过拿到的querystring转换为map
			map = baseSevice.getMapFromQueryString(jsonString);
			System.out.println("map:" + map);

		
			//按照userId检索数据库找到user
			user = userService.queryUserByUserId(userId);
			if (user != null) {//插入成功
				System.out.println("找到当前用户" + user);

				//将play放入session中
				session = request.getSession();
				session.setAttribute("play", play);

				//处理成功返回result=0	
				map.put("result", "0");
				map.put("userId", userId);
				map.put("userid",userId);
				map.put("play", play);
				map.put("ice_play", ice_play);
				map.put("snow_play", snow_play);
				System.out.println("map找到啦..." + map);
			} else {
				System.out.println("map未找到...");
				//第一次登陆返回result=1
				map.put("result", "-1");
			}
			//将转换得到的map转换为json并返回
			ObjectMapper objectMapper = new ObjectMapper();
			String resultJson = objectMapper.writeValueAsString(map);
			//此处直接返回JSON object对象，JSP可直接使用data.key
			//System.out.println("resultJson ..." + resultJson);

			resultJson = resultJson.replace("\"", "\\\"");
			resultJson = "\"" + resultJson + "\"";
			//此处返回JSON 字符串 string对象;JSP需要解析才能使用data.key
			System.out.println("resultJson ..." + resultJson);

			writer.print(resultJson);
		} else {
			System.out.println("jsonString...是空的");
			map = null;
		}
		writer.flush();
		writer.close();
	%>
</body>
</html>