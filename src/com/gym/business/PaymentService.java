
package com.gym.business;

import java.util.ArrayList;
import com.gym.dao.PaymentDAO;
import com.gym.model.Payment;
public class PaymentService {
    private PaymentDAO paymentDAO=new PaymentDAO();
     public boolean registerNewPayment(Payment p)
     {
         return paymentDAO.addPayment(p);
     }
     public ArrayList<Payment> getAllPayment()
     {
         return paymentDAO.getAllPayments();
     }
     public boolean removePayments(int paymentID)
     {
         return paymentDAO.deletePayment(paymentID);
     }
     public boolean edit(Payment p)
     {
         return paymentDAO.updatePayment(p);
     }
}
