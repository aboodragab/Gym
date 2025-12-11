
package com.gym.dao;
import com.gym.model.Coach;
import com.gym.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
public class CoachDAO {
    public boolean AddNewCoach(Coach c)
    {
        String sql = "INSERT INTO Coach (PersonID, ExperienceYears) VALUES (?, ?)";
        try (Connection conn=DBConnection.getConnection()) {
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1, c.getPersonId());
            stmt.setInt(2,c.getExperienceYears());
        } catch (Exception e) {
            e.printStackTrace();
        }
    return false;
    }
    public boolean updateCoach(Coach c)
    {
        String sql = "UPDATE Coach SET ExperienceYears = ? WHERE CoachID = ?";
        try(Connection conn=DBConnection.getConnection()){
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1,c.getExperienceYears());
            stmt.setInt(2,c.getCoachId());
           return stmt.executeUpdate()>0;
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteCoach(int CoachID)
    {
        String sql = "DELETE FROM Coach WHERE CoachID = ?";
        try(Connection conn=DBConnection.getConnection()){
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1, CoachID);
            return stmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Coach> getAllCoachs()
    {
        ArrayList<Coach> list = new ArrayList<>();
        String sql = "SELECT c.CoachID, c.ExperienceYears, " +
             "p.PersonID, p.Name, p.Phone, p.Address " +
             "FROM Coach c " +
             "INNER JOIN Person p ON c.PersonID = p.PersonID";
        try (Connection conn=DBConnection.getConnection()){
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               Coach c=new Coach(rs.getInt("CoachID"),rs.getInt("ExperienceYears")
                       ,rs.getInt("PersonID"),rs.getString("Name"),rs.getString("Phone")
                       ,rs.getString("Address"));
               list.add(c);       
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return list;
    }
}
