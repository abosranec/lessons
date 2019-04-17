package petsClinic;

import java.util.Collection;
import java.util.List;

public interface ClientStorage {

    int getId();
    String getName();
    String getSex();
    String getCity();
    String getAddress();
    String getPhone();
    String getMail();
    Collection<Pet> getPets();

    void setId(int id);
    void setName(String name);
    void setSex(String sex);
    void setCity(String city);
    void setAddress(String address);
    void setPhone(String phone);
    void setMail(String mail);
    void setPets(Collection<Pet> pets);

    void editClient(Client client);

    void addPets(Pet newPet) throws Exception;

    void removePet(String name) throws Exception;

    void editPetName(String oldName, Pet newPet) throws Exception;

    Pet searchPets(String name) throws Exception;

    boolean equals(Object obj);

    int hashCode();
}
