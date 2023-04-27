package com.example.todo_list_web.Viewer;

import com.example.todo_list_web.Controller.TarefaController;
import com.example.todo_list_web.Model.Entidade.Tarefa;
import java.util.List;
import java.util.Scanner;

public class TarefaViewer {

    TarefaController tarefaController = new TarefaController();

    public void formularioCadastroTarefa() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("DIGITE O NOME DA TAREFA:");
        String nome = input.nextLine();

        System.out.println("DIGITE A CATEGORIA:");
        String categoria = input.nextLine();

        System.out.println("DIGITE O NIVEL DE PRIORIDADE (1-5):");
        int prioridade = Integer.parseInt(input.nextLine());

        System.out.println("DIGITE A DATA DE ENTREGA DA TAREFA (dd/MM/yyyy)");
        String data = input.nextLine();

        System.out.println("DIGITE O STATUS (Fazer, Fazendo, Feito):");
        String status = input.nextLine();

        tarefaController.recebeDadosNovaTarefa(new Tarefa(nome, categoria, prioridade, data, status));
    }

    public void listaTarefas() throws Exception {

        List<Tarefa> listaTarefas = tarefaController.exibeListaTarefas();
        for (Tarefa listaTarefa : listaTarefas) {
            System.out.println(listaTarefa);
        }
    }

    public void tarefaUnica() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("DIGITE O ID DA TAREFA");
        int idTarefa = input.nextInt();

        System.out.println(tarefaController.exibeTarefa(idTarefa));
    }

    public void formularioEdicaoTarefa() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("DIGITE O ID DA TAREFA:");
        int id = Integer.parseInt(input.nextLine());

        System.out.println("DIGITE O NOME DA TAREFA:");
        String nome = input.nextLine();

        System.out.println("DIGITE A CATEGORIA:");
        String categoria = input.nextLine();

        System.out.println("DIGITE O NIVEL DE PRIORIDADE (1-5):");
        int prioridade = Integer.parseInt(input.nextLine());

        System.out.println("DIGITE A DATA DE ENTREGA DA TAREFA (dd/MM/yyyy)");
        String data = input.nextLine();

        System.out.println("DIGITE O STATUS (Fazer, Fazendo, Feito):");
        String status = input.nextLine();

        Tarefa tarefa = new Tarefa(nome, categoria, prioridade, data, status);

        tarefaController.recebeDadosTarefaEditada(id, tarefa);
    }

    public void excluirTarefa() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("DIGITE O ID DA TAREFA");
        int idTarefa = input.nextInt();

        tarefaController.deletaTarefa(idTarefa);
    }
}
