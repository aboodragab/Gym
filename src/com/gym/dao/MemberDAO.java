
package com.gym.dao;

import com.gym.model.Member;
import com.gym.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    public boolean AddNewMember(Member m)
    {
        String sql="INSERT INTO Member (PersonID, CoachID, StartDate, EndDate) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();){
            PreparedStatement stmt=conn.prepareStatement(sql);
            
            stmt.setInt(1, m.getPersonId());
            stmt.setInt(2,m.getCoachId());
            stmt.setDate(3,m.getStartDate());
            stmt.setDate(4,m.getEndDate());
            
            return stmt.executeUpdate()>0;
        } catch (Exception e) {
             e.printStackTrace();
        }
        return false;
    }
    public boolean updateMember(Member m)
    {
        String sql = "UPDATE Member SET CoachID = ?, StartDate = ?, EndDate = ? WHERE MemberID = ?";
        try (Connection conn=DBConnection.getConnection()) {
            PreparedStatement stmt=conn.prepareStatement(sql);
            
            stmt.setInt(1, m.getCoachId());
            stmt.setDate(2,m.getStartDate());
            stmt.setDate(3,m.getEndDate());
            stmt.setInt(4,m.getMemberId());
            
            return stmt.executeUpdate()>0;
        } catch (Exception e) {
             e.printStackTrace();
        }
        return false;
    }
    public boolean deleteMember(int memberId)
    {
        String sql = "DELETE FROM Member WHERE MemberID = ?";
        try (Connection conn=DBConnection.getConnection()){
            PreparedStatement stmt=conn.prepareStatement(sql);
            
            stmt.setInt(1,memberId);
            return stmt.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> list = new ArrayList<>();
        String sql = "SELECT m.MemberID, m.StartDate, m.EndDate, m.CoachID, " +
                     "p.PersonID, p.Name, p.Phone, p.Address " +
                     "FROM Member m " +
                     "INNER JOIN Person p ON m.PersonID = p.PersonID";
        try (Connection conn=DBConnection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               Member m = new Member(
                rs.getInt("MemberID"),
                rs.getDate("StartDate"),
                rs.getDate("EndDate"),
                rs.getInt("CoachID"),
                rs.getInt("PersonID"),
                rs.getString("Name"),
                rs.getString("Phone"),
                rs.getString("Address")
            );
            list.add(m);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return list;
    }
}
