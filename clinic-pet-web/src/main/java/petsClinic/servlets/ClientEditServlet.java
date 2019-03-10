package petsClinic.servlets;

import petsClinic.Client;
import petsClinic.Clinic;
import petsClinic.Pet;

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
//        req.setAttribute("oldClientName", req.getParameter("clientName"));
        try {
            req.setAttribute("oldClient", clinic.searchClient(req.getParameter("clientName")));
        } catch (Exception e) {
            e.getMessage();
        }
        req.getRequestDispatcher("/views/ClientEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            Client client = new Client(req.getParameter("oldClientName"));
            client.editClient(clinic.searchClient(req.getParameter("oldClientName")));
            //customer data
            client.setName(req.getParameter("clientName"));
            client.setSex(req.getParameter("clientSex"));
            client.setCity(req.getParameter("clientCity"));
            client.setAddress(req.getParameter("clientAddress"));
            client.setPhone(req.getParameter("clientPhone"));
            client.setMail(req.getParameter("clientMail"));

            clinic.editClientName(req.getParameter("oldClientName"), client);
        } catch (Exception e) {
            e.getMessage();
        }
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/"));
    }
}
