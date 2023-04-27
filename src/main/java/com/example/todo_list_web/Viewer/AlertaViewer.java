package com.example.todo_list_web.Viewer;

import com.example.todo_list_web.Controller.AlertaController;
import com.example.todo_list_web.Model.Entidade.Alerta;

import java.util.List;
import java.util.Scanner;

public class AlertaViewer {

    AlertaController alertaController = new AlertaController();

    public void formularioCadastroAlerta() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("DIGITE O ID DA TAREFA");
        int idTarefa = Integer.parseInt(input.nextLine());

        System.out.println("DIGITE A DATA DO ALARME (dd/MM/yyyy)");
        String dataAlarme = input.nextLine();

        Alerta alerta = new Alerta(dataAlarme);

        alertaController.recebeDadosNovoAlerta(idTarefa, alerta);
    }

    public void deletarAlerta() throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("DIGITE O ID DO ALERTA");
        int idAlerta = input.nextInt();

        alertaController.apagaAlerta(idAlerta);
    }

    public void alertas() throws Exception {
        List<Alerta> listaAlertas = alertaController.exibeAlertas();

        for(Alerta alerta : listaAlertas) {
            System.out.println(alerta);
        }
    }

}
