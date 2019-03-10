package petsClinic.servlets;

import petsClinic.Client;
import petsClinic.Clinic;
import petsClinic.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PetEditServlet extends HttpServlet {
    private final Clinic clinic = Clinic.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("clientName", req.getParameter("clientName"));
        try {
            req.setAttribute("pet", clinic.searchClient(req.getParameter("clientName")).searchPets(req.getParameter("petName")));
        } catch (Exception e) {
            e.getMessage();
        }
        req.getRequestDispatcher("/views/PetEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            //pet data
            Pet pet = new Pet(req.getParameter("name"), req.getParameter("type"), req.getParameter("birthday"));

            clinic.searchClient(req.getParameter("clientName")).editPetName(req.getParameter("oldPetName"), pet);
        } catch (Exception e) {
            e.getMessage();
        }
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/"));
    }
}
