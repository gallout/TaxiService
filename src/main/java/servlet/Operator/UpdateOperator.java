package servlet.Operator;

import dao.*;
import dao.impl.ClientImpl;
import dao.impl.OperatorImpl;
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

@WebServlet("/updateOperator")
public class UpdateOperator extends HttpServlet {

    private OperatorImpl impl;
    private static String Index = "/operator.jsp";
    public void init(ServletConfig servletConfig) {
        try {
            OperatorDAO CL = new OperatorDAO();
            impl = new OperatorImpl(CL);
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_operator = 0;
        String fio = "";
        String adress = "";
        String cn = "";
        Long contact_num = 121270L;
        System.out.println(request.getParameter("id_operator"));
        System.out.println(request.getParameter("fio") );
        System.out.println(request.getParameter("adress") );
        System.out.println(request.getParameter("contact_num"));
        try {
            if (request.getParameter("id_operator") != null && request.getParameter("fio") != null &&
                    request.getParameter("adress") != null &&
                    request.getParameter("contact_num") != null) {
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");
                id_operator = Integer.parseInt(request.getParameter("id_operator"));
                fio = request.getParameter("fio");
                adress = request.getParameter("adress");
                cn = request.getParameter("contact_num");
                if (cn != null) {
                    contact_num = Long.parseLong(cn);
                }

                Operator op = new Operator(id_operator, fio, adress, contact_num);
                impl.updateOperator(id_operator, op);
                response.sendRedirect("operator");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

