package com.example.todo_list_web.Controller;

import com.example.todo_list_web.Factory.ServiceFactory.AlertaServiceFactory;
import com.example.todo_list_web.Model.Entidade.Alerta;
import com.example.todo_list_web.Service.AlertaService;

import java.util.List;

public class AlertaController {

    AlertaService alertaService = new AlertaServiceFactory().criaAlertaService();

    public void recebeDadosNovoAlerta(int idTarefa, Alerta alerta) throws Exception {
        alertaService.salvaAlerta(idTarefa, alerta);
    }

    public void apagaAlerta(int idAlerta) throws Exception {
        alertaService.excluiAlerta(idAlerta);
    }

    public List<Alerta> exibeAlertas() throws Exception {
        return alertaService.disparaAlertas();
    }
}
