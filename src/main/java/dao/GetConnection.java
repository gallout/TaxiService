package dao;

import servlet.Client.ClientServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection extends ClientServlet {

    public static Connection getConnect() throws SQLException {
        final String db_driver = "org.postgresql.Driver";
        final String url = "jdbc:postgresql://localhost:5432/taxi_service";
        final String username = "postgres";
        final String password = "edition91";
        final Connection con = DriverManager.getConnection(url, username, password);

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Class.forName(db_driver);
            System.out.println("Соединение с БД установлено");

        } catch (ClassNotFoundException e) {
            System.err.println("Не удалось загрузить класс драйвера");

        }
        /*finally {
            con.close();
        } */
        if (con.isClosed()) {
            System.out.println("Соединение с БД закрыто");
        }
        return  con;
    }
}
