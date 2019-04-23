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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/deleteOrder")
public class DeleteOrder  extends HttpServlet {

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
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            int id_order = Integer.parseInt(request.getParameter("id_order"));
            impl.deleteOrder(id_order);
            response.sendRedirect("order");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
