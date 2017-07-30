<%@page import="com.icehockey.service.ErrorService"%>
<%@page
	import="org.codehaus.jackson.map.ObjectMapper,java.util.HashMap,java.util.Map,com.icehockey.entity.User,com.icehockey.service.UserService,java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		System.out.println("------------------------error.html--------------------------------------");
		PrintWriter writer = response.getWriter();
		ErrorService errorService=new ErrorService();
		Map<String, Object> map  = new HashMap<String, Object>();
	
		String errorName =null;
		if (request.getParameter("errorCheck") != null) {
			errorName = request.getParameter("errorCheck");
		} else {
			map.put("errorCheck", "null");
		}

		String errorDesc =null;
		if (request.getParameter("errorDesc") != null) {
			errorDesc = request.getParameter("errorDesc");
		} else {
			map.put("errorDesc", "null");
		}
		String contactInfo =null;
		if (request.getParameter("errorPhoneEmain") != null) {
			contactInfo = request.getParameter("errorPhoneEmain");
		} else {
			map.put("errorPhoneEmain", "null");
		}
		boolean t = errorService.insertError(errorName, errorDesc, contactInfo);			
		if (t) {//插入成功			
			map.put("result", "0");
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	

</body>
</html>