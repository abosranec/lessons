package petsClinic;

import petsClinic.service.Settings;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientJDBC implements ClientStorage {
    private final Settings settings = Settings.getInstance();
    private String name;
    private String sex;
    private String city;
    private String address;
    private String phone;
    private String mail;

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
    }

    @Override
    public ArrayList<Pet> getPets() {
        String sqlQuery = String.format("select * from Pets p where p.clientID = " +
                "(select clientID from clients where clientName = '%s')", getName());
        ArrayList<Pet> list = new ArrayList<>();
        try(final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery)
        ){
            while(rs.next()){
                list.add(new Pet(
                        rs.getString("petName"),
                        rs.getString("type"),
                        rs.getString("birthday")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addPets(Pet newPet) throws Exception {
        try (final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
             final PreparedStatement statement = connection.prepareStatement(
                     "insert into Pets(petName, type, birthday, clientID) values (?,?,?,?)")) {
            Pet cl = searchPets(newPet.getName());
            if (cl != null){
                throw new Exception("Adding failed! Pet \"" + newPet.getName() +
                        "\" for client \"" + getName() + "\" already exist!");
            }
            statement.setString(1, newPet.getName());
            statement.setString(2, newPet.getType());
            if (newPet.getBirthday().equals("")){
                statement.setDate(3, null);
            }else {
                statement.setDate(3, getSQLDate(newPet.getBirthday()));
            }
            statement.setInt(4, getID());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void removePet(String name) throws Exception {
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
        try (final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
             final PreparedStatement statement = connection.prepareStatement(
                     "update Pets set petName = ?, type = ?, birthday = ? where petName = ? and clientID = " +
                             "(select clientID from clients where clientName = ?);")) {
            Pet pet = searchPets(newPet.getName());
            if (pet != null && !oldName.equalsIgnoreCase(newPet.getName())){
                throw new Exception("Renaming failed! Pet \"" + newPet.getName() +
                        "\" for client \"" + getName() + "\" already exist !");
            }
            statement.setString(1, newPet.getName());
            statement.setString(2, newPet.getType());
            if (newPet.getBirthday().equals("")){
                statement.setDate(3, null);
            }else {
                statement.setDate(3, getSQLDate(newPet.getBirthday()));
            }
            statement.setString(4, oldName);
            statement.setString(5, getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Pet searchPets(String name) throws Exception {
        String sqlQuery = String.format(
                "select * from Pets p where upper(p.petName) = upper('%s') and " +
                        "p.clientID = (select clientID from clients where clientName = '%s');", name, getName());
        Pet pet = null;
        try(final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery)
        ){
            if (rs.next()){
                pet = new Pet(
                        rs.getString("petName"),
                        rs.getString("type"),
                        rs.getString("birthday"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Operation failed, pet name \"" + name + "\" doesn't exist!");
        }
        return pet;
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

    private java.sql.Date getSQLDate(String string) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(string);
        return new java.sql.Date(date.getTime());
    }
}
