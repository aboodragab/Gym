
package com.gym.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    private static final String URL ="jdbc:derby://localhost:1527/gym";
    private static final String USER = "gym";
    private static final String PASSWORD = "gym";
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