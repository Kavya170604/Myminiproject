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
 * Servlet implementation class PatientController
 */
@WebServlet("/PatientController")
@MultipartConfig(maxFileSize=3333333)
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url="jdbc:mysql://localhost:3306/vsb";
	String unm="root";
	String pwd="rootroot";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname=request.getParameter("pname");
		String address =request.getParameter("address");
		String gender =request.getParameter("gender");
		InputStream istrm=null;
		Part fp=request.getPart("prescription");
		if(fp!=null) {
			System.out.println(fp.getName());
			System.out.println(fp.getSize());
			System.out.println(fp.getContentType());
			istrm=fp.getInputStream();
		}
		
		Connection con=null;
		String msg=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection(url,unm,pwd);
			String sql="insert into patientdata(pname,address,gender,prescription) values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,pname);
			pst.setString(2,address);
			pst.setString(3,gender);
			
			if(istrm!=null) {
				pst.setBlob(4, istrm);
			}
			
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
