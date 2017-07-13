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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		
	//	PlayerService playerService=new PlayerService();
		UserService userService=new UserService();
		
		User user=null;
		String telephone=request.getParameter("telephoneNumber");
		//String verifyCode=request.getParameter("verifyCode");
		String userName=request.getParameter("playerName");
		String password=request.getParameter("playerPassword");
		
		user=userService.queryByTelepone(telephone);
		
		if(user==null){
			//System.out.println(player);
			user=userService.insertUser(telephone,userName,password);
			System.out.println(user);
			
			request.setAttribute("user",user);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "该手机号已注册");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			
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
