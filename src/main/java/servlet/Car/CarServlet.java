package servlet.Car;

import dao.*;
import dao.impl.CarImpl;
import dao.impl.ClientImpl;
import entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@WebServlet("/car")
public class CarServlet  extends HttpServlet {

    private CarImpl impl;
    private static String Index = "/car.jsp";
    public void init(ServletConfig servletConfig) {
        try {
            CarDAO CL = new CarDAO();
            impl = new CarImpl(CL);
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            //response.setContentType("text/html;charset=utf-8");
            List<Car> cars = impl.getCars();
            req.setAttribute("cars", cars);
            RequestDispatcher dispatcher = req.getRequestDispatcher("car.jsp");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");

            String brand = request.getParameter("brand");
            String brand_model = request.getParameter("model");
            String color = request.getParameter("color");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = sdf.parse(request.getParameter("release_year"));
            Date release_year = new Date(Calendar.getInstance().getTime().getTime());
            if (parsed!=null) {
                release_year = new Date(parsed.getTime());
            }

            String state_num = request.getParameter("state_num");
            String tech_state = request.getParameter("tech_state");
            String status = request.getParameter("status");

            Car cr = new Car(brand,brand_model,color,release_year,state_num,tech_state,status);
            impl.addCars(cr);
            response.sendRedirect("car");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
