package com.example.todo_list_web.Factory.DAOFactory;

import com.example.todo_list_web.Model.DAO.AlertaDAO;
import com.example.todo_list_web.Model.DAO.GenericDAO;

public class AlertaDAOFactory {

    private final GenericDAO genericDAO = new GenericDAO();

    public AlertaDAO criaAlertaDAO() {
        return new AlertaDAO(genericDAO);
    }

}
