package servlet.Client;

import dao.*;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/deleteClient")
public class DeleteClient  extends HttpServlet {

    private ClientImpl impl;
    private static String Index = "/client.jsp";
    public void init(ServletConfig servletConfig) {
        try {
            ClientDAO CL = new ClientDAO();
            impl = new ClientImpl(CL);
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
            int id_client = Integer.parseInt(request.getParameter("id_client"));
            impl.deleteClients(id_client);
            response.sendRedirect("client");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
