package com.example.todo_list_web.Model.DAO;

import com.example.todo_list_web.Model.Entidade.Tarefa;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TarefaDAO {

    GenericDAO genericDAO;

    public TarefaDAO(GenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public int buscaUltimoId(String arquivo) throws Exception {
        return genericDAO.buscaUltimoId(arquivo);
    }

    public void insereTarefa(Tarefa tarefa) throws Exception {

        String arquivo = "src/main/java/com/example/todo_list_web/Repository/tarefas.txt";
        File arquivoTxt = new File(arquivo);

        try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, true);
             BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)) {

            if(arquivoTxt.exists()) {
                int id = buscaUltimoId(arquivo);
                tarefa.setId(id);

                escreveTarefa.write( tarefa.getId() + " - " + tarefa.getNome() + " - " + tarefa.getCategoria() + " - " +
                        tarefa.getPrioridade() + " - " + tarefa.getDataFinal() + " - " + tarefa.getStatus() + "\n");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar inserir nova tarefa no banco de dados: " + e);
        }
    }

    public List<Tarefa> buscaListaTarefas() throws Exception {

        File arquivoTxt = new File("src/main/java/com/example/todo_list_web/Repository/tarefas.txt");

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)) {

            List<Tarefa> listaTarefas = new ArrayList<>();

            if (arquivoTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(" - ");
                    int id = Integer.parseInt(camposLinha[0]);
                    String nome = camposLinha[1];
                    String categoria = camposLinha[2];
                    int prioridade = Integer.parseInt(camposLinha[3]);
                    String dataFinal = camposLinha[4];
                    String status = camposLinha[5];

                    listaTarefas.add(new Tarefa(id, nome, categoria, prioridade, dataFinal, status));

                    linha = bufferedReader.readLine();
                }
            }
            return listaTarefas;
        } catch (Exception e) {
            throw new Exception("Erro ao tentar buscar lista de tarefas no banco de dados: " + e);
        }
    }

    public Tarefa buscaTarefaUnica(int idTarefa) throws Exception {

        File arquivoTxt = new File("src/main/java/com/example/todo_list_web/Repository/tarefas.txt");

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)) {

            List<Tarefa> tarefa = new ArrayList<>();

            if (arquivoTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(" - ");
                    int id = Integer.parseInt(camposLinha[0]);
                    String nome = camposLinha[1];
                    String categoria = camposLinha[2];
                    int prioridade = parseInt(camposLinha[3]);
                    String dataFinal = camposLinha[4];
                    String status = camposLinha[5];

                    if (id == (idTarefa)) {
                        tarefa.add(new Tarefa(id, nome, categoria, prioridade, dataFinal, status));
                    }
                    linha = bufferedReader.readLine();
                }
            }
            return tarefa.get(0);
        } catch (Exception e) {
            throw new Exception("Erro ao tentar buscar a tarefa no banco de dados: " + e);
        }
    }

    public void sobrescreveArquivoTarefas(List<Tarefa> listaTarefas) throws Exception {

        File arquivoTxt = new File("src/main/java/com/example/todo_list_web/Repository/tarefas.txt");

        try (FileWriter escreverArquivo = new FileWriter(arquivoTxt, false);
             BufferedWriter escreveTarefa = new BufferedWriter(escreverArquivo)) {

            if(arquivoTxt.exists()) {

                for(int posicao = 0; posicao < listaTarefas.size(); posicao++) {
                    listaTarefas.get(posicao).setId(posicao +1);

                    escreveTarefa.write( listaTarefas.get(posicao).getId() + " - " +
                                                listaTarefas.get(posicao).getNome() + " - " +
                                                    listaTarefas.get(posicao).getCategoria() + " - " +
                                                        listaTarefas.get(posicao).getPrioridade() + " - " +
                                                            listaTarefas.get(posicao).getDataFinal() + " - " +
                                                                listaTarefas.get(posicao).getStatus() + "\n");
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao tentar inserir nova tarefa no banco de dados: " + e);
        }
    }
}
