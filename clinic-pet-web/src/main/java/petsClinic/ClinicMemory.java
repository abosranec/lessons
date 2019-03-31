package petsClinic;

import java.util.ArrayList;
import java.util.List;

public class ClinicMemory implements ClinicStorage {

    private ArrayList<Client> clients = new ArrayList<Client>();

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public void addClient(Client client) throws Exception {
        if (this.clients.contains(client)) {
            throw new Exception("Adding failed! Client \"" + client.getName() + "\" already exist!");
        }
        this.clients.add(client);
    }

    @Override
    public void removeClient(String name) throws Exception {
        this.clients.remove(searchClient(name));
    }

    @Override
    public void editClientName(String oldName, Client newClient) throws Exception {
        if (clients.contains(newClient) && !oldName.equalsIgnoreCase(newClient.getName())) {
            throw new Exception("Renaming failed! Client \"" + newClient.getName() + "\" already exist !");
        }
        searchClient(oldName).editClient(newClient);
    }

    @Override
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
//        String string = "All clients - " + this.getNumberOfClients() + ", all pets - " + this.getNumberOfPetsAll() + ":\n";
        String string = "";
        for (Client client: clients){
            string += "\t" + client.getName() + ": ";
            for (Pet list: client.getPets()){
                string += list.getName() + ", ";
            }
            string +="\n";
        }
        return string;
    }

//    public int getNumberOfClients(){
//        return clients.size();
//    }
//
//    public int getNumberOfPetsAll(){
//        int size = 0;
//        for (Client client: clients) {
//            size+= client.getNumberOfPets();
//        }
//        return size;
//    }

//    public List<String> seachClientsName(String pet){
//        List<String> list = new ArrayList<String>();
//        for (Client client: clients) {
//            if(client.isPetName(pet)){
//                list.add(client.getName());
//            }
//        }
//        return list;
//    }
//
//    public boolean isClientName(String name){
//        for (Client client: clients) {
//            if(name.equalsIgnoreCase(client.getName())){
//                return true;
//            }
//        }
//        return false;
//    }
}
