package controller;

import IoTBay.model.dao.DBManager;
import IoTBay.mvp.model.Payment;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Payment_ViewServlet {
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // Get order ID
    Integer orderId = Integer.parseInt(request.getParameter("orderId"));

    
    // Get session object and database manager
    HttpSession session = request.getSession();
    DBManager manager = (DBManager) session.getAttribute("manager");

    try {

        // Retrieve payment information
        List<Payment> paymentList = manager.paymentFindPaymentsByOrderId(orderId);
       // Store payment information in the session
        session.setAttribute("paymentList", paymentList);
      // Redirect to payment information page
        request.getRequestDispatcher("Payment_View.jsp").forward(request, response);
    } catch (SQLException ex) {
        // Handle database exception
        Logger.getLogger(Payment_ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        session.setAttribute("error", "Failed to retrieve payment information!");
        request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
    }
}
}
