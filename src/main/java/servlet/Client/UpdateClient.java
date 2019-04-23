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

@WebServlet("/updateClient")
public class UpdateClient  extends HttpServlet {

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

        int id_client = 0;
        String fio = "";
        String address = "";
        String cn = "";
        Long contact_num = 121270L;
        System.out.println(request.getParameter("id_client"));
        System.out.println(request.getParameter("fio") );
        System.out.println(request.getParameter("adress") );
        System.out.println(request.getParameter("contact_num"));
        try {
            if (request.getParameter("id_client") != null && request.getParameter("fio") != null &&
                    request.getParameter("adress") != null &&
                    request.getParameter("contact_num") != null) {
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");
                id_client = Integer.parseInt(request.getParameter("id_client"));
                fio = request.getParameter("fio");
                address = request.getParameter("adress");
                cn = request.getParameter("contact_num");
                if (cn != null) {
                    contact_num = Long.parseLong(cn);
                }

                Client cl = new Client(id_client, fio, address, contact_num);
                impl.updateClients(id_client, cl);
                response.sendRedirect("client");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
