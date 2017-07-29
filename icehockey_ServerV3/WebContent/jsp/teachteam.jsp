<%@page import="com.icehockey.entity.TeamRecord,java.util.List,com.icehockey.service.TeamRecordService,org.codehaus.jackson.map.ObjectMapper,java.util.HashMap,java.util.Map,com.icehockey.entity.User,com.icehockey.service.UserService,java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		System.out.println("------------------------teachteam.html--------------------------------------");
		PrintWriter writer = response.getWriter();
		UserService userService = new UserService();
		User user = null;
		Map<String, Object> map  = new HashMap<String, Object>();
		TeamRecordService teamRecordService=new TeamRecordService();
		int userId = -1;
		//前端获取传入的data
		String userid = null;
		if (request.getParameter("userid") != null) {
			userid = request.getParameter("userid");
			userId = Integer.parseInt(userid);
		} else {
			map.put("userid", "null");
		}
		
		user = userService.queryUserByUserId(userId);
		if (user != null) {//插入成功
			System.out.println("找到当前用户" + user);
			List<TeamRecord> teamRecords=teamRecordService.queryTeamRecordByUserId(userId);
			if(teamRecords!=null){
				map.put("teamRecords", teamRecords);
			}else{
				System.out.println("未找到执教俱乐部记录");
			}
		
			//处理成功返回result=0	
			map.put("result", "0");
			map.put("userId", userId);
			map.put("userid", userId);
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