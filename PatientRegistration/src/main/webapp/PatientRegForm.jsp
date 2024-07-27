<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Registration Form</title>
    <style>
        body {
            background: #e0f7fa; /* Light cyan background for a fresh look */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .form-card {
            width: 100%;
            max-width: 600px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            box-sizing: border-box;
        }
        .form-card h2 {
            margin-top: 0;
            color: #00796b; /* Teal color for headings */
        }
        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }
        .form-group label {
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input[type="text"],
        .form-group input[type="date"],
        .form-group input[type="file"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-group input[type="radio"] {
            margin-right: 10px;
        }
        .form-group .radio-group {
            display: flex;
            align-items: center;
        }
        .form-group .radio-group label {
            margin-right: 20px;
            font-weight: normal;
        }
        .form-group button {
            background-color: #00796b;
            color: #ffffff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        .form-group button:hover {
            background-color: #004d40;
        }
    </style>
</head>
<body>
    <div class="form-card">
        <h2>Patient Registration Form</h2>
        <form action="PatientController" enctype="multipart/form-data" method="post">
            <!-- Basic Information Section -->
            <div class="form-group">
                <label for="pname">Patient Name:</label>
                <input type="text" id="pname" name="pname" required>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
            </div>
            <div class="form-group">
                <label>Gender:</label>
                <div class="radio-group">
                    <label><input type="radio" name="gender" value="Male" required> Male</label>
                    <label><input type="radio" name="gender" value="Female" required> Female</label>
                    <label><input type="radio" name="gender" value="Other" required> Other</label>
                </div>
            </div>
            <div class="form-group">
                <label for="prescription">Prescription:</label>
                <input type="file" id="prescription" name="prescription">
            </div>
            <hr>
            <!-- Appointment Information Section -->
            <div class="form-group">
                <label for="appointmentDate">Required Appointment Date:</label>
                <input type="date" id="appointmentDate" name="appointmentDate" required>
            </div>
            <div class="form-group">
                <button type="submit">Register</button>
            </div>
        </form>
    </div>
</body>
</html>
