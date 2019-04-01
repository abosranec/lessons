package petsClinic;

import petsClinic.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClinicJDBC implements ClinicStorage {
    private final Settings settings = Settings.getInstance();

    public ClinicJDBC() {
        try {
            Class.forName(settings.value("jdbc.driver_class"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getClients() {
        String sqlQuery = "select * from Clients C left join Pets P on C.clientID = P.clientID";
        ArrayList<Client> list = new ArrayList<Client>();
        try(final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery)
        ){
            while(rs.next()){
                Client client = new Client(rs.getString("clientName"));
                client.setSex(rs.getString("sex"));
                client.setCity(rs.getString("city"));
                client.setAddress(rs.getString("address"));
                client.setPhone(rs.getString("phone"));
                client.setMail(rs.getString("mail"));
                Pet pet = new Pet(
                        rs.getString("petName"),
                        rs.getString("type"),
                        rs.getString("birthday"));
                if (list.contains(client)) {
                    for (Client cl :list) {
                        if (client.equals(cl)){
                            cl.addPets(pet);
                            break;
                        }
                    }
                }
                else {
                    client.addPets(pet);
                    list.add(client);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addClient(Client client) throws Exception {
        try (final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
             final PreparedStatement statement = connection.prepareStatement(
                     "insert into Clients(clientName, sex, city, address, phone, mail) values (?,?,?,?,?,?)")) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSex());
            statement.setString(3, client.getCity());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getPhone());
            statement.setString(6, client.getMail());
            statement.executeUpdate();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user");
    }

    @Override
    public void removeClient(String name) throws Exception {

    }

    @Override
    public void editClientName(String oldName, Client newClient) throws Exception {

    }

    @Override
    public Client searchClient(String name) throws Exception {
        Client client = new Client(name);
//        try(final Connection connection = DriverManager.getConnection(
//                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
//            final PreparedStatement statement = connection.prepareStatement(
//                    "select * from Clients where name = ?;")){
//            statement.setString(1, name);
//            statement.executeUpdate();
////            statement.executeQuery();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return client;
    }

    @Override
    public void close() {
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
