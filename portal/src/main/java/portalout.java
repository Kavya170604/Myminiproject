

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class portalout
 */
@WebServlet("/portalout")
public class portalout extends HttpServlet{
	PrintWriter pw;
protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {	
	HttpSession hsp=req.getSession();
    hsp.getAttribute("un");
    hsp.invalidate();
    pw=res.getWriter();
    RequestDispatcher rd=req.getRequestDispatcher("generalpage.html");
	rd.include(req, res);
    pw.print("logout Successfully");
    
}
}
