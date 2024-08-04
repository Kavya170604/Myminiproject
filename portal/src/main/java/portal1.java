

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
 * Servlet implementation class portal1
 */
@WebServlet("/portal1")
public class portal1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {	
		PrintWriter pw=res.getWriter();
		String user=req.getParameter("username");
			String pass=req.getParameter("passwords");
			RequestDispatcher rd=req.getRequestDispatcher("generalpage.html");
			rd.include(req, res);
			try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","rootroot");
			String str="select * from login1;";
			PreparedStatement ps=con.prepareStatement(str);
			 ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					String n1=rs.getString("username");
					String n2=rs.getString("passwords");
				if(user.equals(n1)&& pass.equals(n2)) {
                  HttpSession hsp=req.getSession();
                  hsp.setAttribute("un",user);
                  pw.print("login successfully");
                  RequestDispatcher red=req.getRequestDispatcher("portald");
                  red.forward(req, res);	
			}

			
            else {
				RequestDispatcher rad=req.getRequestDispatcher("login.html");
                  rad.forward(req, res);	
			}
				}
				}
			catch(SQLException e) {
				e.printStackTrace();
				
			}
	}

}

