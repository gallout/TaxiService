package entity;

import java.sql.Time;
import java.sql.Date;

public class Order {

    private int id_order;
    private Date order_get_date;
    private Time order_get_time;
    private Date order_set_date;
    private Time order_set_time;
    private String departure_point;
    private String destination_point;
    private String order_status;
    private int order_price;

    public Order(int id_order, Date order_get_date, Time order_get_time, Date order_set_date, Time order_set_time,
                 String departure_point, String destination_point, String order_status, int order_price) {
        this.id_order = id_order;
        this.order_get_date = order_get_date;
        this.order_get_time = order_get_time;
        this.order_set_date = order_set_date;
        this.order_set_time = order_set_time;
        this.departure_point = departure_point;
        this.destination_point = destination_point;
        this.order_status = order_status;
        this.order_price = order_price;
    }

    public Order(Date order_get_date, Time order_get_time, Date order_set_date, Time order_set_time,
                 String departure_point, String destination_point, String order_status, int order_price) {
        this.order_get_date = order_get_date;
        this.order_get_time = order_get_time;
        this.order_set_date = order_set_date;
        this.order_set_time = order_set_time;
        this.departure_point = departure_point;
        this.destination_point = destination_point;
        this.order_status = order_status;
        this.order_price = order_price;
    }

    public Order() { }

    public int getIdOrder() {
        return id_order;
    }
    public void setIdOrder(int id_order) {
        this.id_order = id_order;
    }

    public Date getOrderGetDate() {
        return order_get_date;
    }
    public void setOrderGetDate(Date order_get_date) {
        this.order_get_date = order_get_date;
    }

    public Time getOrderGetTime() {
        return order_get_time;
    }
    public void setOrderGetDate(Time order_get_time) {
        this.order_get_time = order_get_time;
    }

    public Date getOrderSetDate() {
        return order_set_date;
    }
    public void setOrderSetDate(Date order_set_date) {
        this.order_set_date = order_set_date;
    }

    public Time getOrderSetTime() {
        return order_set_time;
    }
    public void setOrderSetTime(Time order_set_time) {
        this.order_set_time = order_set_time;
    }

    public String getDeparturePoint() {
        return departure_point;
    }
    public void setDeparturePoint(String departure_point) {
        this.departure_point = departure_point;
    }

    public String getDestinationPoint() {
        return destination_point;
    }
    public void setDestinationPoint(String destination_point) {
        this.destination_point = destination_point;
    }

    public String getOrderStatus() {
        return order_status;
    }
    public void setOrderStatus(String order_status) {
        this.order_status = order_status;
    }

    public int getOrderPrice() {
        return order_price;
    }
    public void setOrderPrice(int order_price) {
        this.order_price = order_price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_order=" + id_order +
                ", order_get_date='" + order_get_date +
                ", order_get_time=" + order_get_time +
                ", order_set_date=" + order_set_date +
                ", order_set_time='" + order_set_time +
                ", departure_point=" + departure_point +
                ", destination_point=" + destination_point +
                ", order_status='" + order_status +
                ", order_price=" + order_price +
                '}';
    }
}