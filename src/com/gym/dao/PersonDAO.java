package com.gym.dao;

import com.gym.model.Person;
import com.gym.util.DBConnection;
import java.sql.*;

public class PersonDAO {

    public int AddNewPerson(Person p) {
        String sql = "INSERT INTO Person (Name, Phone, Address, Age) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getPhone());
            stmt.setString(3, p.getAddress());
            stmt.setInt(4, p.getAge()); 
            
            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean updatePerson(Person p) {
        String sql = "UPDATE Person SET Name = ?, Phone = ?, Address = ?, Age = ? WHERE PersonID = ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getPhone());
            stmt.setString(3, p.getAddress());
            stmt.setInt(4, p.getAge());
            stmt.setInt(5, p.getPersonId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePerson(int personId) {
        String sql = "DELETE FROM Person WHERE PersonID = ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, personId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}