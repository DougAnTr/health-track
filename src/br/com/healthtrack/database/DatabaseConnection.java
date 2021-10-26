package br.com.healthtrack.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM86617", "300695");
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error connecting the database.");
            e.printStackTrace();
        }

        return connection;
    }
}
