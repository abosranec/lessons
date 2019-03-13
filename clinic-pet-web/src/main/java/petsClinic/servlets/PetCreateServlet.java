package petsClinic.servlets;

import petsClinic.Clinic;
import petsClinic.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PetCreateServlet extends HttpServlet {
    private final Clinic clinic = Clinic.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("clientName", req.getParameter("clientName"));
        req.getRequestDispatcher("/views/PetCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
//            switch (Integer.parseInt(req.getParameter("petType"))){
//                case 0: pet = new Dog(req.getParameter("petName")); break;
//                case 1: pet = new Cat(req.getParameter("petName")); break;
//                case 2: pet = new Hamster(req.getParameter("petName")); break;
//                default: ; break;
//            }
            Pet pet = new Pet(req.getParameter("petName"), req.getParameter("petType"), req.getParameter("petBirthday"));
            clinic.searchClient(req.getParameter("clientName")).addPets(pet);
        } catch (Exception e) {
            e.getMessage();
        }
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/main"));
    }
}
