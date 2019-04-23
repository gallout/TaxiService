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

@WebServlet("/updateDriver")
public class UpdateDriver  extends HttpServlet {

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
        int id_driver = 0;
        String fio = "";
        int pass_seria = 0;
        int pass_numb = 0;
        String innlong= "";
        Long inn = Long.valueOf(0);
        int licence = 0;
        int stage = 0;
        String category = "";
        Boolean personal_auto = false;
        int trip_num = 0;

        System.out.println(request.getParameter("id_driver"));
        System.out.println(request.getParameter("fio") );
        System.out.println(request.getParameter("pass_seria") );
        System.out.println(request.getParameter("pass_numb"));
        System.out.println(request.getParameter("inn"));
        System.out.println(request.getParameter("licence") );
        System.out.println(request.getParameter("stage") );
        System.out.println(request.getParameter("category"));
        System.out.println(request.getParameter("personal_auto") );
        System.out.println(request.getParameter("trip_num") );
        try {
            if (request.getParameter("id_driver") != null && request.getParameter("fio") != null &&
                    request.getParameter("pass_seria") != null &&
                    request.getParameter("pass_numb") != null && request.getParameter("inn") != null &&
                    request.getParameter("licence") != null && request.getParameter("stage") != null
                    && request.getParameter("category") != null && request.getParameter("personal_auto") != null
                    && request.getParameter("trip_num") != null) {

                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");

                id_driver = Integer.parseInt(request.getParameter("id_driver"));
                fio = request.getParameter("fio");
                pass_seria = Integer.parseInt(request.getParameter("pass_seria"));
                pass_numb = Integer.parseInt(request.getParameter("pass_numb"));

                innlong = request.getParameter("inn");
                if (innlong != null) {
                    inn = Long.parseLong(innlong);
                }
                licence = Integer.parseInt(request.getParameter("licence"));
                stage = Integer.parseInt(request.getParameter("stage"));
                category = request.getParameter("category");
                if(request.getParameter("personal_auto").contains("нет"))  {
                    personal_auto = false; }
                else if(request.getParameter("personal_auto").contains("да")) {personal_auto = true;}
                trip_num = Integer.parseInt(request.getParameter("trip_num"));

                Driver dr = new Driver(id_driver,fio,pass_seria,pass_numb,inn,licence,stage,category,personal_auto,trip_num);
                impl.updateDriver(id_driver, dr);
                response.sendRedirect("driver");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
