<%@page
	import="org.codehaus.jackson.map.ObjectMapper,java.util.HashMap,java.util.Map,com.icehockey.entity.User,com.icehockey.service.UserService,java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setContentType("application/json");
	System.out.println("------------------------body.html--------------------------------------");
	PrintWriter writer = response.getWriter();
	UserService userService = new UserService();
	User user = null;
	Map<String, Object> map = new HashMap<String, Object>();
	int userId = -1;
	String userid = "";
	//前端获取传入的data
	if (request.getParameter("userid") != null) {
		userid = request.getParameter("userid");
		//转化Id
		userId = Integer.parseInt(userid);
	} else {
		map.put("userid", "null");
	}

	//按照userId检索数据库找到user
	user = userService.queryUserByUserId(userId);
	if (user != null) {//插入成功
		System.out.println("找到当前用户" + user);

		//处理成功返回result=0	
		map.put("result", "0");
		map.put("userId", userId);
		map.put("userid", userid);

	} else {
		System.out.println("map未找到...");
		map.put("result", "-1");
	}
	//将转换得到的map转换为json并返回
	ObjectMapper objectMapper = new ObjectMapper();
	String resultJson = objectMapper.writeValueAsString(map);
	//System.out.println("resultJson ..." + resultJson);
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