package com.example.todo_list_web.Model.Entidade;

public class Alerta {

    private int id;
    private String nomeTarefa;
    private String dataAlerta;

    public Alerta(String dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

    public Alerta(int id, String nomeTarefa, String dataAlerta) {
        this.id = id;
        this.nomeTarefa = nomeTarefa;
        this.dataAlerta = dataAlerta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(String dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

    @Override
    public String toString() {
        return "Tarefa: " + nomeTarefa + " - " +
                "Data do Alerta: " + dataAlerta;
    }
}
