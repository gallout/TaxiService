package dao;

import entity.Driver;
import interfaces.DAO;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO extends Driver implements DAO <Driver, Integer> {
    /*private final Connection connection;

    public DriverDAO(Connection connection) {
        this.connection = connection;
    }*/

    enum SQLDriver {
        GET("SELECT * FROM driver"),
        GETALLBYBRAND("SELECT * FROM driver WHERE fio=(?)"),
        GETBYID("SELECT * FROM driver WHERE id_driver=(?)"),
        INSERT("INSERT INTO driver(fio, pass_seria, pass_numb, inn, licence, stage, category, personal_auto, trip_num) VALUES ((?),(?),(?),(?),(?),(?),(?),(?),(?))"),
        DELETE("DELETE FROM driver WHERE id_driver = (?) "),
        UPDATE("UPDATE driver SET id_driver = (?), fio = (?), pass_seria = (?), pass_numb = (?), inn = (?)," +
                " licence = (?), stage = (?), category = (?), personal_auto = (?), trip_num = (?) WHERE id_driver = (?) ");

        String query;
        SQLDriver(String query) {this.query = query;}
    }

    @Override
    public void create(@NotNull final Driver driver)  {

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLDriver.INSERT.query)) {
           // statement.setInt   (1,driver.getIdDriver());
            statement.setString(1,driver.getFio());
            statement.setInt(2,driver.getPassSeria());
            statement.setInt(3,driver.getPassNumb());
            statement.setLong(4,driver.getInn());
            statement.setInt  (5,driver.getLicence());
            statement.setInt(6,driver.getStage());
            statement.setString(7,driver.getCategory ());
            statement.setBoolean(8,driver.getPersonalAuto());
            statement.setInt(9,driver.getTripNum());
            statement.executeQuery();
            System.out.println("Произошло добавление " + driver.getIdDriver() + " номера водителя");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Driver readbyBrand(String brand) {
        final Driver result = new Driver();
        List list = new ArrayList();
        //result.setIdDriver(-1);
        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLDriver.GET.query)){
            statement.setString(1,brand);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdDriver(rs.getInt("id_driver"));
                result.setFio(rs.getString("fio"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public Driver readById(Integer id_driver) {
        final Driver result = new Driver();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLDriver.GETBYID.query)){
            statement.setInt(1,id_driver);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdDriver(rs.getInt("id_driver"));
                result.setFio(rs.getString("fio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public List<Driver> readAllByBrand(String brand) {
        final Driver result = new Driver();
        List list = new ArrayList();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLDriver.GETALLBYBRAND.query)){
            statement.setString(1,brand);
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.setIdDriver(rs.getInt("id_driver"));
                result.setFio(rs.getString("fio"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Driver> read() {
        Driver result = new Driver();
        List list = new ArrayList();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLDriver.GET.query)){
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result = new Driver(
                        rs.getInt("id_driver"),
                        rs.getString("fio"),
                        rs.getInt("pass_seria"),
                        rs.getInt("pass_numb"),
                        rs.getLong("inn"),
                        rs.getInt("licence"),
                        rs.getInt("stage"),
                        rs.getString("category"),
                        rs.getBoolean("personal_auto"),
                        rs.getInt("trip_num"));
                list.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public void update(Integer id_driver, Driver driver) {
        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLDriver.UPDATE.query)) {
            statement.setInt   (1,driver.getIdDriver());
            statement.setString(2,driver.getFio());
            statement.setInt(3,driver.getPassSeria());
            statement.setInt(4,driver.getPassNumb());
            statement.setLong(5,driver.getInn());
            statement.setInt  (6,driver.getLicence());
            statement.setInt(7,driver.getStage());
            statement.setString(8,driver.getCategory ());
            statement.setBoolean(9,driver.getPersonalAuto());
            statement.setInt(10,driver.getTripNum());
            statement.setInt(11,id_driver);
            statement.execute();
            System.out.println("Изменено значение " + id_driver + " параметра");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id_driver) {
        try (PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLDriver.DELETE.query)){
            statement.setInt(1,id_driver);
            statement.execute();
            System.out.println("Запись с id " + id_driver + " была удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
