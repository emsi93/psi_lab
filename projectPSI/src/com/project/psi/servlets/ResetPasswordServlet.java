package com.project.psi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reset")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String url = null;

		if (!password.equals(confirmPassword)) {
			url = "/changePassword.jsp";
			request.setAttribute("msg", "Has�o zosta�o u�yte lub musisz poda� dwa takie same");
		} else{
			url = "/verifyChangePassword.jsp";
			request.setAttribute("password", password);
			
			
			/*try {
				if (ConnectionJDBC.changePassword(login, confirmPassword)) {
					url = "/changePassword.jsp";
					request.setAttribute("success", "Has�o zosta�o zmienione");
				} else {
					url = "/changePassword.jsp";
					request.setAttribute("msg", "Has�o zosta�o u�yte lub musisz poda� dwa takie same");
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();*/
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
