package petsClinic;

import org.junit.Test;
import petsClinic.pets.Cat;
import petsClinic.pets.Dog;
import petsClinic.pets.Hamster;
import petsClinic.pets.Pet;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ClinicTest {

    private Clinic clinic = new Clinic();

    public ClinicTest() {
        System.out.println("ClinicTest()");
        try {
            clinic.addClients(
                    new Client("Jon", new Cat("barsik")),
                    new Client("Billy", new Dog("doggy"), new Hamster("ham")),
                    new Client("Jack", new Dog("pyshok"))
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(clinic);
    }

    @Test
    public void editClientName() {
        System.out.println("editClientName()");
        try {
            clinic.editClientName("Billy", new Client("Jack"));
            System.out.println(clinic);
//            clinic.editClientName("Billy", "Garry");
//            System.out.println(clinic);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(clinic);
    }

    @Test
    public void editClientPetName() {
        System.out.println("editClientPetName()");
        try {
            Pet pet = new Dog("doggy");
            clinic.searchClient("Billy").editPetName( "ham", pet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(clinic);
    }

    @Test
    public void addPets() {
        System.out.println("addPets()");
        try {
            clinic.searchClient("Billy").addPets(new Dog("dogg"));
            System.out.println(clinic);
            clinic.searchClient("Billy").addPets(new Dog("doggy"));
            System.out.println(clinic);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n" + clinic);
    }

    @Test
    public void addClients() {
        System.out.println("addClients()");
        try {
//            clinic.addClients(new Client("Jon", new Cat("barsik")));
//            System.out.println(clinic);
            clinic.addClients(new Client("Garry", new Cat("fluffy")));
            System.out.println(clinic);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}