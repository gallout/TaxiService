package servlet.Driver;

import dao.*;
import dao.impl.ClientImpl;
import dao.impl.DriverImpl;
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

@WebServlet("/deleteDriver")
public class DeleteDriver  extends HttpServlet {

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
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            int id_driver = Integer.parseInt(request.getParameter("id_driver"));
            impl.deleteDriver(id_driver);
            response.sendRedirect("driver");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
