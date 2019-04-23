package dao;

import entity.Operator;
import interfaces.DAO;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperatorDAO extends Operator implements DAO <Operator, Integer> {

    enum SQLOperator {
        GET("SELECT * FROM operator"),
        GETALLBYFIO("SELECT * FROM operator WHERE fio=(?)"),
        GETBYID("SELECT * FROM operator WHERE id_operator=(?)"),
        INSERT("INSERT INTO operator(fio, adress, contact_num) VALUES ((?),(?),(?))"),
        DELETE("DELETE FROM operator WHERE id_operator = (?) "),
        UPDATE("UPDATE operator SET id_operator = (?), fio = (?), adress = (?), contact_num = (?) WHERE id_operator = (?) ");
        String query;
        SQLOperator(String query) {this.query = query;};
    }

    @Override
    public void create( @NotNull final Operator operator)  {

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOperator.INSERT.query)) {
          //  statement.setInt   (1,operator.getIdOperator());
            statement.setString(1,operator.getFio());
            statement.setString(2,operator.getAddress());
            statement.setLong(3,operator.getContactNum());

            statement.executeQuery();
            System.out.println("Произошло добавление " + operator.getIdOperator() + " номера оператора");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Operator readbyBrand(String fio) {
        final Operator result = new Operator();
        List list = new ArrayList();
        //result.setIdOperator(-1);
        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOperator.GET.query)){
            statement.setString(1,fio);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdOperator(rs.getInt("id_operator"));
                result.setFio(rs.getString("fio"));
                result.setAddress(rs.getString("adress"));
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
    public Operator readById(Integer id_operator) {
        final Operator result = new Operator();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOperator.GETBYID.query)){
            statement.setInt(1,id_operator);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdOperator(rs.getInt("id_operator"));
                result.setFio(rs.getString("fio"));
                result.setAddress(rs.getString("adress"));
                result.setContactNum(rs.getInt("contact_num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public List<Operator> readAllByBrand(String fio) {
        final Operator result = new Operator();
        List list = new ArrayList();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOperator.GETALLBYFIO.query)){
            statement.setString(1,fio);
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.setIdOperator(rs.getInt("id_operator"));
                result.setFio(rs.getString("fio"));
                result.setAddress(rs.getString("adress"));
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
    public List<Operator> read() {
        Operator result = new Operator();
        List list = new ArrayList();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOperator.GET.query)){
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result = new Operator(
                        rs.getInt("id_operator"),
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
    public void update(Integer id_operator, Operator operator) {
        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOperator.UPDATE.query)) {
            statement.setInt   (1,operator.getIdOperator());
            statement.setString(2,operator.getFio());
            statement.setString(3,operator.getAddress());
            statement.setLong(4,operator.getContactNum());
            statement.setInt(5,id_operator);
            statement.execute();
            System.out.println("Изменено значение " + id_operator + " параметра");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id_operator) {
        try (PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOperator.DELETE.query)){
            statement.setInt(1,id_operator);
            statement.execute();
            System.out.println("Запись с id " + id_operator + " была удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
