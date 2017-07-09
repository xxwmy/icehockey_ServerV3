package com.icehockey.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icehockey.entity.ClubRecord;
import com.icehockey.entity.CoachPlayer;
import com.icehockey.entity.TeamRecord;
import com.icehockey.entity.User;
import com.icehockey.service.ClubRecordService;
import com.icehockey.service.CoachPlayerService;
import com.icehockey.service.TeamRecordService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet("/MyInfoServlet.do")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		UserService userService = new UserService();
		User user = null;

		String userIds = request.getParameter("userId");// userId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);

		String openInfoButton = request.getParameter("openInfo");
		System.out.println("openInfoButton:" + openInfoButton);
		String openCoachButton = request.getParameter("openCoach");
		System.out.println("openCoachButton:" + openCoachButton);
		String openHonorButton = request.getParameter("openHonor");
		System.out.println("openHonorButton:" + openHonorButton);
		String openClubButton = request.getParameter("openClub");
		System.out.println("openClubButton:" + openClubButton);
		String openCompetitionButton = request.getParameter("openCompetition");
		System.out.println("openCompetitionButton:" + openCompetitionButton);
		String openEquipButton = request.getParameter("openEquip");
		System.out.println("openEquipButton:" + openEquipButton);
		String openExperienceButton = request.getParameter("openExperience");
		System.out.println("openExperienceButton:" + openExperienceButton);

		String backButton = request.getParameter("back");// 单击返回
		System.out.println("backButton:" + backButton);

		String settingButton = request.getParameter("setting");// 单击设置系统
		System.out.println("settingButton:" + settingButton);

		System.out.println("MyInfo:userId :" + userId);
		user = userService.queryUserByUserId(userId);

		if (user != null) {// 查找到当前Id对应的球员对象
			System.out.println(user);
			if (settingButton != null) {
				System.out.println(settingButton);
				request.setAttribute("user", user);
				// System.out.println(user.toString());
				request.getRequestDispatcher("SystemSetting.jsp").forward(
						request, response);
			}
			if (openInfoButton != null) {
				request.setAttribute("user", user);
				// System.out.println(user.toString());
				request.getRequestDispatcher("PerInfo.jsp").forward(request,
						response);
			}
			if (openCoachButton != null) {

				CoachPlayerService coachPlayerService = new CoachPlayerService();
				List<CoachPlayer> coachPlayers = null;
				coachPlayers = coachPlayerService
						.queryCoachPlayerRecordByCoachId("player", userId);
				if (coachPlayers != null) {
					request.setAttribute("coachPlayers", coachPlayers);
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("PlayerCoach.jsp").forward(
							request, response);
				} else {
					System.out.println("教练球员对应记录不存在");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("PlayerCoach.jsp").forward(
							request, response);
				}
			}
			if (openHonorButton != null) {
				request.setAttribute("user", user);
				// System.out.println(user.toString());
				request.getRequestDispatcher("Gain.jsp").forward(request,
						response);
			}
			if (openClubButton != null) {
				request.setAttribute("user", user);
				// System.out.println(user.toString());
				request.getRequestDispatcher("WaitDevelop.jsp").forward(
						request, response);
			}
			if (openCompetitionButton != null) {

				TeamRecordService teamRecordService = new TeamRecordService();
				List<TeamRecord> teamRecords = null;
				teamRecords = teamRecordService.queryTeamRecordByUserId(
						"coach", userId);
				if (teamRecords == null) {
					System.out.println("教练所在球队记录不存在");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("Game.jsp").forward(request,
							response);
				} else {
					request.setAttribute("teamRecords", teamRecords);
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("Game.jsp").forward(request,
							response);
				}
			}
			if (openEquipButton != null) {
				request.setAttribute("user", user);
				// System.out.println(user.toString());
				request.getRequestDispatcher("Equipment.jsp").forward(request,
						response);
			}
			if (openExperienceButton != null) {
				ClubRecordService clubRecordService = new ClubRecordService();
				List<ClubRecord> clubRecords = null;
				clubRecords = clubRecordService.queryClubRecordByUserId(
						"player", userId);
				TeamRecordService teamRecordService = new TeamRecordService();
				List<TeamRecord> teamRecords = null;
				teamRecords = teamRecordService.queryTeamRecordByUserId(
						"player", userId);
				if (teamRecords == null) {
					System.out.println("teamRecords无记录");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("Experience.jsp").forward(
							request, response);
				} else if (clubRecords == null) {
					System.out.println("clubRecords无记录");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("Experience.jsp").forward(
							request, response);

				} else {
					request.setAttribute("teamRecords", teamRecords);
					request.setAttribute("clubRecords", clubRecords);
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("Experience.jsp").forward(
							request, response);
				}
			}
			if (backButton != null) {
				request.setAttribute("user", user);
				// System.out.println(user.toString());
				request.getRequestDispatcher("Begin.jsp").forward(request,
						response);
			}

		} else {// 查找失败
			request.setAttribute("user", user);
			// System.out.println(user.toString());
			request.getRequestDispatcher("MyInfo.jsp").forward(request,
					response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
