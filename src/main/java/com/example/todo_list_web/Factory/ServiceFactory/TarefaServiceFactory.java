package com.example.todo_list_web.Factory.ServiceFactory;

import com.example.todo_list_web.Factory.DAOFactory.TarefaDAOFactory;
import com.example.todo_list_web.Model.DAO.TarefaDAO;
import com.example.todo_list_web.Service.TarefaService;
import com.example.todo_list_web.Service.ValidatorService;

public class TarefaServiceFactory {
    private final ValidatorService validatorService = new ValidatorService();
    private final TarefaDAO tarefaDAO = new TarefaDAOFactory().criaTarefaDAO();

    public TarefaService criaTarefaService() {
        return new TarefaService(validatorService, tarefaDAO);
    }
}
