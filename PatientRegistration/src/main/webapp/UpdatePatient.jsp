<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cont.Patient" %>
<%@ page import="com.cont.PatientDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Patient</title>
</head>
<body>
<%
String pid = request.getParameter("pid");
String pname = request.getParameter("pname");
String address = request.getParameter("address");
String gender = request.getParameter("gender");

Patient patient = new Patient();
patient.setPid(Integer.parseInt(pid));
patient.setPname(pname);
patient.setAddress(address);
patient.setGender(gender);

boolean success = PatientDao.updatePatient(patient);

if (success) {
    out.println("<p>Patient updated successfully.</p>");
    out.println("<a href='View.jsp?page=1'>Go to Patient List</a>");
} else {
    out.println("<p>Failed to update patient.</p>");
    out.println("<a href='EditPatient.jsp?pid=" + pid + "'>Try Again</a>");
}
%>
</body>
</html>
