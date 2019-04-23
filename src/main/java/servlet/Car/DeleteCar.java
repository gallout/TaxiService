package servlet.Car;

import dao.*;
import dao.impl.CarImpl;
import entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/deleteCar")
public class DeleteCar  extends HttpServlet {

    private CarImpl impl;
    private static String Index = "/car.jsp";

    public void init(ServletConfig servletConfig) {
        try {
            CarDAO CD = new CarDAO();
            impl = new CarImpl(CD);
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            int id_car = Integer.parseInt(request.getParameter("id_car"));
            impl.deleteCars(id_car);
            response.sendRedirect("car");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
