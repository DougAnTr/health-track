package br.com.healthtrack.dao;

import br.com.healthtrack.database.DatabaseConnection;
import br.com.healthtrack.model.Activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityDao {
    private Connection connection;

    public void create(Activity activity){
        PreparedStatement pstmt = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO T_HT_ATIVIDADE(ID_ATIVIDADE, DS_ATIVIDADE, HR_DURACAO, DT_ATIVIDADE, ID_USUARIO) VALUES (NULL, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, activity.getDescription());
            pstmt.setInt(2, activity.getTime());
            java.sql.Date data = new java.sql.Date(activity.getDate().getTime());
            pstmt.setDate(3, data);
            pstmt.setInt(4, activity.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting the activity.");
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error inserting the activity.");
                e.printStackTrace();
            }
        }
    }

    public List<Activity> getAll() {
        List<Activity> activities = new ArrayList<Activity>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();

            stmt = connection.prepareStatement("SELECT * FROM T_HT_ATIVIDADE");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID_ATIVIDADE");
                String description = rs.getString("DS_ATIVIDADE");
                int time = rs.getInt("HR_DURACAO");
                Date date = rs.getDate("DT_ATIVIDADE");
                int userId = rs.getInt("ID_USUARIO");

                Activity activity = new Activity(id, description, time, userId, date);
                activities.add(activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return activities;
    }
}
