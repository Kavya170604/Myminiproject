package com.cont;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class DoctorController
 */
@WebServlet("/DoctorController")
@MultipartConfig(maxFileSize=3333333)
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	String url="jdbc:mysql://localhost:3306/vsb";
	String unm="root";
	String pwd="rootroot";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname=request.getParameter("dname");
		String daddress =request.getParameter("daddress");
		String dgender =request.getParameter("dgender");
		String specialist =request.getParameter("specialist");
	    String contactno= request.getParameter("contactno");
		Connection con=null;
		String msg=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection(url,unm,pwd);
			String sql="insert into doctordata(dname,daddress,dgender,specialist,contactno) values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,dname);
			pst.setString(2,daddress);
			pst.setString(3,dgender);
			pst.setString(4,specialist);
			pst.setString(5,contactno);
			
			int res=pst.executeUpdate();
			if(res>0) {
				msg="Data uploaded successfully";
			}
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		getServletContext().getRequestDispatcher("/Message.jsp").forward(request,response);
	}

}
