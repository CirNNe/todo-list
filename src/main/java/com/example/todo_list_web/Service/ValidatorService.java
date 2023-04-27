package com.example.todo_list_web.Service;

import com.example.todo_list_web.Model.Entidade.Alerta;
import com.example.todo_list_web.Model.Entidade.Tarefa;

public class ValidatorService {
    public boolean validaNovaTarefa(Tarefa tarefa) {

        boolean validaPrioridade = tarefa.getPrioridade() >= 1 && tarefa.getPrioridade() <= 5;

        if(tarefa.getNome().matches("^[a-zA-Z0-9 ]+$") &&
                tarefa.getCategoria().matches("^[a-zA-Z0-9 ]+$") &&
                validaPrioridade &&
                tarefa.getDataFinal().matches("^(\\d{2})/(\\d{2})/(\\d{4})$")) {
            return true;
        } else {
            System.out.println("Dados inválidos, por favor, tente novamente!");
            return false;
        }
    }
    public boolean validaNovoAlerta(Alerta alerta) {

        if(alerta.getDataAlerta().matches("^(\\d{2})/(\\d{2})/(\\d{4})$")) {
            return true;
        } else {
            System.out.println("Dados inválidos, por favor, tente novamente!");
            return false;
        }
    }
}
