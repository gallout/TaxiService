package dao;

import entity.Client;
import interfaces.DAO;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends Client implements DAO <Client, Integer> {

    enum SQLClient {
        GET("SELECT * FROM client"),
        GETALLBYFIO("SELECT * FROM client WHERE fio=(?)"),
        GETBYID("SELECT * FROM client WHERE id_client=(?)"),
        INSERT("INSERT INTO client(fio, adress, contact_num) VALUES ((?),(?),(?))"),
        DELETE("DELETE FROM client WHERE id_client = (?)"),
        UPDATE("UPDATE client SET id_client = (?), fio = (?), adress = (?), contact_num = (?) WHERE id_client = (?) ");
        String query;
        SQLClient(String query) {this.query = query;};
    }

    @Override
    public void create(@NotNull final Client client)  {

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLClient.INSERT.query)) {
            //statement.setInt   (1,client.getIdClient());
            statement.setString(1,client.getFio());
            statement.setString(2,client.getAddress());
            statement.setLong(3,client.getContactNum());
            statement.executeQuery();
            System.out.println("Произошло добавление " + client.getIdClient() + " номера клиента");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client readbyBrand(String fio) {
        final Client result = new Client();
        List list = new ArrayList();
        //result.setIdOperator(-1);
        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLClient.GET.query)){
            statement.setString(1,fio);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdClient(rs.getInt("id_client"));
                result.setFio(rs.getString("fio"));
                result.setAddress(rs.getString("address"));
                result.setContactNum(rs.getInt("contact_num"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public Client readById(Integer id_client) {
        final Client result = new Client();

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLClient.GETBYID.query)){
            statement.setInt(1,id_client);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdClient(rs.getInt("id_client"));
                result.setFio(rs.getString("fio"));
                result.setAddress(rs.getString("address"));
                result.setContactNum(rs.getInt("contact_num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public List<Client> readAllByBrand(String fio) {
        final Client result = new Client();
        List list = new ArrayList();

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLClient.GETALLBYFIO.query)){
            statement.setString(1,fio);
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.setIdClient(rs.getInt("id_client"));
                result.setFio(rs.getString("fio"));
                result.setAddress(rs.getString("address"));
                result.setContactNum(rs.getInt("contact_num"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Client> read() {
        Client result = new Client();
        List list = new ArrayList();

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLClient.GET.query)){
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result = new Client(
                        rs.getInt("id_client"),
                        rs.getString("fio"),
                        rs.getString("adress"),
                        rs.getLong("contact_num"));
                list.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public void update(Integer id_client, Client client) {
        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLClient.UPDATE.query)) {
            statement.setInt(1,client.getIdClient());
            statement.setString(2,client.getFio());
            statement.setString(3,client.getAddress());
            statement.setLong(4,client.getContactNum());
            statement.setInt(5,id_client);
            statement.execute();
            System.out.println("Изменено значение " + id_client + " параметра");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id_client) {
        try (PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLClient.DELETE.query)){
            statement.setInt(1,id_client);
            statement.execute();
            System.out.println("Запись с id " + id_client + " была удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
