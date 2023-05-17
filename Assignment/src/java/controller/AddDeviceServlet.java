package controller;




import dao.DBDeviceManager;
import model.Device;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddDeviceServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //only staff can add
        //todo need codes to check

//        if (true) {
//                req.setAttribute("error", "You have no authorisation to add data!");
//                req.getRequestDispatcher("error.jsp").include(req, resp);
//                return;
//        }

        HttpSession session = req.getSession();
        try {
            DBDeviceManager deviceManager = (DBDeviceManager) session.getAttribute("dbDeviceManager");
            Device device = new Device();
            device.setDeviceId(UUID.randomUUID().toString());
            device.setDeviceName(req.getParameter("deviceName"));
            device.setDeviceDescription(req.getParameter("deviceDescription"));
            device.setStock(Integer.parseInt(req.getParameter("stock")));
            device.setType(Integer.parseInt(req.getParameter("type")));
            device.setCTime(System.currentTimeMillis());
            device.setUTime(System.currentTimeMillis());
            device.setAvailable(true);
            device.setPrice(Double.valueOf(req.getParameter("price")));
            deviceManager.addDevice(device);
            resp.sendRedirect(req.getContextPath() + "/showDevices");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
