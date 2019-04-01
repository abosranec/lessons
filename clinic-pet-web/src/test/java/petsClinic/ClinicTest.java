package petsClinic;

import org.junit.Test;

import java.util.ArrayList;

public class ClinicTest {

    private Clinic clinic = Clinic.getINSTANCE();

    public ClinicTest() {
        System.out.println("ClinicTest()");
        try {
            clinic.addClient(new Client("Jon"));
            clinic.searchClient("Jon").addPets(new Pet("barsik", "Cat"));

            clinic.addClient(new Client("Billy"));
            clinic.searchClient("Billy").addPets(new Pet("doggy", "Dog"));
            clinic.searchClient("Billy").addPets(new Pet("ham", "Hamster"));

            clinic.addClient(new Client("Jack"));
            clinic.searchClient("Jack").addPets(new Pet("pyshok", "Dog"));
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
            clinic.addClient(new Client("Garry"));
            clinic.searchClient("Garry").addPets(new Pet("fluffy", "Cat"));
            System.out.println(clinic);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void removeClient() {
        try {
            clinic.removeClient("Jon");
            ArrayList<Client> arrayList = new ArrayList<>(clinic.getClients());
            Client client = new Client("pasha");
            arrayList.add(client);
            System.out.println(arrayList);

            System.out.println(arrayList.remove(client));
            System.out.println(arrayList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(clinic);
    }
}