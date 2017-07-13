package com.icehockey.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icehockey.entity.User;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class MoreInfoServlet
 */
@WebServlet("/MoreInfoServlet.do")
public class MoreInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MoreInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		UserService userService=new UserService();
		User user=null;
		
		
		String userIds = request.getParameter("userId");// playerId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);
		
		int sex = Integer.parseInt(request.getParameter("sex"));
		double height = 0;
		if (!("".equals(request.getParameter("height")))) {
			height = Double.parseDouble(request.getParameter("height"));
		}

		double weight = 0;
		if (!("".equals(request.getParameter("weight")))) {
			weight = Double.parseDouble(request.getParameter("weight"));
		}

		int countryValue = Integer.parseInt(request.getParameter("country"));
		String city = request.getParameter("city");
		int xianxiaolijvlebuValue = Integer.parseInt(request.getParameter("jvlebu"));
		int xianshuqiuduiValue = Integer.parseInt(request.getParameter("qiudui"));

		String country = "";
		switch (countryValue) {
		case 0:
			country = "外籍";
			break;

		default:
			country = "中国";
			break;
		}
		String xianxiaolijvlebu = "";
		switch (xianxiaolijvlebuValue) {
		case 1:
			xianxiaolijvlebu = "齐齐哈尔兰迪女子冰球俱乐部";
			break;
		case 2:
			xianxiaolijvlebu = "河北吉象冰球俱乐部";
			break;
		case 3:
			xianxiaolijvlebu = "天津国王冰球队";
			break;
		default:
			xianxiaolijvlebu = "哈尔滨冰星冰球俱乐部";
			break;
		}

		String xianshuqiudui = "";

		switch (xianshuqiuduiValue) {
		case 1:
			xianshuqiudui = "青岛虎鲸非凡";
			break;
		case 2:
			xianshuqiudui = "锋翼二队";
			break;
		case 3:
			xianshuqiudui = "大庆奥利人";
			break;
		default:
			xianshuqiudui = "明日之星火龙";
			break;
		}

		user=userService.insertUser(userId,sex,height,weight,country,city,xianxiaolijvlebu,xianshuqiudui);
		if (user != null) {
			System.out.println(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("Begin.jsp").forward(request, response);

		} else {
			System.out.println("更多信息更细失败");
			request.setAttribute("user", user);
			request.getRequestDispatcher("MoreInfo.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
