package dao;

import entity.Order;
import interfaces.DAO;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends Order implements DAO <Order, Integer> {

    enum SQLOrder {
        GET("SELECT * FROM orders"),
        GETALLBYBRAND("SELECT * FROM orders WHERE order_get_date=(?)"),
        GETBYID("SELECT * FROM orders WHERE id_order=(?)"),
        INSERT("INSERT INTO orders(order_get_date, order_get_time, order_set_date, order_set_time, departure_point, destination_point, order_status, order_price) VALUES ((?),(?),(?),(?),(?),(?),(?),(?))"),
        DELETE("DELETE FROM orders WHERE id_order = (?) "),
        UPDATE("UPDATE orders SET id_order = (?), order_get_date = (?), order_get_time = (?), order_set_date = (?), order_set_time = (?)," +
                " departure_point = (?), destination_point = (?), order_status = (?), order_price = (?) WHERE id_order = (?) ");

        String query;
        SQLOrder(String query) {this.query = query;}
    }

    @Override
    public void create(@NotNull final Order order)  {

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOrder.INSERT.query)) {
            //statement.setInt   (1,order.getIdOrder());
            statement.setDate(1,order.getOrderGetDate());
            statement.setTime(2,order.getOrderGetTime());
            statement.setDate(3,order.getOrderSetDate());
            statement.setTime (4,order.getOrderSetTime());
            statement.setString(5,order.getDeparturePoint());
            statement.setString(6,order.getDestinationPoint());
            statement.setString(7,order.getOrderStatus());
            statement.setInt(8, order.getOrderPrice());
            statement.executeQuery();
            System.out.println("Произошло добавление " + order.getIdOrder() + " номера заказа");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order readbyBrand(String brand) {
        final Order result = new Order();
        List list = new ArrayList();
        //result.setIdOrde(-1);
        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOrder.GET.query)){
            statement.setString(1,brand);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdOrder(rs.getInt("id_order"));
                result.setOrderPrice(rs.getInt("order_price"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public Order readById(Integer id_order) {
        final Order result = new Order();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOrder.GETBYID.query)){
            statement.setInt(1,id_order);
            final ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result.setIdOrder(rs.getInt("id_order"));
                result.setOrderPrice(rs.getInt("order_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public List<Order> readAllByBrand(String brand) {
        final Order result = new Order();
        List list = new ArrayList();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOrder.GETALLBYBRAND.query)){
            statement.setString(1,brand);
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.setIdOrder(rs.getInt("id_order"));
                result.setOrderPrice(rs.getInt("order_price"));
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Order> read() {
        Order result = new Order();
        List list = new ArrayList();

        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOrder.GET.query)){
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result = new Order(
                        rs.getInt("id_order"),
                        rs.getDate("order_get_date"),
                        rs.getTime("order_get_time"),
                        rs.getDate("order_set_date"),
                        rs.getTime("order_set_time"),
                        rs.getString("departure_point"),
                        rs.getString("destination_point"),
                        rs.getString("order_status"),
                        rs.getInt("order_price"));
                list.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    @Override
    public void update(Integer id_order, Order order) {
        try(PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOrder.UPDATE.query)) {
            statement.setInt   (1,order.getIdOrder());
            statement.setDate(2,order.getOrderGetDate());
            statement.setTime(3,order.getOrderGetTime());
            statement.setDate(4,order.getOrderSetDate());
            statement.setTime (5,order.getOrderSetTime());
            statement.setString(6,order.getDeparturePoint());
            statement.setString(7,order.getDestinationPoint());
            statement.setString(8,order.getOrderStatus());
            statement.setInt(9, order.getOrderPrice());
            statement.setInt(10,id_order);
            statement.execute();
            System.out.println("Изменено значение " + id_order + " параметра");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id_order) {
        try (PreparedStatement statement = GetConnection.getConnect().prepareStatement(SQLOrder.DELETE.query)){
            statement.setInt(1,id_order);
            statement.execute();
            System.out.println("Запись с id " + id_order + " была удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
