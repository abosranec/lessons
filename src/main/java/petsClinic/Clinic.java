package petsClinic;

import petsClinic.pets.*;

import java.util.*;

public class Clinic{
    private ArrayList<Client> clients = new ArrayList<Client>();

    public Clinic() {
    }

    public Clinic(Client... clients) {
        addClients(clients);
    }

    public int getNumberOfClients(){
        return clients.size();
    }

    public int getNumberOfPetsAll(){
        int size = 0;
        for (Client client: clients) {
            size+= client.getNumberOfPets();
        }
        return size;
    }

    public void addClients(Client... clients) {
        this.clients.addAll(Arrays.asList(clients));
    }

    public void removeClient(String name) throws Exception {
        this.clients.remove(searchClient(name));
    }

    public void removeClientAll(){
        this.clients.clear();
    }

    public void addPet(String clientName, Pet... pets) throws Exception {
        searchClient(clientName).addPets(pets);
    }

    public void removePet(String clientName, String pet) throws Exception{
        searchClient(clientName).removePet(pet);
    }

    public void editClientName(String oldName, String newName) throws Exception {
        searchClient(oldName).setName(newName);
    }

    public void editClientPetName(String client, String oldName, String newName) throws Exception{
        searchClient(client).editPetName(oldName, newName);
    }

    public List<String> seachClientsName(String pet){
        List<String> list = new LinkedList<String>();
        for (Client client: clients) {
            if(client.isPetName(pet)){
                list.add(client.getName());
            }
        }
        return list;
    }

    public List<String> seachClientPets(String client) throws Exception {
        return searchClient(client).getPets();
    }

    private Client searchClient(String name) throws Exception {
        for (Client client: clients) {
            if(name.equals(client.getName())){
                return client;
            }
        }
        throw new Exception("Operation failed, client name \"" + name + "\" doesn't exist!");
    }

    @Override
    public String toString() {
        String string = "All clients - " + this.getNumberOfClients() + ", all pets - " + this.getNumberOfPetsAll() + ":\n";
        for (Client client: clients){
            string += "\t" + client.getName() + ": ";
            for (String list: client.getPets()){
                string += list + ", ";
            }
            string +="\n";
        }
        return string;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clinic clinic = new Clinic(
                new Client("Jon", new Cat("barsik")),
                new Client("Billy", new Dog("doggy"), new Hamster("ham")),
                new Client("Jack", new Dog("pyshok"))
        );
        String exit = "no";

        try {
            while (!exit.equals("yes")) {
                System.out.println(clinic);
                System.out.println("Enter client: ");
                String client = scanner.next();
                System.out.println("Enter old name: ");
                String oldName = scanner.next();
                System.out.println("Enter new name: ");
                String newName = scanner.next();
                try {
                    clinic.editClientPetName(client, oldName, newName);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(clinic);
                System.out.println("Enter old client: ");
                oldName = scanner.next();
                System.out.println("Enter new client: ");
                newName = scanner.next();
                try {
                    clinic.editClientName(oldName, newName);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Exit: yes/no ?");
                exit = scanner.next();
            }
        }
        finally {
            scanner.close();
        }
    }
}
