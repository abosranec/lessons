package petsClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import petsClinic.Client;
import petsClinic.Clinic;
import petsClinic.Pet;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class AdminController {

    private Clinic clinic = Clinic.getINSTANCE();

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String clientView(ModelMap model) {
        model.addAttribute("clients", clinic.getClients());
        return "ClientView";
    }

    @RequestMapping(value = "/client/create", method = RequestMethod.POST)
    public String clientCreate(HttpServletRequest req, ModelMap model) {
        try {
            req.setCharacterEncoding("UTF-8");
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
        return "redirect:/main";
    }

    @RequestMapping(value = "/client/edit", method = RequestMethod.GET)
    public String clientEditGet(HttpServletRequest req, ModelMap model) {
        try {
            req.setAttribute("oldClient", clinic.searchClient(req.getParameter("clientName")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ClientEdit";
    }
    @RequestMapping(value = "/client/edit", method = RequestMethod.POST)
    public String clientEditPost(HttpServletRequest req, ModelMap model) {
        try {
            req.setCharacterEncoding("UTF-8");
            Client client = new Client(req.getParameter("oldClientName"));
            client.editClient(clinic.searchClient(req.getParameter("oldClientName")));
            client.setName(req.getParameter("clientName"));
            client.setSex(req.getParameter("clientSex"));
            client.setCity(req.getParameter("clientCity"));
            client.setAddress(req.getParameter("clientAddress"));
            client.setPhone(req.getParameter("clientPhone"));
            client.setMail(req.getParameter("clientMail"));
            clinic.editClientName(req.getParameter("oldClientName"), client);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/client/delete", method = RequestMethod.GET)
    public String clientDelete(HttpServletRequest req, ModelMap model) {
        try {
            clinic.removeClient(req.getParameter("clientName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/pet/create", method = RequestMethod.GET)
    public String petCreateGet(HttpServletRequest req, ModelMap model) {
        model.addAttribute("clientName", req.getParameter("clientName"));
        return "PetCreate";
    }
    @RequestMapping(value = "/pet/create", method = RequestMethod.POST)
    public String petCreatePost(HttpServletRequest req, ModelMap model) {
        try {
            req.setCharacterEncoding("UTF-8");
            Pet pet = new Pet(req.getParameter("petName"), req.getParameter("petType"), req.getParameter("petBirthday"));
            clinic.searchClient(req.getParameter("clientName")).addPets(pet);
        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/pet/delete", method = RequestMethod.GET)
    public String petDelete(HttpServletRequest req, ModelMap model) {
        try {
            clinic.searchClient(req.getParameter("clientName")).removePet(req.getParameter("petName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/pet/edit", method = RequestMethod.GET)
    public String petEditGet(HttpServletRequest req, ModelMap model) {
        try {
            req.setAttribute("clientName", req.getParameter("clientName"));
            req.setAttribute("pet", clinic.searchClient(req.getParameter("clientName")).searchPets(req.getParameter("petName")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PetEdit";
    }
    @RequestMapping(value = "/pet/edit", method = RequestMethod.POST)
    public String petEditPost(HttpServletRequest req, ModelMap model) {
        try {
            req.setCharacterEncoding("UTF-8");
            Pet pet = new Pet(req.getParameter("name"), req.getParameter("type"), req.getParameter("birthday"));
            clinic.searchClient(req.getParameter("clientName")).editPetName(req.getParameter("oldPetName"), pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/main";
    }

}
