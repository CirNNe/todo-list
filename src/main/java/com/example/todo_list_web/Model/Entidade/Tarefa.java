package com.example.todo_list_web.Model.Entidade;

public class Tarefa {

    private int id;
    private String nome;
    private String categoria;
    private int prioridade;
    private String dataFinal;
    private String status;
    private Alerta alerta;

    public Tarefa() {}

    public Tarefa(String nome, String categoria, int prioridade, String dataFinal, String status) { // Teste
        this.nome = nome;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.dataFinal = dataFinal;
        this.status = status;
    }

    public Tarefa(int id, String nome, String categoria, int prioridade, String dataFinal, String status) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.dataFinal = dataFinal;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " +
                "Nome: " + nome + " - " +
                "Categoria: " + categoria + " - " +
                "Prioridade: " + prioridade + " - " +
                "Data Final: " + dataFinal + " - " +
                "Status: " + status;
    }
}
