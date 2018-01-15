package com.project.psi.servlets;

import java.io.IOException;
import java.net.Inet4Address;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.psi.db.jdbc.ConnectionJDBC;

@WebServlet("/checkIP")
public class CheckIpServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public CheckIpServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String ipAddress = Inet4Address.getLocalHost().getHostAddress();
		String url = null;
		
		try {
			if(ConnectionJDBC.checkIpAddress(ipAddress)){
				url = "/index.jsp";
			}else{
				url = "/invalidaddress.jsp";
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
