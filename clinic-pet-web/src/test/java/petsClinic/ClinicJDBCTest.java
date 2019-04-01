package petsClinic;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ClinicJDBCTest {

    @Test
    public void getClients() {
        Clinic clinic = Clinic.getINSTANCE();
        ArrayList<Client> arrayList = new ArrayList<>(clinic.getClients());
        for (Client client : arrayList) {
            System.out.print(client.getName() + " ");
            System.out.print(client.getSex() + " ");
            System.out.print(client.getCity() + " ");
            System.out.print(client.getAddress() + " ");
            System.out.print(client.getPhone() + " ");
            System.out.print(client.getMail() + " ");
            System.out.println("\n");
        }
    }
}