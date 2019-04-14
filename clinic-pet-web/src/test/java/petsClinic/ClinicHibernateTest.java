package petsClinic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClinicHibernateTest {

    @Test
    public void getClients() {
        Clinic clinic = Clinic.getINSTANCE();
        List<Client> list = clinic.getClients();
        System.out.println(list.size());
        for (Client client: list) {
            System.out.print(client.getId() + ", ");
            System.out.print(client.getName() + ", ");
            System.out.print(client.getSex() + ", ");
            System.out.print(client.getCity() + ", ");
            System.out.print(client.getAddress() + ", ");
            System.out.print(client.getPhone() + ", ");
            System.out.print(client.getMail());
            System.out.println("\n");
        }
    }

    @Test
    public void searchClient() {
        Clinic clinic = Clinic.getINSTANCE();
        try {
            Client client = clinic.searchClient("паша");
            System.out.println(client.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}