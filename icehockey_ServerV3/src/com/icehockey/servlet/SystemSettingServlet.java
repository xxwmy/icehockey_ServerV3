package com.icehockey.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icehockey.entity.Role;
import com.icehockey.entity.User;
import com.icehockey.service.RoleService;
import com.icehockey.service.UserService;

/**
 * Servlet implementation class SystemSettingServlet
 */
@WebServlet("/SystemSettingServlet.do")
public class SystemSettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SystemSettingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String backButton = request.getParameter("back");// 单击返回
		System.out.println("backButton:" + backButton);

		UserService userService = new UserService();
		RoleService roleService=new RoleService();
		User user = null;
		Role role=null;
		
		String userIds = request.getParameter("userId");// userId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);

		System.out.println("Setting:userId :"+userId);
		user=userService.queryUserByUserId(userId);

		if (backButton != null) {
			role=roleService.queryRole(user.getRoleId());
			System.out.println(role.getRoleName());
			if("裁判".equals(role.getRoleName())){
				request.setAttribute("user",user);
				request.getRequestDispatcher("JudgeInfo.jsp").forward(request, response);
			
			}else if("教练".equals(role.getRoleName())){
				request.setAttribute("user",user);
				request.getRequestDispatcher("CoachInfo.jsp").forward(request, response);
			
			}else{
				request.setAttribute("user",user);
				request.getRequestDispatcher("MyInfo.jsp").forward(request, response);
			
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
