package controller;

public class Payment_DeleteServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取表单参数
        String paymentId = request.getParameter("paymentId");

        // 获取会话对象和数据库管理器
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            // 查询支付信息
            Payment payment = manager.paymentFindPaymentById(paymentId);
            if (payment != null) {
                // 删除支付信息
                manager.paymentDeletePayment(paymentId);
                // 跳转到订单确认页面
                response.sendRedirect("Payment1_OrderCart.jsp");
            } else {
                // 支付信息不存在，返回错误消息
                session.setAttribute("error", "Payment information not found!");
                request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            // 处理数据库异常
            Logger.getLogger(Payment_DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Failed to delete payment information!");
            request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
        }
    }
}
}
