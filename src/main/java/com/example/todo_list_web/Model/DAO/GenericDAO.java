package com.example.todo_list_web.Model.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO {

    public int buscaUltimoId(String arquivo) throws Exception {

        File arquivoTxt = new File(arquivo);

        try (FileReader leitorArquivo = new FileReader(arquivoTxt);
             BufferedReader bufferedReader = new BufferedReader(leitorArquivo)) {

            List<Integer> listaId = new ArrayList<>();

            if (arquivoTxt.exists()) {
                String linha = bufferedReader.readLine();

                while (linha != null && !linha.isEmpty()) {

                    String[] camposLinha = linha.split(" - ");
                    int id = Integer.parseInt(camposLinha[0]);

                    listaId.add(id);

                    linha = bufferedReader.readLine();
                }
                if(listaId.size() >= 1) {
                    return listaId.get(listaId.size() -1) + 1;
                } else {
                    return 1;
                }
            }
            return 1;
        } catch (Exception e) {
            throw new Exception("Erro ao tentar buscar o id da ultima tarefa: " + e);
        }
    }
}
