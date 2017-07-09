package com.icehockey.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icehockey.entity.Coach;
import com.icehockey.entity.User;
import com.icehockey.service.CoachService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class CoachPerInfoServlet
 */
@WebServlet("/CoachPerInfoServlet.do")
public class CoachPerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoachPerInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		Coach coach = null;
		CoachService coachService = new CoachService();
		UserService userService = new UserService();
		User user = null;

		String userIds = request.getParameter("userId");// userId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);

		System.out.println("CoachPerInfo:userId :" + userId);
		user = userService.queryUserByUserId(userId);

		String backButton = request.getParameter("back");
		System.out.println("backButton:" + backButton);

		coach = coachService.queryCoachByUserId(userId);
		if (backButton != null) {
			if (coach != null) {
				request.setAttribute("coach", coach);
				request.setAttribute("user", user);
				request.getRequestDispatcher("CoachInfo.jsp").forward(request, response);
			}else{
				System.out.println("该教练不存在");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
