package dao.impl;

import dao.OrderDAO;
import entity.Order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrderImpl {
    OrderDAO orders;

    public OrderImpl( OrderDAO order) {
        orders=order;
    }

    public List<Order> getOrders() throws SQLException, IOException {
        return orders.read();
    }

    public void addOrder(Order order) throws SQLException, IOException {
        orders.create(order);
    }

    public void updateOrder(int id_order, Order order) throws SQLException, IOException {
        orders.update(id_order, order);
    }

    public void deleteOrder(int id_order) throws SQLException, IOException {
        orders.delete(id_order);
    }

}
