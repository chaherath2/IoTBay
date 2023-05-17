package controller;

public class Payment_DeleteServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form parameter
        String paymentId = request.getParameter("paymentId");

     // Get session object and database manager
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
          
            // Retrieve payment information
            Payment payment = manager.paymentFindPaymentById(paymentId);
            if (payment != null) {
                // Delete payment information
                manager.paymentDeletePayment(paymentId);
                // Redirect to order confirmation page
                response.sendRedirect("Payment1_OrderCart.jsp");
            } else {
                // Payment information does not exist, return error message
                session.setAttribute("error", "Payment information not found!");
                request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
             // Handle database exception
            Logger.getLogger(Payment_DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Failed to delete payment information!");
            request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
        }
    }
}
}
