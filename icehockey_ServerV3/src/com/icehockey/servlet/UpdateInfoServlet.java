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
 * Servlet implementation class ChangePerInfoServlet
 */
@WebServlet("/UpdateInfoServlet.do")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateInfoServlet() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		UserService userService = new UserService();
		User user = null;
		
		String userIds = request.getParameter("userId");// userId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);
		
		System.out.println("PerInfo:userId :"+userId);
		user=userService.queryUserByUserId(userId);
		
		String userName = request.getParameter("userName");
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		int countryValue = Integer.parseInt(request.getParameter("country"));
		String city = request.getParameter("city");

		String country = "";
		switch (countryValue) {
		case 0:
			country = "外籍";
			break;

		default:
			country = "中国";
			break;
		}

		user = userService.updateUser(userId, userName, height, weight, country, city);

		if (user != null) {
			System.out.println(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("Begin.jsp").forward(request, response);
		} else {
			request.setAttribute("user", user);
			request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
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
