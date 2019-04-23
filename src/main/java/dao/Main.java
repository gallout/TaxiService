package dao;

import entity.Order;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (PreparedStatement statement =  dao.GetConnection.getConnect().prepareStatement("SELECT * FROM client WHERE id_client=(?)")) {
            // try (PreparedStatement statement = con.prepareStatement("SELECT * FROM car WHERE id_car=(?)")){
            statement.setInt(1, 2);
            OrderDAO order = new OrderDAO();
            List<Order> ord = order.read();
       //     System.out.println(ord);
            // CarDAO cd = new CarDAO (con);            //cd.create(new Car(21,"Porsche","Panamera","red",Date.valueOf("2013-09-04"),"432423","good","in rent"));
            //cd.read("Porsche");
            //cd.readAllByBrand("Porsche");
            //cd.readById(1);
            //cd.read();
            //cd.delete(6);
            //     cd.update(44, new Car(88,"Лада","Sedan","baklazhan",Date.valueOf("2015-03-04"), "45342","bad","in park"));
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                // String brand = "brand:" + rs.getString(2);
                // String model = "model:" + rs.getString(3);
              //  String id_order = "id_order:" + rs.getInt(1);

             //   String departure_point = "departure_point:" + rs.getString(6);
            //    String destination_point = "destination_point:" + rs.getString(7);
            //    String order_status = "destination_point:" + rs.getString(8);
            //    String order_price = "destination_point:" + rs.getInt(9);

             //   System.out.println(id_order);
            //   System.out.println(order_get_date);
            //    System.out.println(order_get_time);
             //   System.out.println(order_set_date);
             //   System.out.println(order_set_time);
             //   System.out.println(departure_point);
            //    System.out.println(destination_point);
            //    System.out.println(order_status);
            //    System.out.println(order_price);
                //System.out.println(brand);
                //System.out.println(model);
            }
        }
    }
}