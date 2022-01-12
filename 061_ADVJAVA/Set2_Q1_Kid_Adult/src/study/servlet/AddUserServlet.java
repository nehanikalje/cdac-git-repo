package study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public static Connection makeConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://localhost:3306/user_db";
		String uname = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(jdbc_url, uname, pass);
		System.out.println("Yess you are connected to database now!!!-->"+con);
		return con;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		int age = Integer.parseInt(request.getParameter("uAge"));
		System.out.println(firstName + lastName + age);

		try 
		{
			Connection con = makeConnection();
			if(age<=18)
			{
				String sql = "INSERT INTO KID_TABLE VALUES(default,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, firstName);
				pstmt.setString(2, firstName);
				pstmt.setInt(3, age);
				pstmt.executeUpdate();
			}
			else
			{
				String sql = "INSERT INTO ADULT_TABLE VALUES(default,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, firstName);
				pstmt.setString(2, firstName);
				pstmt.setInt(3, age);
				pstmt.executeUpdate();
			}
			con.close();
		}
		
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		pw.append("<p>SUCCSESS!!!</p>");
	}
}
