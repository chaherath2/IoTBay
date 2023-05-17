package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Order;
import model.Payment;
import uts.isd.model.dao.DBManager;

public class Payment_CreateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form parameters
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        String cardName = request.getParameter("cardName");
        String cardNo = request.getParameter("cardNo");
        String CVC = request.getParameter("CVC");

        // get session and initialise database manager 
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            // create an order object 
            Order order = (Order) session.getAttribute("order");
            if (order != null) {
                // insert the required information that the order needs
                Payment payment = new Payment();
                payment.setCardName(cardName);
                payment.setCardNo(cardNo);
                payment.setCVC(CVC);
                payment.setAmount(amount);
                payment.setDate(new Date());
                // link the order with the payment
                order.setPayment(payment);
                // add the order into the database
                manager.orderAddOrder(order);
                // send back to the jsp webpage
                response.sendRedirect("Payment1_OrderCart.jsp");
            } else {
                // display an error if the order fails
                session.setAttribute("error", "Order information not found!");
                request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            // Handle database exceptions
            Logger.getLogger(Payment_CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Failed to create payment information!");
            request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
        }
    }
}
