package petsClinic;

import java.util.*;

public class Clinic{
    private static final Clinic INSTANCE = new Clinic();
    private ArrayList<Client> clients = new ArrayList<Client>();

    public Clinic() {
    }

    public Clinic(Client... clients) throws Exception {
        this();
        addClients(clients);
    }

    public static Clinic getINSTANCE() {
        return INSTANCE;
    }

    public ArrayList<Client> getClients() {
        return clients;
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

    public void addClients(Client... newClients) throws Exception {
        ArrayList<Client> list = new ArrayList<Client>(this.clients);
        for (Client client: newClients){
            if (list.contains(client)) {
                throw new Exception("Adding failed! Client \"" + client.getName() + "\" already exist!");
            }
            list.add(client);
        }
        this.clients.addAll(Arrays.asList(newClients));
    }

    public void removeClient(String name) throws Exception {
        this.clients.remove(searchClient(name));
    }

    public void removeClientAll(){
        this.clients.clear();
    }

//    public void addPet(String clientName, Pet... pets) throws Exception {
//        searchClient(clientName).addPets(pets);
//    }
//
//    public void removePet(String clientName, String pet) throws Exception{
//        searchClient(clientName).removePet(pet);
//    }

    public void editClientName(String oldName, Client newClient) throws Exception {
        if (clients.contains(newClient) && !oldName.equalsIgnoreCase(newClient.getName())) {
            throw new Exception("Renaming failed! Client \"" + newClient.getName() + "\" already exist !");
        }
        searchClient(oldName).editClient(newClient);
    }

//    public void editClientPetName(String client, String oldName, String newName) throws Exception{
//        searchClient(client).editPetName(oldName, newName);
//    }

    public List<String> seachClientsName(String pet){
        List<String> list = new ArrayList<String>();
        for (Client client: clients) {
            if(client.isPetName(pet)){
                list.add(client.getName());
            }
        }
        return list;
    }

//    public List<String> seachClientPets(String client) throws Exception {
//        return searchClient(client).getPets();
//    }

    public boolean isClientName(String name){
        for (Client client: clients) {
            if(name.equalsIgnoreCase(client.getName())){
                return true;
            }
        }
        return false;
    }

    public Client searchClient(String name) throws Exception {
        for (Client client: clients) {
            if(name.equalsIgnoreCase(client.getName())){
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
            for (Pet list: client.getPets()){
                string += list.getName() + ", ";
            }
            string +="\n";
        }
        return string;
    }

}
