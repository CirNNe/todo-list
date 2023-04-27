package com.example.todo_list_web.Factory.ServiceFactory;

import com.example.todo_list_web.Factory.DAOFactory.AlertaDAOFactory;
import com.example.todo_list_web.Factory.DAOFactory.TarefaDAOFactory;
import com.example.todo_list_web.Model.DAO.AlertaDAO;
import com.example.todo_list_web.Model.DAO.TarefaDAO;
import com.example.todo_list_web.Service.AlertaService;
import com.example.todo_list_web.Service.ValidatorService;

public class AlertaServiceFactory {

    private final TarefaDAO tarefaDAO = new TarefaDAOFactory().criaTarefaDAO();
    private final AlertaDAO alertaDAO = new AlertaDAOFactory().criaAlertaDAO();
    private final ValidatorService validatorService = new ValidatorService();

    public AlertaService criaAlertaService() {
        return new AlertaService(tarefaDAO, alertaDAO, validatorService);
    }

}
