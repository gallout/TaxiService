package dao;

import entity.Car;
import interfaces.DAO;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends Car implements DAO <Car, Integer> {

    enum SQLCar {
        GET("SELECT * FROM car"),
        GETALLBYBRAND("SELECT * FROM car WHERE brand=(?)"),
        GETBYID("SELECT * FROM car WHERE id_car=(?)"),
        INSERT("INSERT INTO car( brand, model, color, release_year, state_num, tech_state, status) VALUES ((?),(?),(?),(?),(?),(?),(?))"),
        DELETE("DELETE FROM car WHERE id_car = (?) "),
        UPDATE("UPDATE car SET id_car = (?), brand = (?), model = (?), color = (?), release_year = (?)," +
                " state_num = (?), tech_state = (?), status = (?) WHERE id_car = (?) ");

        String query;
        SQLCar(String query) {this.query = query;}
    }

    @Override
    public void create(@NotNull final Car car)  {
        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLCar.INSERT.query)) {
            //statement.setInt   (1,car.getIdCar());
            statement.setString(1,car.getBrand());
            statement.setString(2,car.getModel());
            statement.setString(3,car.getColor());
            statement.setDate  (4,car.getReleaseYear());
            statement.setString(5,car.getStateNum());
            statement.setString(6,car.getTechState());
            statement.setString(7,car.getStatus());
            statement.executeQuery();
            System.out.println("Произошло добавление " + car.getIdCar() + " номера автомобиля");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car readbyBrand(String brand) {
        final Car result = new Car();
        List list = new ArrayList();
        //result.setIdCar(-1);
        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLCar.GET.query)){
            statement.setString(1,brand);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdCar(rs.getInt("id_car"));
                result.setBrand(rs.getString("brand"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public Car readById(Integer id_car) {
        final Car result = new Car();

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLCar.GETBYID.query)){
            statement.setInt(1,id_car);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdCar(rs.getInt("id_car"));
                result.setBrand(rs.getString("brand"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public List<Car> readAllByBrand(String brand) {
        final Car result = new Car();
        List list = new ArrayList();

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLCar.GETALLBYBRAND.query)){
            statement.setString(1,brand);
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.setIdCar(rs.getInt("id_car"));
                result.setBrand(rs.getString("brand"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Car> read() {
        Car result = new Car();
        List list = new ArrayList();

        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLCar.GET.query)){
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result = new Car(
                        rs.getInt("id_car"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("color"),
                        rs.getDate("release_year"),
                        rs.getString("state_num"),
                        rs.getString("tech_state"),
                        rs.getString("status"));
                list.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public void update(Integer id_car, Car car) {
        try(PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLCar.UPDATE.query)) {
            statement.setInt   (1,car.getIdCar());
            statement.setString(2,car.getBrand());
            statement.setString(3,car.getModel());
            statement.setString(4,car.getColor());
            statement.setDate  (5,car.getReleaseYear());
            statement.setString(6,car.getStateNum());
            statement.setString(7,car.getTechState());
            statement.setString(8,car.getStatus());
            statement.setInt(9,id_car);
            statement.execute();
            System.out.println("Изменено значение " + id_car + " параметра");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id_car) {
        try (PreparedStatement statement = dao.GetConnection.getConnect().prepareStatement(SQLCar.DELETE.query)){
            statement.setInt(1,id_car);
             statement.execute();
            System.out.println("Запись с id " + id_car + " была удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
