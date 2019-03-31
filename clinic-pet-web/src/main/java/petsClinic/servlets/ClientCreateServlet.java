package petsClinic.servlets;

import petsClinic.Client;
import petsClinic.Clinic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientCreateServlet extends HttpServlet {
    private final Clinic clinic = Clinic.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            //customer data
            Client client = new Client(req.getParameter("clientName"));
            client.setSex(req.getParameter("clientSex"));
            client.setCity(req.getParameter("clientCity"));
            client.setAddress(req.getParameter("clientAddress"));
            client.setPhone(req.getParameter("clientPhone"));
            client.setMail(req.getParameter("clientMail"));

            clinic.addClient(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/main"));
    }
}
