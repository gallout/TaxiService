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

@WebServlet("/operator")
public class OperatorServlet extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=utf-8");
            List<Operator> operators = impl.getOperators();
            request.setAttribute("operators", operators);
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

            String fio = request.getParameter("fio");
            String address = request.getParameter("adress");
            String cn = request.getParameter("contact_num");
            Long contact_num = Long.valueOf(0);
            if(cn!=null) {
                contact_num = Long.parseLong(cn);}
            Operator op = new Operator(fio,address, contact_num);
            impl.addOperator(op);
            response.sendRedirect("operator");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
