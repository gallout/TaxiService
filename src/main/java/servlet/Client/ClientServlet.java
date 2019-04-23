package servlet.Client;

import dao.*;
import dao.impl.ClientImpl;
import entity.Client;

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

@WebServlet("/client")
public class ClientServlet  extends HttpServlet {

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
            //response.setContentType("text/html;charset=utf-8");
            List<Client> clients = impl.getClients();
            request.setAttribute("clients", clients);
            RequestDispatcher dispatcher = request.getRequestDispatcher("client.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            //int id_client = Integer.parseInt(request.getParameter("id_client"));
            String fio = request.getParameter("fio");
            String address = request.getParameter("adress");

            String cn = request.getParameter("contact_num");
            Long contact_num = Long.valueOf(0);
            if(cn!=null) {
                contact_num = Long.parseLong(cn);
            }

            Client cl = new Client(fio,address,contact_num);
            impl.addClients(cl);
            response.sendRedirect("client");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            int id_client = Integer.parseInt(request.getParameter("id_client"));
            impl.deleteClients(id_client);
            response.sendRedirect("client");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");

            int id_client = Integer.parseInt(request.getParameter("id_client"));
            String fio = request.getParameter("fio");
            String address = request.getParameter("adress");

            String cn = request.getParameter("contact_num");
            Long contact_num = Long.valueOf(0);
            if(cn!=null) {
                contact_num = Long.parseLong(cn);}

            Client cl = new Client(id_client,fio,address,contact_num);
            impl.updateClients(id_client, cl);
            response.sendRedirect("client");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
