package com.icehockey.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icehockey.entity.Player;
import com.icehockey.service.PlayerService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PlayerService playerService = new PlayerService();
		Player player = null;
		
		String playerIds=request.getParameter("playerId");//playerId
		
		System.out.println("main:playerIds :"+playerIds);
		int playerId=Integer.parseInt(playerIds);
		
		System.out.println("main:playerId :"+playerId);
		player=playerService.queryPlayerByPlayerId(playerId);
		if(player!=null){
			request.setAttribute("player",player);
			request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
		}else{
			request.setAttribute("player",player);
			request.getRequestDispatcher("main.jsp").forward(request, response);
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
