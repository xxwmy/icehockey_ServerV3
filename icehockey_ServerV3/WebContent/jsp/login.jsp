<%@page
	import="org.codehaus.jackson.map.ObjectMapper,java.util.HashMap,java.util.Map,com.icehockey.entity.User,com.icehockey.service.UserService,java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setContentType("application/json");
	System.out.println("-----------------login.html----------------------");
	PrintWriter writer = response.getWriter();
	UserService userService = new UserService();
	User user = null;
	Map<String, Object> map = null;
	//遍历map得到前端传入的值
	String telephone = null;
	String password = null;
	telephone = request.getParameter("phoneNumber");
	password = request.getParameter("verificationCode");
	//登录函数
	user = userService.loginByTelepone(telephone, password);
	if (user != null) {//登录成功
		System.out.println("找到当前用户" + user);
		map = new HashMap<String, Object>();
		//登录成功返回result=0；登陆失败返回result=-1，第一次登陆返回result=isFirst
		if (user.getPlay() == null) {
			map.put("result", "isFirst");
		} else {
			map.put("result", "0");
		}
		map.put("userid", user.getUserId());
		map.put("userId", user.getUserId());
		map.put("telephone", telephone);
		map.put("password", password);
		System.out.println("map找到啦..." + map);
	} else {
		System.out.println("map未找到...");
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>