package petsClinic;

import petsClinic.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
            List<Client> list = new ArrayList<Client>();
            try(final Statement statement = connection.createStatement();
                final ResultSet rs = statement.executeQuery("select * from Clients;")){
                while(rs.next()){
                    list.add(new Client(rs.getString("name")));
                }
                for (Client client: list) {
                    System.out.println(client.getName());
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
