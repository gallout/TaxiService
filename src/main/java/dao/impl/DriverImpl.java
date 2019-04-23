package dao.impl;

import dao.DriverDAO;
import entity.Driver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DriverImpl {
    DriverDAO drivers;
    public DriverImpl(DriverDAO driver) {
        drivers = driver;
    }

    public List<Driver> getDrivers() throws SQLException, IOException {
        return drivers.read();
    }


    public void addDriver(Driver driver) throws SQLException, IOException {
        drivers.create(driver);
    }

    public void updateDriver(int id_driver,Driver driver) throws SQLException, IOException {
        drivers.update(id_driver, driver);
    }

    public void deleteDriver(int id_driver) throws SQLException, IOException {
        drivers.delete(id_driver);
    }
}
