package petsClinic.servlets;

import petsClinic.Client;
import petsClinic.Clinic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientDeleteServlet extends HttpServlet {
    private final Clinic clinic = Clinic.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            clinic.removeClient(req.getParameter("clientName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
