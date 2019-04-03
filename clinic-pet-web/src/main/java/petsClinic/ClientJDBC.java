package petsClinic;

import petsClinic.service.Settings;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class ClientJDBC implements ClientStorage {
    private final Settings settings = Settings.getInstance();
    private String name;
    private String sex;
    private String city;
    private String address;
    private String phone;
    private String mail;
    private ArrayList<Pet> pets = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSex() {
        return sex;
    }
    @Override
    public String getCity() {
        return city;
    }
    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public String getPhone() {
        return phone;
    }
    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public void editClient(Client client){
        setName(client.getName());
        setSex(client.getSex());
        setCity(client.getCity());
        setAddress(client.getAddress());
        setPhone(client.getPhone());
        setMail(client.getMail());
        this.pets.clear();
        this.pets.addAll(client.getPets());
    }

    @Override
    public ArrayList<Pet> getPets() {
        String sqlQuery = String.format("select * from Pets p where p.clientID = " +
                "(select clientID from clients where clientName = '%s')", getName());
        ArrayList<Pet> list = new ArrayList<>();
//        try(final Connection connection = DriverManager.getConnection(
//                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
//            final Statement statement = connection.createStatement();
//            final ResultSet rs = statement.executeQuery(sqlQuery)
//        ){
//            while(rs.next()){
//                list.add(new Pet(
//                        rs.getString("petName"),
//                        rs.getString("type"),
//                        rs.getString("birthday")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return list;
    }

    @Override
    public void addPets(Pet newPet) throws Exception {
        try (final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
             final PreparedStatement statement = connection.prepareStatement(
                     "insert into Pets(petName, type, birthday, clientID) values (?,?,?,?)")) {
//            Client cl = searchClient(client.getName());
//            if (cl != null){
//                throw new Exception();
//            }
            statement.setString(1, newPet.getName());
            statement.setString(2, newPet.getType());
            //String startDate="12-31-2014";
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf1.parse(newPet.getBirthday());
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            statement.setDate(3, sqlStartDate);
            statement.setInt(4, getID());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Adding failed! Pet \"" + newPet.getName() +
                    "\" for client \"" + getName() + "\" already exist!");
        }

    }

    @Override
    public void removePet(String name) throws Exception {
        this.pets.remove(searchPets(name));
        String sqlQuery = String.format("delete from Pets p where p.petName = '%s' AND \n" +
                "p.clientID = (select clientID from clients where clientName = '%s');", name, getName());
        try(final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
            final Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlQuery);
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Operation failed, pet name \"" + name + "\" doesn't exist!");
        }
    }

    @Override
    public void editPetName(String oldName, Pet newPet) throws Exception {
        if (pets.contains(newPet) && !oldName.equalsIgnoreCase(newPet.getName())) {
            throw new Exception("Renaming failed! Pet \"" + newPet +
                    "\" for client \"" + getName() + "\" already exist !");
        }
        searchPets(oldName).editPet(newPet);
    }

    @Override
    public Pet searchPets(String name) throws Exception {
        for (Pet pet: pets) {
            if(name.equalsIgnoreCase(pet.getName())){
                return pet;
            }
        }
        throw new Exception("Operation failed, pet name \"" + name + "\" doesn't exist!");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (Client.class != obj.getClass()) {
            return false;
        }
        return (name.equalsIgnoreCase(((Client)obj).getName()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        return 31 * result + Arrays.hashCode(name.toCharArray());
    }

    private int getID(){
        String sqlQuery = String.format("select * from Clients c where c.clientName = '%s';", getName());
        int result = 0;
        try(final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery)
        ){
            if (rs.next() && rs.getString("clientName") != null){
                result = rs.getInt("clientID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
