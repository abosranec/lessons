package petsClinic.servlets;

import petsClinic.Client;
import petsClinic.Clinic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientEditServlet extends HttpServlet {
    private final Clinic clinic = Clinic.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("oldClientName", req.getParameter("clientName"));
        req.getRequestDispatcher("/views/ClientEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            //customer data
            Client client = new Client(req.getParameter("name"));

            clinic.editClientName(req.getParameter("oldClientName"), client);
        } catch (Exception e) {
            e.getMessage();
        }
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/"));
    }
}
