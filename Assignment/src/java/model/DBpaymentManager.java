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
     * Get payment amount and other details from the form and create a payment object associated with the order object and store it in the database.
     * @param order
     * @throws SQLException
     */
    public void orderAddOrder(Order order) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            // Get the inserted order ID
            stmt = conn.prepareStatement("INSERT INTO orders (customer_id, date, status) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, order.getUserID());
            stmt.setDate(2, new java.sql.Date(order.getDate().getTime()));
            stmt.setString(3, order.getStatus().toString());
            stmt.executeUpdate();
            // Get the inserted order ID
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int orderId = rs.getInt(1);
                // Insert payment information
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
                // Insert order item information
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
     * Delete payment information.
     * @param paymentId
     * @throws SQLException
     */
    public void paymentDeletePayment(String paymentId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();      
            // Delete payment information
            stmt = conn.prepareStatement("DELETE FROM payment WHERE payment_id = ?");
            stmt.setString(1, paymentId);
            stmt.executeUpdate();
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    /**
     * Find corresponding payment information by payment ID and return a Payment object.
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
            // Query payment information
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
     * Update a payment object
     * @param payment
     * @throws SQLException
     */
    public void paymentUpdatePayment(Payment payment) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            // Update payment information
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
     * Find corresponding payment information by order ID and return a List<Payment> object.
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
            // Query payment information
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
