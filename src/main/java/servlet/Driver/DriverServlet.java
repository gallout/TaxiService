package servlet.Driver;

import dao.*;
import dao.impl.DriverImpl;
import entity.Driver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/driver")
public class DriverServlet extends HttpServlet {
    private DriverImpl impl;
    private static String Index = "/driver.jsp";

    public void init(ServletConfig servletConfig) {
        try {
            DriverDAO DD = new DriverDAO();
            impl = new DriverImpl(DD);
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=utf-8");
            List<Driver> drivers = impl.getDrivers();
            request.setAttribute("drivers", drivers);
            request.getRequestDispatcher(Index).forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            Boolean personal_auto = false;

            String fio = request.getParameter("fio");
            int pass_seria = Integer.parseInt(request.getParameter("pass_seria"));
            int pass_numb = Integer.parseInt(request.getParameter("pass_numb"));
            String cn = request.getParameter("inn");
            Long inn = Long.valueOf(0);
            if(cn!=null) {
                inn = Long.parseLong(cn);}

            int licence = Integer.parseInt(request.getParameter("licence"));
            int stage = Integer.parseInt(request.getParameter("stage"));
            String category = request.getParameter("category");
            System.out.println(request.getParameter("personal_auto"));
            if(request.getParameter("personal_auto").contains("нет"))  {
            personal_auto = false; }
            else if(request.getParameter("personal_auto").contains("да")) {personal_auto = true;}

            int trip_num = Integer.parseInt(request.getParameter("trip_num"));

            Driver dr = new Driver(fio,pass_seria,pass_numb,inn,licence,stage,category,personal_auto,trip_num);
            impl.addDriver(dr);
            response.sendRedirect("driver");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            int id_driver = Integer.parseInt(request.getParameter("id_driver"));
            impl.deleteDriver(id_driver);
            response.sendRedirect("driver");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");

            int id_driver = Integer.parseInt(request.getParameter("id_driver"));
            String fio = request.getParameter("fio");
            int pass_seria = Integer.parseInt(request.getParameter("pass_seria"));
            int pass_numb = Integer.parseInt(request.getParameter("pass_numb"));
            Long inn = Long.parseLong(request.getParameter("inn"));
            int licence = Integer.parseInt(request.getParameter("licence"));
            int stage = Integer.parseInt(request.getParameter("stage"));
            String category = request.getParameter("category");
            Boolean personal_auto = Boolean.parseBoolean(request.getParameter("personal_auto"));
            int trip_num = Integer.parseInt(request.getParameter("trip_num"));

            Driver dr = new Driver(id_driver,fio,pass_seria,pass_numb,inn,licence,stage,category,personal_auto,trip_num);
            impl.updateDriver(id_driver, dr);
            response.sendRedirect("driver");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}