package controller;

import java.io.IOException;
import java.math.BigDecimal;

public class Payment_CreateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取表单参数
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        String cardName = request.getParameter("cardName");
        String cardNo = request.getParameter("cardNo");
        String CVC = request.getParameter("CVC");

        // 获取会话对象和数据库管理器
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            // 获取订单对象
            Order order = (Order) session.getAttribute("order");
            if (order != null) {
                // 创建支付对象
                Payment payment = new Payment();
                payment.setCardName(cardName);
                payment.setCardNo(cardNo);
                payment.setCVC(CVC);
                payment.setAmount(amount);
                payment.setDate(new Date());
                // 将支付对象与订单对象关联起来
                order.setPayment(payment);
                // 将订单对象存储到数据库中
                manager.orderAddOrder(order);
                // 跳转到订单确认页面
                response.sendRedirect("Payment1_OrderCart.jsp");
            } else {
                // 订单对象不存在，返回错误消息
                session.setAttribute("error", "Order information not found!");
                request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            // 处理数据库异常
            Logger.getLogger(Payment_CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Failed to create payment information!");
            request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
        }
    }
}