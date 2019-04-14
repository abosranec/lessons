package petsClinic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientHibernateTest {

    @Test
    public void getPets() {
        Clinic clinic = Clinic.getINSTANCE();
        List<Client> list = clinic.getClients();
        for (Client client: list){
            List<Pet> listPets = client.getPets();
            System.out.println("\t" + client.getName());
            for (Pet pet: listPets){
                if (pet != null) {
                    System.out.println(pet.getName() + "; " + pet.getType() + "; " + pet.getId());
                } else {
                    System.out.println("null");
                }

            }
        }
    }
}