package petsClinic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientJDBCTest {

    @Test
    public void getPets(){
        System.out.println("getPets");
        Clinic clinic = Clinic.getINSTANCE();
        List<Client> clients = clinic.getClients();
        for (Client client: clients){
            System.out.println(client.getName());
            for (Pet pet: client.getPets()){
                System.out.println(pet.getName());
            }
        }
    }
}