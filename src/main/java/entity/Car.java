package entity;

import java.sql.Date;

public class Car {

    private int id_car;
    private String brand;
    private String model;
    private String color;
    private Date release_year;
    private String state_num;
    private String tech_state;
    private String status;

    public Car(int id_car, String brand, String model, String color, Date release_year, String state_num,
               String tech_state, String status) {
        this.id_car = id_car;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.release_year = release_year;
        this.state_num = state_num;
        this.tech_state = tech_state;
        this.status = status;
    }
    public Car(String brand, String model, String color, Date release_year, String state_num,
               String tech_state, String status) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.release_year = release_year;
        this.state_num = state_num;
        this.tech_state = tech_state;
        this.status = status;
    }
    public Car() {}

    public int getIdCar() {
        return id_car;
    }
    public void setIdCar(int id_car) {
        this.id_car = id_car;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Date getReleaseYear() {
        return release_year;
    }
    public void setReleaseYear(Date release_year) {
        this.release_year = release_year;
    }

    public String getStateNum() {
        return state_num;
    }
    public void setStateNum(String state_num) {
        this.state_num = state_num;
    }

    public String getTechState() {
        return tech_state;
    }
    public void setTechState(String tech_state) {
        this.tech_state = tech_state;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id_car=" + id_car +
                ", brand='" + brand +
                ", model=" + model +
                ", color=" + color +
                ", release_year='" + release_year +
                ", state_num=" + state_num +
                ", tech_state=" + tech_state +
                ", status='" + status +
                '}';
    }
}