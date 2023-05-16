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

    // 获取订单 ID
    Integer orderId = Integer.parseInt(request.getParameter("orderId"));

    // 获取会话对象和数据库管理器
    HttpSession session = request.getSession();
    DBManager manager = (DBManager) session.getAttribute("manager");

    try {
        // 查询支付信息
        List<Payment> paymentList = manager.paymentFindPaymentsByOrderId(orderId);
        // 将支付信息存储到会话中
        session.setAttribute("paymentList", paymentList);
        // 跳转到支付信息页面
        request.getRequestDispatcher("Payment_View.jsp").forward(request, response);
    } catch (SQLException ex) {
        // 处理数据库异常
        Logger.getLogger(Payment_ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        session.setAttribute("error", "Failed to retrieve payment information!");
        request.getRequestDispatcher("Payment_Error.jsp").forward(request, response);
    }
}
}