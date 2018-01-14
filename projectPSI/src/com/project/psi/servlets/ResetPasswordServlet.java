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

@WebServlet("/reset")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		String login = null;
		if (session != null) {
			login = (String) session.getAttribute("session");
		}
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String url = null;

		if (!password.equals(confirmPassword)) {
			url = "/changePassword.jsp";
			request.setAttribute("msg", "Has³o zosta³o u¿yte lub musisz podaæ dwa takie same");
		} else
			try {
				if (ConnectionJDBC.changePassword(login, confirmPassword)) {
					url = "/changePassword.jsp";
					request.setAttribute("success", "Has³o zosta³o zmienione");
				} else {
					url = "/changePassword.jsp";
					request.setAttribute("msg", "Has³o zosta³o u¿yte lub musisz podaæ dwa takie same");
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
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
