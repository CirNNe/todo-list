package com.example.todo_list_web.Service;

import com.example.todo_list_web.Model.DAO.AlertaDAO;
import com.example.todo_list_web.Model.DAO.TarefaDAO;
import com.example.todo_list_web.Model.Entidade.Alerta;
import com.example.todo_list_web.Model.Entidade.Tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AlertaService {

    TarefaDAO tarefaDAO;
    AlertaDAO alertaDAO;
    ValidatorService validatorService;

    public AlertaService(TarefaDAO tarefaDAO, AlertaDAO alertaDAO, ValidatorService validatorService) {
        this.tarefaDAO = tarefaDAO;
        this.alertaDAO = alertaDAO;
        this.validatorService = validatorService;
    }

    public boolean salvaAlerta(int idTarefa, Alerta alerta) throws Exception {
        try {
            if(validatorService.validaNovoAlerta(alerta)) {
                Tarefa tarefa = tarefaDAO.buscaTarefaUnica(idTarefa);

                alerta.setNomeTarefa(tarefa.getNome());

                alertaDAO.insereAlerta(alerta);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar salvar o alerta: " + e);
        }
    }

    public boolean excluiAlerta(int idAlerta) throws Exception {
        try {
            if(alertaDAO.buscaAlertaUnico(idAlerta).getId() == idAlerta) {
                List<Alerta> listaAlertas = alertaDAO.buscaListaAlertas();

                for(Alerta alerta : listaAlertas) {
                    if(alerta.getId() == idAlerta) {
                        listaAlertas.remove(alerta);
                        break;
                    }
                }
                alertaDAO.sobreescreveArquivoAlerta(listaAlertas);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar excluir a tarefa: " + e);
        }
    }

    public List<Alerta> recebeListAlertas() throws Exception {
        try {
            return alertaDAO.buscaListaAlertas();
        } catch (Exception e) {
            throw new Exception("Erro ao tentar disparar os alertas: " + e);
        }
    }

    public List<Alerta> disparaAlertas() throws Exception {
        try {
            List<Alerta> listaAlertas = recebeListAlertas();
            List<Alerta> alertasDisparar = new ArrayList<>();

            LocalDate dataAtual = LocalDate.now();

            for(Alerta alerta : listaAlertas) {
                LocalDate dataAlerta = LocalDate.parse(alerta.getDataAlerta(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if(dataAlerta.equals(dataAtual)) {
                    alertasDisparar.add(alerta);
                }
            }
            return alertasDisparar;
        } catch (Exception e) {
            throw new Exception("Erro ao tentar disparar os alertas: " + e);
        }
    }
}
