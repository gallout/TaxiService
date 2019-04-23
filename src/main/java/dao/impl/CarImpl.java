package dao.impl;

import dao.CarDAO;
import entity.Car;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CarImpl {
    CarDAO cars;

    public CarImpl(CarDAO car) {
        cars = car;
    }

    public List<Car> getCars() throws SQLException, IOException {
        return cars.read();
    }
    public void addCars(Car car) throws SQLException, IOException {
        cars.create(car);
    }

    public void updateCars(int id_car,Car car) throws SQLException, IOException {
        cars.update(id_car, car);
    }

    public void deleteCars(int id_car) throws SQLException, IOException {
        cars.delete(id_car);
    }
}
