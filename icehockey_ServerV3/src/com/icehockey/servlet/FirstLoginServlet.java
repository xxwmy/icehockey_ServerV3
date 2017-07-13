package com.icehockey.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icehockey.entity.Coach;
import com.icehockey.entity.Judge;
import com.icehockey.entity.Player;
import com.icehockey.entity.User;
import com.icehockey.service.CoachService;
import com.icehockey.service.JudgeService;
import com.icehockey.service.PlayerService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class FirstLoginServlet
 */
@WebServlet("/FirstLoginServlet.do")
public class FirstLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstLoginServlet() {
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

		PlayerService playerService = new PlayerService();
		CoachService coachService = new CoachService();
		JudgeService judgeService = new JudgeService();
		UserService userService = new UserService();
		Coach coach = null;
		Judge judge = null;
		Player player = null;
		User user = null;

		String userIds = request.getParameter("userId");// userId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);

		String playRadioValue = request.getParameter("play");
		System.out.println("playRadioValue:" + playRadioValue);
		String ice_playRadioValue = request.getParameter("ice_play");
		System.out.println("ice_playRadioValue:" + ice_playRadioValue);
		String snow_playRadioValue = request.getParameter("snow_play");
		System.out.println("snow_playRadioValue:" + snow_playRadioValue);
		String roleRadioValue = request.getParameter("role");
		System.out.println("roleRadioValue:" + roleRadioValue);
		String handRadioValue = request.getParameter("hand");
		System.out.println("handRadioValue:" + handRadioValue);

		user = userService.queryUserByUserId(userId);
		System.out.println(user.toString());

		user = userService.updateUserByUserId(userId, playRadioValue, ice_playRadioValue, snow_playRadioValue,
				roleRadioValue, handRadioValue);
		if (user != null) {
			System.out.println(user);
			if ("player".equals(roleRadioValue)) {
				player = playerService.insertPlayer(userId);
				System.out.println(player);
				if (player != null) {
					request.setAttribute("user", user);
					System.out.println(user.toString());
					// request.setAttribute("player", player);
					request.getRequestDispatcher("MoreInfo.jsp").forward(request, response);
				} else {
					System.out.println("moinfoplayer更新失败");
					request.setAttribute("user", user);
					System.out.println(user.toString());
					// request.setAttribute("player", player);
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}

			} else if ("keeper".equals(roleRadioValue)) {
				player = playerService.insertPlayer(userId);
				System.out.println(player);
				if (player != null) {
					request.setAttribute("user", user);
					System.out.println(user.toString());
					// request.setAttribute("player", player);
					request.getRequestDispatcher("MoreInfo.jsp").forward(request, response);
				} else {
					System.out.println("moinfoplayer更新失败");
					request.setAttribute("user", user);
					System.out.println(user.toString());
					// request.setAttribute("player", player);
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
			} else if ("coach".equals(roleRadioValue)) {
				coach = coachService.insertCoach(userId);
				System.out.println(coach);
				if (coach != null) {
					request.setAttribute("user", user);
					System.out.println(user.toString());
					// request.setAttribute("coach", coach);
					request.getRequestDispatcher("MoreInfo.jsp").forward(request, response);
				} else {
					System.out.println("moinfocoach更新失败");
					request.setAttribute("user", user);
					System.out.println(user.toString());
					// request.setAttribute("coach", coach);
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}

			} else if ("judge".equals(roleRadioValue)) {
				judge = judgeService.insertJudge(userId);
				System.out.println(judge);
				if (judge != null) {
					request.setAttribute("user", user);
					System.out.println(user.toString());
					// request.setAttribute("judge", judge);
					request.getRequestDispatcher("MoreInfo.jsp").forward(request, response);
				} else {
					System.out.println("moinfojudge更新失败");
					request.setAttribute("user", user);
					System.out.println(user.toString());
					// request.setAttribute("judge", judge);
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
			}
		} else {
			System.out.println("当前编号用户未找到，更新失败");
			request.setAttribute("user", user);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
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
