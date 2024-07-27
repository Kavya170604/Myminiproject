<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cont.Patient" %>
<%@ page import="com.cont.PatientDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Patient</title>
<style>
body {
  /* replace with your hospital image */
  background-size: cover;
  background-position: center;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.container {
  width: 40%;
  margin: 0 auto;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
form {
  display: flex;
  flex-direction: column;
}
input, select {
  margin-bottom: 10px;
}
</style>
</head>
<body>
<div class="container">
<%
String pid = request.getParameter("pid");
Patient patient = PatientDao.getPatientById(Integer.parseInt(pid));

if (patient != null) {
%>
<form action="UpdatePatient.jsp" method="post">
    <input type="hidden" name="pid" value="<%= patient.getPid() %>">
    <label for="pname">Patient Name:</label>
    <input type="text" id="pname" name="pname" value="<%= patient.getPname() %>" required>

    <label for="address">Patient Address:</label>
    <input type="text" id="address" name="address" value="<%= patient.getAddress() %>" required>

    <label for="gender">Patient Gender:</label>
    <select id="gender" name="gender" required>
        <option value="Male" <%= patient.getGender().equals("Male") ? "selected" : "" %>>Male</option>
        <option value="Female" <%= patient.getGender().equals("Female") ? "selected" : "" %>>Female</option>
        <option value="Other" <%= patient.getGender().equals("Other") ? "selected" : "" %>>Other</option>
    </select>

    <button type="submit">Update</button>
</form>
<%
} else {
    out.println("<p>Patient not found.</p>");
}
%>
</div>
</body>
</html>