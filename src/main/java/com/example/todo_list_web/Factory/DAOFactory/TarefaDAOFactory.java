package com.example.todo_list_web.Factory.DAOFactory;

import com.example.todo_list_web.Model.DAO.GenericDAO;
import com.example.todo_list_web.Model.DAO.TarefaDAO;

public class TarefaDAOFactory {

    private final GenericDAO genericDAO = new GenericDAO();

    public TarefaDAO criaTarefaDAO() {
        return new TarefaDAO(genericDAO);
    }

}
