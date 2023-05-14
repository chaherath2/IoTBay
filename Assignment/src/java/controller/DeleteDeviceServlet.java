package controller;

import uts.isd.model.dao.DBDeviceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteDeviceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //only staff can delete
        //todo need codes to check

//        if (true) {
//                req.setAttribute("error", "You have no authorisation to delete data!");
//                req.getRequestDispatcher("error.jsp").include(req, resp);
//                return;
//        }

        Long id = Long.valueOf(req.getParameter("id"));
        HttpSession httpSession = req.getSession();
        // database delete
        DBDeviceManager dbDeviceManager = (DBDeviceManager) httpSession.getAttribute("dbDeviceManager");
        try {
            dbDeviceManager.deleteDeviceById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/showDevices");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
