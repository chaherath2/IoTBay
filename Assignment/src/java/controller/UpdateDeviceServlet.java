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

public class UpdateDeviceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //only staff can update
        //todo need codes to check

//        if (true) {
//                req.setAttribute("error", "You have no authorisation to update data!");
//                req.getRequestDispatcher("error.jsp").include(req, resp);
//                return;
//        }



        Device device = new Device();
        HttpSession session = req.getSession();
        device.setId(Long.valueOf(req.getParameter("id")));
        device.setDeviceName(req.getParameter("deviceName"));
        device.setDeviceDescription(req.getParameter("deviceDescription"));
        device.setPrice(Double.valueOf(req.getParameter("price")));
        device.setStock(Integer.parseInt(req.getParameter("stock")));
        device.setType(Integer.parseInt(req.getParameter("type")));
        device.setUTime(System.currentTimeMillis());
        //todo update
        DBDeviceManager deviceManager = (DBDeviceManager) session.getAttribute("dbDeviceManager");
        try {
            deviceManager.updateDevice(device);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/showDevices");
    }
}
