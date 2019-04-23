package servlet.Order;

import dao.*;
import dao.impl.ClientImpl;
import dao.impl.OrderImpl;
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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@WebServlet("/updateOrder")
public class UpdateOrder  extends HttpServlet {

    private OrderImpl impl;
    private static String Index = "/order.jsp";
    public void init(ServletConfig servletConfig) {
        try {
            OrderDAO OR = new OrderDAO();
            impl = new OrderImpl(OR);
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_order = 0;
        Date order_get_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Time order_get_time = new java.sql.Time(24);;
        Date order_set_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Time order_set_time = new java.sql.Time(24);
        String departure_point= "";
        String destination_point = "";
        String order_status  = "";
        int order_price =0 ;

        System.out.println(request.getParameter("id_order"));
        System.out.println(request.getParameter("order_get_date") );
        System.out.println(request.getParameter("order_get_time") );
        System.out.println(request.getParameter("order_set_date"));
        System.out.println(request.getParameter("order_set_time"));
        System.out.println(request.getParameter("departure_point") );
        System.out.println(request.getParameter("destination_point") );
        System.out.println(request.getParameter("order_status"));
        System.out.println(request.getParameter("order_price"));
        try {
            if (request.getParameter("id_order") != null && request.getParameter("order_get_date") != null &&
                    request.getParameter("order_get_time") != null &&
                    request.getParameter("order_set_date") != null && request.getParameter("order_set_time") != null &&
                    request.getParameter("departure_point") != null && request.getParameter("destination_point") != null
                    && request.getParameter("order_status") != null && request.getParameter("order_price") != null) {

                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");
                id_order = Integer.parseInt(request.getParameter("id_order"));
                order_get_date  = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                order_set_date  = new java.sql.Date(Calendar.getInstance().getTime().getTime());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date ogd = sdf.parse(request.getParameter("order_get_date"));
                order_get_date = new Date(Calendar.getInstance().getTime().getTime());
                if (ogd!=null) {
                    order_get_date = new Date(ogd.getTime());
                }

                SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // 12 hour format
                java.util.Date d1 =(java.util.Date)format.parse(request.getParameter("order_get_time"));
                 order_get_time = new java.sql.Time(d1.getTime());


                java.util.Date osd = sdf.parse(request.getParameter("order_set_date"));
                order_set_date = new Date(Calendar.getInstance().getTime().getTime());
                if (osd!=null) {
                    order_set_date = new Date(osd.getTime());
                }

                java.util.Date d2 =(java.util.Date)format.parse(request.getParameter("order_set_time"));
                order_set_time = new java.sql.Time(d2.getTime());

                departure_point = request.getParameter("departure_point");
                destination_point = request.getParameter("destination_point");
                order_status = request.getParameter("order_status");
                order_price = Integer.parseInt(request.getParameter("order_price"));

                Order ord = new Order(id_order,order_get_date,order_get_time,order_set_date,order_set_time,departure_point,
                        destination_point,order_status,order_price);
                impl.updateOrder(id_order, ord);
                response.sendRedirect("order");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
