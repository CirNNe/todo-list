package com.example.todo_list_web.Service;

import com.example.todo_list_web.Model.DAO.TarefaDAO;
import com.example.todo_list_web.Model.Entidade.Tarefa;

import java.util.List;

public class TarefaService {

    ValidatorService validatorService;
    TarefaDAO tarefaDAO;

    public TarefaService(ValidatorService validatorService, TarefaDAO tarefaDAO) {
        this.validatorService = validatorService;
        this.tarefaDAO = tarefaDAO;
    }

    public boolean salvaTarefa(Tarefa tarefa) throws Exception {
        try {
            if(validatorService.validaNovaTarefa(tarefa)){
                tarefaDAO.insereTarefa(tarefa);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar salvar nova tarefa: " + e);
        }
    }

    public boolean editaTarefa(int idTarefa, Tarefa tarefaEditada) throws Exception {
        try {
            if(validatorService.validaNovaTarefa(tarefaEditada)) {
                List<Tarefa> listaTarefas = tarefaDAO.buscaListaTarefas();

                for(Tarefa tarefa : listaTarefas) {
                    if(tarefa.getId() == idTarefa) {
                        tarefa.setNome(tarefaEditada.getNome());
                        tarefa.setCategoria(tarefaEditada.getCategoria());
                        tarefa.setPrioridade(tarefaEditada.getPrioridade());
                        tarefa.setDataFinal(tarefaEditada.getDataFinal());
                        tarefa.setStatus(tarefaEditada.getStatus());
                    }
                }
                tarefaDAO.sobrescreveArquivoTarefas(listaTarefas);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar editar a tarefa: " + e);
        }
    }

    public boolean excluiTarefa(int idTarefa) throws Exception {
        try {
            if(tarefaDAO.buscaTarefaUnica(idTarefa).getId() == idTarefa) {
                List<Tarefa> listaTarefas = tarefaDAO.buscaListaTarefas();

                for(Tarefa tarefa : listaTarefas) {
                    if(tarefa.getId() == idTarefa) {
                        listaTarefas.remove(tarefa);
                        break;
                    }
                }
                tarefaDAO.sobrescreveArquivoTarefas(listaTarefas);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar excluir a tarefa: " + e);
        }
    }
}
