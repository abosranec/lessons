package petsClinic;

import java.util.List;

public interface ClientStorage {

    String getName();
    String getSex();
    String getCity();
    String getAddress();
    String getPhone();
    String getMail();
    List<Pet> getPets();

    void setName(String name);
    void setSex(String sex);
    void setCity(String city);
    void setAddress(String address);
    void setPhone(String phone);
    void setMail(String mail);

    void editClient(Client client);

    void addPets(Pet newPet) throws Exception;

    void removePet(String name) throws Exception;

    void editPetName(String oldName, Pet newPet) throws Exception;

    Pet searchPets(String name) throws Exception;

    boolean equals(Object obj);

    int hashCode();
}