
package com.gym.dao;
import com.gym.model.Payment;
import com.gym.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
public class PaymentDAO {
    public boolean addPayment(Payment p)
    {
        String sql = "INSERT INTO Payments (MemberID, Amount, PaymentDate) VALUES (?, ?, ?)";
        try (Connection conn=DBConnection.getConnection()){
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1,p.getMemberId());
            stmt.setDouble(2, p.getAmount());
            stmt.setDate(3, p.getPaymentDate());
            
            return stmt.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updatePayment(Payment p)
    {
        String sql = "UPDATE Payments SET Amount = ?, PaymentDate = ? WHERE PaymentID = ?";
        try (Connection conn=DBConnection.getConnection()){
            PreparedStatement stmt=conn.prepareStatement(sql);
            
            stmt.setDouble(1,p.getAmount());
            stmt.setDate(2,p.getPaymentDate());
            stmt.setInt(3,p.getPaymentId());
            
            return stmt.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deletePayment(int paymentId) 
    {
        String sql = "DELETE FROM Payments WHERE PaymentID = ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, paymentId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Payment> getAllPayments() 
    {
           ArrayList<Payment> list = new ArrayList<>();

            String sql = "SELECT pay.PaymentID, pay.Amount, pay.PaymentDate, pay.MemberID, p.Name " +
                         "FROM Payments pay " +
                         "INNER JOIN Member m ON pay.MemberID = m.MemberID " +
                         "INNER JOIN Person p ON m.PersonID = p.PersonID";

            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Payment pay = new Payment(
                        rs.getInt("PaymentID"),
                        rs.getDate("PaymentDate"),
                        rs.getDouble("Amount"),
                        rs.getInt("MemberID")
                    );

                    pay.setMemberName(rs.getString("Name"));
                    list.add(pay);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
    }
    public ArrayList<Payment> searchPaymentsByName(String name) {
        ArrayList<Payment> list = new ArrayList<>();

        String sql = "SELECT pay.PaymentID, pay.Amount, pay.PaymentDate, pay.MemberID, p.Name " +
                     "FROM Payments pay " +
                     "INNER JOIN Member m ON pay.MemberID = m.MemberID " +
                     "INNER JOIN Person p ON m.PersonID = p.PersonID " +
                     "WHERE p.Name LIKE ?";

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Payment pay = new Payment(
                    rs.getInt("PaymentID"),
                    rs.getDate("PaymentDate"),
                    rs.getDouble("Amount"),
                    rs.getInt("MemberID")
                );
                pay.setMemberName(rs.getString("Name"));
                list.add(pay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
}


}
    

