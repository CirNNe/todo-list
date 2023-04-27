package com.example.todo_list_web.Viewer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        TarefaViewer tarefaViewer = new TarefaViewer();
        AlertaViewer alertaViewer = new AlertaViewer();

        Scanner inputOpcao = new Scanner(System.in);
        int opcao;
        while(true) {
            System.out.println("-------------------- TODO LIST ------------------" + "\n" +
                    "## ALERTAS ##");
            alertaViewer.alertas();
            System.out.println("-------------------------------------------------");
            System.out.println("## MENU ##" + "\n" +
                    "1 - ADICIONAR TAREFA" + "\n" +
                    "2 - MOSTRAR LISTA DE TAREFAS" + "\n" +
                    "3 - FILTRAR UM TAREFA" + "\n" +
                    "4 - EDITAR TAREFA" + "\n" +
                    "5 - EXCLUIR UMA TAREFA" + "\n" +
                    "6 - ADICIONAR ALERTA" + "\n" +
                    "7 - EXCLUIR UM ALERTA" + "\n" +
                    "0 - SAIR" + "\n" +
                    "-------------------------------------------------");
            opcao = inputOpcao.nextInt();

            if(opcao == 1) {
                tarefaViewer.formularioCadastroTarefa();
            }

            else if(opcao == 2) {
                tarefaViewer.listaTarefas();
            }

            else if(opcao == 3) {
                tarefaViewer.tarefaUnica();
            }

            else if(opcao == 4) {
                tarefaViewer.formularioEdicaoTarefa();
            }

            else if(opcao == 5) {
                tarefaViewer.excluirTarefa();
            }

            else if(opcao == 6) {
                alertaViewer.formularioCadastroAlerta();
            }

            else if(opcao == 7) {
                alertaViewer.deletarAlerta();
            }

            else if(opcao == 0) {
                break;
            }
        }
    }
}
