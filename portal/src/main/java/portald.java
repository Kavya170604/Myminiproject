

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class portald
 */
@WebServlet("/portald")
public class portald extends HttpServlet {
	PrintWriter pw;
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {	
		pw=res.getWriter();
		RequestDispatcher red=req.getRequestDispatcher("generalpage.html");
		red.include(req, res);
		HttpSession hsp=req.getSession();
		String user=(String)hsp.getAttribute("un");
		if(user==null) {
			
		RequestDispatcher red1=req.getRequestDispatcher("login.html");
		red1.include(req, res);
		
		}
		else {
		pw.print("Welcome "+user);
		}
	}	
	

}
