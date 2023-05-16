package uts.isd.model.dao;

import model.Order;
import model.Payment;

import java.sql.*;
import java.util.List;

import static jdk.internal.net.http.HttpConnection.getConnection;

public class DBpaymentManager {
    private Connection conn;

    public DBpaymentManager(Connection conn) throws SQLException {
        this.conn = conn;
    }

    /**
     * 从表单中获取支付金额等并从绘画中获取订单对西那个创建一个支付对象并将他与订单对象关联存储至数据库
     * @param order
     * @throws SQLException
     */
    public void orderAddOrder(Order order) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            // 插入订单信息
            stmt = conn.prepareStatement("INSERT INTO orders (customer_id, date, status) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, order.getUserID());
            stmt.setDate(2, new java.sql.Date(order.getDate().getTime()));
            stmt.setString(3, order.getStatus().toString());
            stmt.executeUpdate();
            // 获取插入的订单 ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int orderId = rs.getInt(1);
                // 插入支付信息
                Payment payment = order.getPayment();
                if (payment != null) {
                    stmt = conn.prepareStatement("INSERT INTO payment (order_id, card_name, card_no, CVC, amount, date) VALUES (?, ?, ?, ?, ?, ?)");
                    stmt.setInt(1, orderId);
                    stmt.setString(2, payment.getCardName());
                    stmt.setString(3, payment.getCardNo());
                    stmt.setString(4, payment.getCVC());
                    stmt.setBigDecimal(5, payment.getAmount());
                    stmt.setDate(6, new java.sql.Date(payment.getDate().getTime()));
                    stmt.executeUpdate();
                }
                // 插入订单项信息
                List<OrderItem> itemList = order.getItemList();
                if (itemList != null) {
                    stmt = conn.prepareStatement("INSERT INTO order_item (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)");
                    for (OrderItem item : itemList) {
                        stmt.setInt(1, orderId);
                        stmt.setInt(2, item.getProduct().getProductId());
                        stmt.setInt(3, item.getQuantity());
                        stmt.setBigDecimal(4, item.getPrice());
                        stmt.executeUpdate();
                    }
                }
            }
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    /**
     * 删除订单信息
     * @param paymentId
     * @throws SQLException
     */
    public void paymentDeletePayment(String paymentId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            // 删除支付信息
            stmt = conn.prepareStatement("DELETE FROM payment WHERE payment_id = ?");
            stmt.setString(1, paymentId);
            stmt.executeUpdate();
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    /**
     * 查询对应支付信息并返回payment对象
     * @param paymentId
     * @return
     * @throws SQLException
     */
    public Payment paymentFindPaymentById(String paymentId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Payment payment = null;
        try {
            conn = getConnection();
            // 查询支付信息
            stmt = conn.prepareStatement("SELECT * FROM payment WHERE payment_id = ?");
            stmt.setString(1, paymentId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                payment = new Payment();
                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setCardName(rs.getString("card_name"));
                payment.setCardNo(rs.getString("card_no"));
                payment.setCVC(rs.getString("CVC"));
                payment.setAmount(rs.getBigDecimal("amount"));
                payment.setDate(rs.getDate("date"));
            }
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }
        return payment;
    }

    /**
     * 更新支付对象
     * @param payment
     * @throws SQLException
     */
    public void paymentUpdatePayment(Payment payment) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            // 更新支付信息
            stmt = conn.prepareStatement("UPDATE payment SET card_name = ?, card_no = ?, CVC = ?, amount = ?, date = ? WHERE payment_id = ?");
            stmt.setString(1, payment.getCardName());
            stmt.setString(2, payment.getCardNo());
            stmt.setString(3, payment.getCVC());
            stmt.setBigDecimal(4, payment.getAmount());
            stmt.setDate(5, new java.sql.Date(payment.getDate().getTime()));
            stmt.setInt(6, payment.getPaymentId());
            stmt.executeUpdate();
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    /**
     * 通过订单id查询对应支付信息并返回List<payment>对象
     * @param orderId
     * @return
     * @throws SQLException
     */
    public List<Payment> paymentFindPaymentsByOrderId(int orderId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Payment> paymentList = new ArrayList<>();
        try {
            conn = getConnection();
            // 查询支付信息
            stmt = conn.prepareStatement("SELECT * FROM payment WHERE order_id = ?");
            stmt.setInt(1, orderId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setCardName(rs.getString("card_name"));
                payment.setCardNo(rs.getString("card_no"));
                payment.setCVC(rs.getString("CVC"));
                payment.setAmount(rs.getBigDecimal("amount"));
                payment.setDate(rs.getDate("date"));
                paymentList.add(payment);
            }
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }
        return paymentList;
    }

}
