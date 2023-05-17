package controller;

public class Payment_UpdateServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form parameters
        String paymentId = request.getParameter("paymentId");
        String cardName = request.getParameter("cardName");
        String cardNo = request.getParameter("cardNo");
        String CVC = request.getParameter("CVC");

        // Get session object and database manager
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            // Retrieve payment information
            Payment payment = manager.paymentFindPaymentById(paymentId);
            if (payment != null) {
                // Update payment information
                payment.setCardName(cardName);
                payment.setCardNo(cardNo);
                payment.setCVC(CVC);
                manager.paymentUpdatePayment(payment);
                // Redirect to order confirmation page
                response.sendRedirect("Payment1_OrderCart.jsp");
            } else {
                // Payment information does not exist, return error message
                session.setAttribute("error", "Payment information not found!");
                request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            // Handle database exception
            Logger.getLogger(Payment_UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Failed to update payment information!");
            request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
        }
    }

}
