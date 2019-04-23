package dao.impl;

import dao.OperatorDAO;
import entity.Operator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OperatorImpl {
    OperatorDAO operators;

    public OperatorImpl(OperatorDAO operator) {
        operators = operator;
    }
    public List<Operator> getOperators() throws SQLException, IOException {
        return operators.read();
    }

    public void addOperator(Operator operator) throws SQLException, IOException {
        operators.create(operator);
    }

    public void updateOperator(int id_operator, Operator operator) throws SQLException, IOException {
        operators.update(id_operator, operator);
    }

    public void deleteOperator(int id_operator) throws SQLException, IOException {
        operators.delete(id_operator);
    }
}
