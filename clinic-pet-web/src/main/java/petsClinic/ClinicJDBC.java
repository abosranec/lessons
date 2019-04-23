package petsClinic;

import org.springframework.stereotype.Repository;
import petsClinic.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClinicJDBC implements ClinicStorage {
    private final Settings settings = Settings.getInstance();

    public ClinicJDBC() {
        System.out.println("Clinic jdbc");
        try {
            Class.forName(settings.value("jdbc.driver_class"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getClients() {
        String sqlQuery = "select * from Clients C";
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
                list.add(client);
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
            Client cl = searchClient(client.getName());
            if (cl != null){
                throw new Exception();
            }
            statement.setString(1, client.getName());
            statement.setString(2, client.getSex());
            statement.setString(3, client.getCity());
            statement.setString(4, client.getAddress());
            statement.setString(5, client.getPhone());
            statement.setString(6, client.getMail());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Adding failed! Client \"" + client.getName() + "\" already exist!");
        }
    }

    @Override
    public void removeClient(String name) throws Exception {
        String sqlQuery = String.format("delete from Pets p where p.clientID = " +
                "(select clientID from clients where clientName = '%s');\n" +
                "delete from Clients where clientName = '%s';", name, name);
        try(final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
            final Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlQuery);
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Operation failed, client name \"" + name + "\" doesn't exist!");
        }
    }

    @Override
    public void editClientName(String oldName, Client newClient) throws Exception {
        try (final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
             final PreparedStatement statement = connection.prepareStatement(
                     "update Clients set clientName = ?, sex = ?, city = ?, address = ?, phone = ?, mail = ? " +
                             "where clientName = ?;")) {
            Client cl = searchClient(newClient.getName());
            if (cl != null && !oldName.equalsIgnoreCase(newClient.getName())){
                throw new Exception("Renaming failed! Client \"" + newClient.getName() + "\" already exist !");
            }
            statement.setString(1, newClient.getName());
            statement.setString(2, newClient.getSex());
            statement.setString(3, newClient.getCity());
            statement.setString(4, newClient.getAddress());
            statement.setString(5, newClient.getPhone());
            statement.setString(6, newClient.getMail());
            statement.setString(7, oldName);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Client searchClient(String name) throws Exception {
        String sqlQuery = String.format(
                "select * from Clients C left join Pets P on C.clientID = P.clientID where upper(C.clientName) = upper('%s');", name);
        Client client = null;
        try(final Connection connection = DriverManager.getConnection(
                settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(sqlQuery)
        ){
            while(rs.next()){
                if (client == null){
                    client = new Client(rs.getString("clientName"));
                    client.setSex(rs.getString("sex"));
                    client.setCity(rs.getString("city"));
                    client.setAddress(rs.getString("address"));
                    client.setPhone(rs.getString("phone"));
                    client.setMail(rs.getString("mail"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Operation failed, client name \"" + name + "\" doesn't exist!");
        }
        return client;
    }

    @Override
    public void close() {
    }
}
