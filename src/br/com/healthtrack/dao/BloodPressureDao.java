package br.com.healthtrack.dao;

import br.com.healthtrack.database.DatabaseConnection;
import br.com.healthtrack.model.BloodPressure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BloodPressureDao {
    private Connection connection;

    public void create(BloodPressure bloodPressure){
        PreparedStatement pstmt = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO T_HT_PRESSAO(ID_MEDICAO, VL_PRESS_SISTOLICA, VL_PRESS_DIASTOLICA, DS_CLASSIF, DT_MEDICAO, ID_USUARIO) VALUES (null, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, bloodPressure.getSystolic());
            pstmt.setInt(2, bloodPressure.getDiastolic());
            pstmt.setString(3, bloodPressure.getClassification());
            java.sql.Date data = new java.sql.Date(bloodPressure.getDate().getTime());
            pstmt.setDate(4, data);
            pstmt.setInt(5, bloodPressure.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting the blood pressure.");
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error inserting the blood pressure.");
                e.printStackTrace();
            }
        }
    }

    public List<BloodPressure> getAll() {
        List<BloodPressure> bloodPressureList = new ArrayList<BloodPressure>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = DatabaseConnection.getConnection();

            stmt = connection.prepareStatement("SELECT * FROM T_HT_PRESSAO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_MEDICAO");
                int systolic = rs.getInt("VL_PRESS_SISTOLICA");
                int diastolic = rs.getInt("VL_PRESS_DIASTOLICA");
                String classification = rs.getString("DS_CLASSIF");
                Date data = rs.getDate("DT_MEDICAO");
                int userId = rs.getInt("ID_USUARIO");

                BloodPressure bloodPressure = new BloodPressure(id, systolic, diastolic, classification, data, userId);

                bloodPressureList.add(bloodPressure);
            }
        } catch (SQLException e) {
            System.out.println("Error loading the blood pressure.");
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error loading the blood pressure.");
                e.printStackTrace();
            }
        }

        return bloodPressureList;
    }
}
