package com.icehockey.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icehockey.entity.Degree;
import com.icehockey.entity.Honor;
import com.icehockey.entity.JudgeCompetition;
import com.icehockey.entity.User;
import com.icehockey.service.DegreeService;
import com.icehockey.service.HonorService;
import com.icehockey.service.JudgeCompetitionService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class JudgeInfoServlet
 */
@WebServlet("/JudgeInfoServlet.do")
public class JudgeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JudgeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		UserService userService = new UserService();
		User user = null;
		
		String userIds = request.getParameter("userId");// userId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);

		String openInfoButton = request.getParameter("openInfo");//裁判员个人信息
		System.out.println("openInfoButton:" + openInfoButton);
		String openDegreeButton = request.getParameter("openDegree");//裁判员等级资质
		System.out.println("openDegreeButton:" + openDegreeButton);
		String openHonorButton = request.getParameter("openHonor");//获得荣耀
		System.out.println("openHonorButton:" + openHonorButton);
		String openExpButton = request.getParameter("openExp");//裁判员执教经历
		System.out.println("openExpButton:" + openExpButton);
		String openActButton = request.getParameter("openAct");//裁判员执教年限
		System.out.println("openActButton:" + openActButton);
		
		String backButton=request.getParameter("back");//单击返回
		System.out.println("backButton:" + backButton);
		
		String settingButton=request.getParameter("setting");//单击设置系统
		System.out.println("settingButton:"+settingButton);
		
		System.out.println("MyInfo:userId :"+userId);
		user=userService.queryUserByUserId(userId);
		
		if (user != null) {// 查找到当前Id对应的球员对象
			System.out.println(user);
			if (settingButton != null) {
				System.out.println(settingButton);
				request.setAttribute("user", user);
				//System.out.println(user.toString());
				request.getRequestDispatcher("SystemSetting.jsp").forward(request, response);
			}
			if (openInfoButton != null) {
				request.setAttribute("user", user);
				//System.out.println(user.toString());
				request.getRequestDispatcher("JudgeMyInfo.jsp").forward(request, response);
			}
			if (openDegreeButton != null) {
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				DegreeService degreeService = new DegreeService();
				Degree degree = null;
				degree = degreeService.queryDegreeNameByUserId("judge", userId);

				if (degree != null) {
					request.setAttribute("degree", degree);
					System.out.println(degree);			
				request.setAttribute("user", user);
				//System.out.println(user.toString());
				request.getRequestDispatcher("JudgeDegree.jsp").forward(request, response);
				}else {
					System.out.println("教练等级不存在");
					request.setAttribute("user", user);
					//System.out.println(user.toString());
					request.getRequestDispatcher("JudgeDegree.jsp").forward(request, response);
				}
			}
			if (openHonorButton != null) {
				HonorService honorService = new HonorService();
				List<Honor> hrS = null;
				hrS = honorService.queryHonorRecordByUserId("judge", userId);
				if (hrS != null) {
					System.out.println(hrS.size());
					request.setAttribute("hrS", hrS);
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("JudgeHonor.jsp").forward(
							request, response);
				} else {
					System.out.println("获得荣誉记录不存在");
					request.setAttribute("user", user);
					// System.out.println(user.toString());
					request.getRequestDispatcher("JudgeHonor.jsp").forward(
							request, response);
				}
				
			}
			if (openExpButton != null) {
				JudgeCompetitionService competitionService=new JudgeCompetitionService();
				List<JudgeCompetition> competitions=null;
				competitions=competitionService.queryJudgeExpByUserId(userId);
				if(competitions!=null){
					request.setAttribute("competitions", competitions);
					request.setAttribute("user", user);
					//System.out.println(user.toString());
					request.getRequestDispatcher("JudgeExp.jsp").forward(request, response);
				}else{
					System.out.println("该裁判员无主持记录");
					request.setAttribute("user", user);
					//System.out.println(user.toString());
					request.getRequestDispatcher("JudgeExp.jsp").forward(request, response);
				}
				
			}
			if (openActButton != null) {
				JudgeCompetitionService competitionService=new JudgeCompetitionService();
				List<JudgeCompetition> competitions=null;
				competitions=competitionService.queryJudgeExpByUserId(userId);
				if(competitions!=null){
					request.setAttribute("competitions", competitions);
					request.setAttribute("user", user);
					//System.out.println(user.toString());
					request.getRequestDispatcher("JudgeMyAct.jsp").forward(request, response);
				}else{
					System.out.println("该裁判员无活动记录");
					request.setAttribute("user", user);
					//System.out.println(user.toString());
					request.getRequestDispatcher("JudgeMyAct.jsp").forward(request, response);
				}
			}
			if (backButton != null) {
				request.setAttribute("user", user);
				//System.out.println(user.toString());
				request.getRequestDispatcher("Begin.jsp").forward(request, response);
			}

		} else {// 查找失败
			request.setAttribute("user", user);
			//System.out.println(user.toString());
			request.getRequestDispatcher("JudgeInfo.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
