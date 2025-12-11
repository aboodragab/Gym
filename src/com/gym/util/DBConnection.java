
package com.gym.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gymdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Aa0787014769";
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (ClassNotFoundException | SQLException e)
        {
         JOptionPane.showMessageDialog(null, "Database connection failed" + e.getMessage());
            e.printStackTrace();   
        }
     return con;
}
}