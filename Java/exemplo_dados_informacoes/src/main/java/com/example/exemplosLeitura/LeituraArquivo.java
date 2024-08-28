package com.example.exemplosLeitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {

    public void teste(){
        // BufferedReader - Lê texto de um Reader de maneira eficiente, armazenando em buffer.
        // FileReader -  Usado para ler o conteúdo de um arquivo como uma sequência de caracteres.
        try (BufferedReader br = new BufferedReader(new FileReader("dados.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
