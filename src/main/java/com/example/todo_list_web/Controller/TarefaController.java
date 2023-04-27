package com.example.todo_list_web.Controller;

import com.example.todo_list_web.Factory.DAOFactory.TarefaDAOFactory;
import com.example.todo_list_web.Factory.ServiceFactory.TarefaServiceFactory;
import com.example.todo_list_web.Model.DAO.TarefaDAO;
import com.example.todo_list_web.Model.Entidade.Tarefa;
import com.example.todo_list_web.Service.TarefaService;

import java.util.List;

public class TarefaController {

    TarefaService tarefaService = new TarefaServiceFactory().criaTarefaService();
    TarefaDAO tarefaDAO = new TarefaDAOFactory().criaTarefaDAO();

    public void recebeDadosNovaTarefa(Tarefa tarefa) throws Exception {
        tarefaService.salvaTarefa(tarefa);
    }

    public List<Tarefa> exibeListaTarefas() throws Exception {
        return tarefaDAO.buscaListaTarefas();
    }

    public Tarefa exibeTarefa(int idTarefa) throws Exception {
        return tarefaDAO.buscaTarefaUnica(idTarefa);
    }

    public void recebeDadosTarefaEditada(int idTarefa, Tarefa tarefa) throws Exception {
        tarefaService.editaTarefa(idTarefa, tarefa);
    }

    public void deletaTarefa(int idTarefa) throws Exception {
        tarefaService.excluiTarefa(idTarefa);
    }

}
