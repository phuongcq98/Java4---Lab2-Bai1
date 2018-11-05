package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchAccount
 */
public class SearchAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>SearchAccount</title></head>");
		out.println("<body><h1>Result: </h1>");
		out.println("<table border=1 cellPadding=1 cellSpacing=1>");
		String username = request.getParameter("txtUser");
		String place = request.getParameter("txtAddress");
		String phone=request.getParameter("txtPhone");
		// xây dựng lệnh SQL 
		
		StringBuilder queryStb = new StringBuilder("select * from customer where 1 = 1 ");
		
		if(!username.equals("")) {
			queryStb.append(" and username like '%"+ username + "%'");
		}
		
		if(!place.equals("")) {
			queryStb.append(" and place like '%" + place + "%'");
		}
		
		if(!phone.equals("")) {
			queryStb.append(" and phone like '%" + phone + "%'");
		}
		
		String newSQL=queryStb.toString();
		
		
		
		String conStr = "jdbc:sqlserver://localhost:1433;databaseName=phone_management";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Connection con = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(conStr, "sa", "123456");
			stmt = con.createStatement();
			rs = stmt.executeQuery(newSQL);
			out.println("<tr><th>No</th><th>Username</th><th>Phone</th><th>Address</th></tr>\n");
			if (rs != null) {
				for (int i = 1; rs.next();) {
					out.println("<tr>" + "<td>" + i++ + "</td>" + "<td>" + rs.getString(2) + "</td>" + "<td>"
							+ rs.getString(3) + "</td>" + "<td>" + rs.getString(4) + "</td></tr>\n");
				}
			}
			out.println("</table>");
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
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
