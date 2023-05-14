package controller;

import model.Device;
import uts.isd.model.dao.DBDeviceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SelectAllDevicesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DBDeviceManager dbDeviceManager = (DBDeviceManager) session.getAttribute("dbDeviceManager");
        List<Device> devices = null;
        try {
            devices = dbDeviceManager.selectAllDevices();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("devices", devices);
        req.getRequestDispatcher("device.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
