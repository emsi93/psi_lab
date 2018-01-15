package com.project.psi.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.psi.db.jdbc.ConnectionJDBC;

@WebServlet("/verifyChangePassword")
public class VerifyChangePasswordServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public VerifyChangePasswordServlet(){
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		String decision = request.getParameter("decision");
		String login = null;
		String password  = (String) request.getParameter("password");
		if (session != null) {
			login = (String) session.getAttribute("session");
			
		}
		String url = null;
	
		if(decision.equals("yes")){
			try {
				if(decision.equals("yes") && ConnectionJDBC.changePassword(login, password)){
					url = "/changePassword.jsp";
					request.setAttribute("success", "Has這 zosta這 zmienione");
				}else{
					url = "/changePassword.jsp";
					request.setAttribute("msg", "Has這 zosta這 u篡te");
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}else{
			url = "/welcome.jsp";
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
