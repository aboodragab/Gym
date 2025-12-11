
package com.gym.dao;

import com.gym.model.Person;
import com.gym.util.DBConnection;
import java.sql.*;

public class PersonDAO {
    public int AddNewPerson(Person p){
        int newID = -1;
        String sql="INSERT INTO person (Name, Phone, Address) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();){
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getPhone());
            stmt.setString(3, p.getAddress());
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    newID = rs.getInt(1); 
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return newID;
    }
    public boolean updatePerson (Person p){
        String sql = "UPDATE Person SET Name = ?, Phone = ?, Address = ? WHERE PersonID = ?";
        try(Connection conn = DBConnection.getConnection();){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,p.getName());
            stmt.setString(2, p.getPhone());
            stmt.setString(3, p.getAddress());
            stmt.setInt(4, p.getPersonId());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        return false;
        }
    }
    public boolean deletePerson(int personId)
    {
        String sql = "DELETE FROM Person WHERE PersonID = ?";
         try(Connection conn = DBConnection.getConnection();){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1,personId);
            return stmt.executeUpdate() > 0;
         }catch(SQLException e){
            e.printStackTrace();
        return false;
        }
    }
}
