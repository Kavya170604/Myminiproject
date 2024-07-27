package com.cont;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/vsb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "rootroot";
    
    // Load the JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load JDBC driver");
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static List<Patient> getRecords(int start, int total) {
        String sql = "SELECT pname, address, gender, pid FROM patientdata LIMIT ?, ?";
        List<Patient> patients = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, start);
            pst.setInt(2, total);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPname(rs.getString("pname"));
                patient.setAddress(rs.getString("address"));
                patient.setGender(rs.getString("gender"));
                patient.setPid(rs.getInt("pid"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    public static Patient getPatientById(int pid) {
        String sql = "SELECT pname, address, gender FROM patientdata WHERE pid = ?";
        Patient patient = null;

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, pid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                patient = new Patient();
                patient.setPname(rs.getString("pname"));
                patient.setAddress(rs.getString("address"));
                patient.setGender(rs.getString("gender"));
                patient.setPid(pid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }

    public static boolean updatePatient(Patient patient) {
        String sql = "UPDATE patientdata SET pname = ?, address = ?, gender = ? WHERE pid = ?";
        boolean updated = false;

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, patient.getPname());
            pst.setString(2, patient.getAddress());
            pst.setString(3, patient.getGender());
            pst.setInt(4, patient.getPid());

            int rowsAffected = pst.executeUpdate();
            updated = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }
}
