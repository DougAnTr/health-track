package br.com.healthtrack.dao;

import br.com.healthtrack.database.DatabaseConnection;
import br.com.healthtrack.model.Food;
import br.com.healthtrack.model.Weight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeightDao {
    private Connection connection;

    public void create(Weight weight){
        PreparedStatement pstmt = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO T_HT_PESO(ID_PESO, VL_PESO, ID_USUARIO, DT_PESO) VALUES (null, ?, ?, ?)";

            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, weight.getWeight());
            pstmt.setInt(2, weight.getUserId());
            java.sql.Date data = new java.sql.Date(weight.getDate().getTime());
            pstmt.setDate(3, data);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting the weight.");
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error inserting the weight.");
                e.printStackTrace();
            }
        }
    }

    public List<Weight> getAll() {
        List<Weight> weights = new ArrayList<Weight>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = DatabaseConnection.getConnection();

            stmt = connection.prepareStatement("SELECT * FROM T_HT_PESO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_PESO");
                Double weightValue = rs.getDouble("VL_PESO");
                int userId = rs.getInt("ID_USUARIO");
                Date date = rs.getDate("DT_PESO");

                Weight weight = new Weight(id, weightValue, userId, date);

                weights.add(weight);
            }
        } catch (SQLException e) {
            System.out.println("Error loading the foods.");
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error loading the foods.");
                e.printStackTrace();
            }
        }

        return weights;
    }
}
