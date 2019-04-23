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

@WebServlet("/updateCar")
public class UpdateCar  extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id_car = 0;
        String brand = "";
        String brand_model = "";
        String color = "";
        java.sql.Date release_year = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String state_num;
        String tech_state;
        String status;

        System.out.println(request.getParameter("id_car"));
        System.out.println(request.getParameter("brand") );
        System.out.println(request.getParameter("model") );
        System.out.println(request.getParameter("color"));
        System.out.println(request.getParameter("release_year"));
        System.out.println(request.getParameter("state_num") );
        System.out.println(request.getParameter("tech_state") );
        System.out.println(request.getParameter("status"));
        try {
            if (request.getParameter("id_car") != null && request.getParameter("brand") != null &&
                    request.getParameter("model") != null &&
                    request.getParameter("color") != null && request.getParameter("release_year") != null &&
                    request.getParameter("state_num") != null && request.getParameter("tech_state") != null
                    && request.getParameter("status") != null) {

                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");

                id_car = Integer.parseInt(request.getParameter("id_car"));
                brand = request.getParameter("brand");
                brand_model = request.getParameter("model");
                color = request.getParameter("color");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date parsed = null;
                try {
                    parsed = (Date) sdf.parse(request.getParameter("release_year"));
                } catch (ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                if (parsed!=null) {
                    release_year = new java.sql.Date(parsed.getTime());
                }

                state_num = request.getParameter("state_num");
                tech_state = request.getParameter("tech_state");
                status = request.getParameter("status");

                Car cr = new Car(id_car, brand, brand_model, color, release_year, state_num, tech_state, status);
                impl.updateCars(id_car, cr);
                response.sendRedirect("car");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
