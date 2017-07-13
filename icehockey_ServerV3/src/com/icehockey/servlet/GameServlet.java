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
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet.do")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

	
		String backButton = request.getParameter("back");// 单击返回
		System.out.println("backButton:" + backButton);

		UserService userService = new UserService();
		User user = null;
		
		String userIds = request.getParameter("userId");// userId
		int userId = Integer.parseInt(userIds);
		System.out.println("userId:aaaaaaaaaa" + userId);
		
		System.out.println("PerInfo:userId :"+userId);
		user=userService.queryUserByUserId(userId);

		if (backButton != null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("MyInfo.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
