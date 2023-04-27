package com.example.todo_list_web.Model.DAO;

import com.example.todo_list_web.Model.Entidade.Alerta;
import com.example.todo_list_web.Model.Entidade.Tarefa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AlertaDAO {

    GenericDAO genericDAO;

    public AlertaDAO(GenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public int buscaUltimoId(String arquivo) throws Exception {
        return genericDAO.buscaUltimoId(arquivo);
    }

    public void insereAlerta(Alerta alerta) throws Exception {

        String arquivo = "src/main/java/com/example/todo_list_web/Repository/alertas.txt";
        File arquivoTxt = new File(arquivo);

        try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, true);
             BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)) {

            if(arquivoTxt.exists()) {
                int id = buscaUltimoId(arquivo);
                alerta.setId(id);

                escreveTarefa.write(alerta.getId() + " - " +
                                            alerta.getNomeTarefa() + " - " +
                                                alerta.getDataAlerta() + "\n");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar inserir nova tarefa no banco de dados: " + e);
        }
    }

    public List<Alerta> buscaListaAlertas() throws Exception {

        File arquivoTxt = new File("src/main/java/com/example/todo_list_web/Repository/alertas.txt");

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)) {

            List<Alerta> listaAlertas = new ArrayList<>();

            if (arquivoTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(" - ");
                    int id = Integer.parseInt(camposLinha[0]);
                    String nomeTarefa = camposLinha[1];
                    String dataAlerta = camposLinha[2];

                    listaAlertas.add(new Alerta(id, nomeTarefa, dataAlerta));

                    linha = bufferedReader.readLine();
                }
            }
            return listaAlertas;
        } catch (Exception e) {
            throw new Exception("Erro ao tentar buscar lista de tarefas no banco de dados: " + e);
        }

    }

    public Alerta buscaAlertaUnico(int idAlerta) throws Exception {

        File arquivoTxt = new File("src/main/java/com/example/todo_list_web/Repository/alertas.txt");

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)) {

            List<Alerta> alerta = new ArrayList<>();

            if (arquivoTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(" - ");
                    int id = Integer.parseInt(camposLinha[0]);
                    String nomeTarefa = camposLinha[1];
                    String dataAlerta = camposLinha[2];

                    if (id == (idAlerta)) {
                        alerta.add(new Alerta(id, nomeTarefa, dataAlerta));
                    }
                    linha = bufferedReader.readLine();
                }
            }
            return alerta.get(0);
        } catch (Exception e) {
            throw new Exception("Erro ao tentar buscar a tarefa no banco de dados: " + e);
        }

    }

    public void sobreescreveArquivoAlerta(List<Alerta> listaAlertas) throws Exception {

        File arquivoTxt = new File("src/main/java/com/example/todo_list_web/Repository/alertas.txt");

        try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, false);
             BufferedWriter escreveAlerta = new BufferedWriter(escreverArquivo)) {

            if(arquivoTxt.exists()) {

                for(int posicao = 0; posicao < listaAlertas.size(); posicao++) {
                    listaAlertas.get(posicao).setId(posicao +1);

                    escreveAlerta.write( listaAlertas.get(posicao).getId() + " - " +
                                                listaAlertas.get(posicao).getNomeTarefa() + " - " +
                                                    listaAlertas.get(posicao).getDataAlerta() + "\n");
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar inserir nova tarefa no banco de dados: " + e);
        }

    }
}
