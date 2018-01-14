package com.project.psi.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.psi.db.entity.History;

public class ConnectionJDBC {

	private static final String USER = "root";
	private static final String PASSWORD = "praktyka";
	private static final String URL = "jdbc:mysql://localhost/psi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	private static Connection conn;

	public static boolean login(String login, String password)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		connect();
		String query = "select checkLoginAndPassword('" + login + "','" + password + "') as wynik";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int wynik = 0;
		while (rs.next()) {
			wynik = rs.getInt("wynik");
		}

		if (wynik == 1) {
			close();
			return true;
		}

		close();
		return false;
	}

	public static List<History> getHistory(String login)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connect();
		String query = "SELECT h.date, h.description FROM history_login h INNER JOIN user u ON u.id = h.id_user WHERE u.login = '"
				+ login + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<History> allHistoryUser = new ArrayList<History>();
		while (rs.next()) {
			History history = new History(rs.getTimestamp(1).toLocalDateTime(), rs.getString(2));
			allHistoryUser.add(history);
		}
		close();
		return allHistoryUser;
	}

	public static boolean logout(String login)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connect();
		String query = "select logout('" + login + "') as wynik";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int wynik = 0;
		while (rs.next()) {
			wynik = rs.getInt("wynik");
		}

		if (wynik == 1) {
			close();
			return true;
		}

		close();
		return false;
	}

	public static boolean changePassword(String login, String password)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connect();
		String query = "select changePassword('" + login + "','" + password + "') as wynik";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int wynik = 0;
		while (rs.next()) {
			wynik = rs.getInt("wynik");
		}

		if (wynik == 1) {
			close();
			return true;
		}

		close();
		return false;
	}

	private static void connect()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	private static void close() throws SQLException {
		conn.close();
	}
}
