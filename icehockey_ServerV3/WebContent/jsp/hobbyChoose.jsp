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
		System.out.println("------------------------hobbyChoose.html--------------------------------------");
		PrintWriter writer = response.getWriter();
		BaseSevice baseSevice = new BaseSevice();
		UserService userService = new UserService();
		User user = null;
		Map<String, Object> map = null;
		int userId = -1;

		String play = request.getParameter("play");//前端获取传入的data
		String userid = request.getParameter("userid");
		userId = Integer.parseInt(userid);

		user = userService.queryUserByUserId(userId);
		if (user != null) {//插入成功
			System.out.println("找到当前用户" + user);
			map = new HashMap<String, Object>();
			//处理成功返回result=0	
			map.put("result", "0");
			map.put("userId", userId);
			map.put("userid", userId);
			map.put("play", play);
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
		resultJson = resultJson.replace("\"", "\\\"");
		resultJson = "\"" + resultJson + "\"";
		//此处返回JSON 字符串 string对象;JSP需要解析才能使用data.key
		System.out.println("resultJson ..." + resultJson);
		writer.print(resultJson);
		writer.flush();
		writer.close();
	%>
</body>
</html>