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

@WebServlet("/deleteOperator")
public class DeleteOperator  extends HttpServlet {

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
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            int id_operator = Integer.parseInt(request.getParameter("id_operator"));
            impl.deleteOperator(id_operator);
            response.sendRedirect("operator");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
