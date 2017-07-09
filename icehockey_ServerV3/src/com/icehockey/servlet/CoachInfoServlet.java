package com.icehockey.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icehockey.entity.Coach;
import com.icehockey.entity.CoachPlayer;
import com.icehockey.entity.Degree;
import com.icehockey.entity.Experience;
import com.icehockey.entity.Honor;
import com.icehockey.entity.TeamRecord;
import com.icehockey.entity.User;
import com.icehockey.service.CoachPlayerService;
import com.icehockey.service.CoachService;
import com.icehockey.service.DegreeService;
import com.icehockey.service.ExperienceService;
import com.icehockey.service.HonorService;
import com.icehockey.service.TeamRecordService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class CoachInfoServlet
 */
@WebServlet("/CoachInfoServlet.do")
public class CoachInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoachInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		UserService userService = new UserService();
		User user = null;

		String userIds = request.getParameter("userId");// userId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);

		String openInfoButton = request.getParameter("openInfo");// 教练个人信息
		System.out.println("openInfoButton:" + openInfoButton);
		String openDegreeButton = request.getParameter("openDegree");// 教练等级资质
		System.out.println("openDegreeButton:" + openDegreeButton);
		String openHonorButton = request.getParameter("openHonor");// 获得荣耀
		System.out.println("openHonorButton:" + openHonorButton);
		String openExpButton = request.getParameter("openExp");// 教练执教经历
		System.out.println("openExpButton:" + openExpButton);
		String openYearButton = request.getParameter("openYear");// 教练执教年限
		System.out.println("openYearButton:" + openYearButton);
		String openStdButton = request.getParameter("openStd");// 执教学院
		System.out.println("openStdButton:" + openStdButton);

		String backButton = request.getParameter("back");// 单击返回
		System.out.println("backButton:" + backButton);

		String settingButton = request.getParameter("setting");// 单击设置系统
		System.out.println("settingButton:" + settingButton);

		System.out.println("MyInfo:userId :" + userId);
		user = userService.queryUserByUserId(userId);

		Coach coach = null;
		CoachService coachService = new CoachService();
		coach = coachService.queryCoachByUserId(userId);

		if (user != null && coach != null) {// 查找到当前Id对应的球员对象
			System.out.println(user);
			System.out.println(coach);
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
				request.getRequestDispatcher("CoachPerInfo.jsp").forward(
						request, response);
			}
			if (openDegreeButton != null) {
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				DegreeService degreeService = new DegreeService();
				Degree degree = null;
				degree = degreeService.queryDegreeNameByUserId("coach", userId);

				if (degree != null) {
					request.setAttribute("degree", degree);
					System.out.println(degree);
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachDegree.jsp").forward(
							request, response);
				} else {
					System.out.println("裁判员等级不存在");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachDegree.jsp").forward(
							request, response);
				}

			}
			if (openHonorButton != null) {
				HonorService honorService = new HonorService();
				List<Honor> hrS = null;
				hrS = honorService.queryHonorRecordByUserId("coach", userId);
				if (hrS != null) {
					System.out.println(hrS.size());
					request.setAttribute("hrS", hrS);
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachHonor.jsp").forward(
							request, response);
				} else {
					System.out.println("获得荣誉记录不存在");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachHonor.jsp").forward(
							request, response);
				}

			}
			if (openExpButton != null) {
				ExperienceService experienceService = new ExperienceService();
				List<Experience> experiences = null;
				experiences = experienceService.getExperienceByUserId(userId);
				TeamRecordService teamRecordService = new TeamRecordService();
				List<TeamRecord> teamRecords = null;
				teamRecords = teamRecordService.queryTeamRecordByUserId(
						"coach", userId);
				if (teamRecords == null) {
					System.out.println("教练所在球队记录不存在");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachZhijiaojingli.jsp")
							.forward(request, response);
				} else if (experiences == null) {
					System.out.println("执教经历不存在");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachZhijiaojingli.jsp")
							.forward(request, response);

				} else {
					request.setAttribute("teamRecords", teamRecords);
					request.setAttribute("experiences", experiences);
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachZhijiaojingli.jsp")
							.forward(request, response);
				}

			}
			if (openYearButton != null) {

				request.setAttribute("user", user);
				request.setAttribute("coach", coach);
				// System.out.println(user.toString());
				request.getRequestDispatcher("CoachZhijiaonianxian.jsp")
						.forward(request, response);
			}
			if (openStdButton != null) {

				CoachPlayerService coachPlayerService = new CoachPlayerService();
				List<CoachPlayer> coachPlayers = null;
				coachPlayers = coachPlayerService
						.queryCoachPlayerRecordByCoachId("coach",userId);
				if (coachPlayers != null) {
					request.setAttribute("coachPlayers", coachPlayers);
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachPlayer.jsp").forward(
							request, response);
				} else {
					System.out.println("教练球员对应记录不存在");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("CoachPlayer.jsp").forward(
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
			request.getRequestDispatcher("CoachInfo.jsp").forward(request,
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
