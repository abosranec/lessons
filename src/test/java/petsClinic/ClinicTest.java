package petsClinic;

import org.junit.Test;
import petsClinic.pets.Cat;
import petsClinic.pets.Dog;
import petsClinic.pets.Hamster;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ClinicTest {
    Clinic clinic = new Clinic(
            new Client("Jon", new Cat("barsik")),
            new Client("Billy", new Dog("doggy"), new Hamster("ham")),
            new Client("Jack", new Dog("pyshok"))
    );

    @Test
    public void editClientName() {
        System.out.println(clinic);
        String oldName = "Billy";
        String newName = "Bill";
        try {
            clinic.editClientName(oldName, newName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(clinic);
    }

    @Test
    public void editClientPetName() {
        System.out.println(clinic);
        String client = "Billy";
        String oldName = "hamas";
        String newName = "bla";
        try {
            clinic.editClientPetName(client, oldName, newName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(clinic);
    }
}