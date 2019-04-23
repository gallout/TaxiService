package dao.impl;

import dao.ClientDAO;
import entity.Client;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClientImpl {
    ClientDAO clients;

    public ClientImpl(ClientDAO client) {
        clients = client;
    }

    public List<Client> getClients() throws SQLException, IOException {
        return clients.read();
    }
    public void addClients(Client client) throws SQLException, IOException {
        clients.create(client);
    }

    public void updateClients(int id_client,Client client) throws SQLException, IOException {
        clients.update(id_client, client);
    }

    public void deleteClients(int id_client) throws SQLException, IOException {
        clients.delete(id_client);
    }

}
