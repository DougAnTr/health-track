package br.com.healthtrack.dao;

import br.com.healthtrack.database.DatabaseConnection;
import br.com.healthtrack.model.BloodPressure;
import br.com.healthtrack.model.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FoodDao {
    private Connection connection;

    public void create(Food food){
        PreparedStatement pstmt = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO T_HT_ALIMENTO(ID_ALIMENTO, DS_ALIMENTO, QT_CALORIA, ID_USUARIO, DT_CONSUMO) VALUES (null, ?, ?, ?, ?)";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, food.getDescription());
            pstmt.setDouble(2, food.getCalories());
            pstmt.setInt(3, food.getUserId());
            java.sql.Date data = new java.sql.Date(food.getDate().getTime());
            pstmt.setDate(4, data);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting the food.");
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error inserting the food.");
                e.printStackTrace();
            }
        }
    }

    public List<Food> getAll() {
        List<Food> foods = new ArrayList<Food>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = DatabaseConnection.getConnection();

            stmt = connection.prepareStatement("SELECT * FROM T_HT_ALIMENTO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_ALIMENTO");
                String description = rs.getString("DS_ALIMENTO");
                int calories = rs.getInt("QT_CALORIA");
                int userId = rs.getInt("ID_USUARIO");
                Date date = rs.getDate("DT_CONSUMO");

                Food food = new Food(id, description, calories, date, userId);

                foods.add(food);
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

        return foods;
    }
}