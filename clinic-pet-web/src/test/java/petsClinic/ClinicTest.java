package petsClinic;

import org.junit.Test;

public class ClinicTest {

    private Clinic clinic = new Clinic();

    public ClinicTest() {
        System.out.println("ClinicTest()");
        try {
            clinic.addClients(
                    new Client("Jon", new Pet("barsik", "Cat")),
                    new Client("Billy", new Pet("doggy", "Dog"), new Pet("ham", "Hamster")),
                    new Client("Jack", new Pet("pyshok", "Dog"))
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
            Pet pet = new Pet("doggy", "Dog");
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
            clinic.searchClient("Billy").addPets(new Pet("dogg", "Dog"));
            System.out.println(clinic);
            clinic.searchClient("Billy").addPets(new Pet("doggy", "Dog"));
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
            clinic.addClients(new Client("Garry", new Pet("fluffy", "Cat")));
            System.out.println(clinic);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}