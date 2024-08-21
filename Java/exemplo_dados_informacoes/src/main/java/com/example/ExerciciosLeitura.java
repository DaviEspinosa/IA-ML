package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExerciciosLeitura {

    public void exercicio1() {
        String alunoComMaiorNota = null;
        double maiorNota = Double.MIN_VALUE; // Inicia com o menor valor possível
        String alunoComMenorNota = null;
        double menorNota = Double.MAX_VALUE; // Iniciaa com o maior valor possível
        
        // cálculo da média geral da turma
        double somaNotas = 0;
        int totalNotas = 0;
        int totalAlunos = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("exercicio1.txt"))) {
            String linha;
            
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                // PEga o nome do aluno
                String nomeDoAluno = partes[0];
                
                double nota1 = Double.parseDouble(partes[1]);
                double nota2 = Double.parseDouble(partes[2]);
                double nota3 = Double.parseDouble(partes[3]);

                double media = (nota1 + nota2 + nota3) / 3;

                // aluno com a maior nota
                if (media > maiorNota) {
                    maiorNota = media;
                    alunoComMaiorNota = nomeDoAluno;
                }

                // aluno com a menor nota
                if (media < menorNota) {
                    menorNota = media;
                    alunoComMenorNota = nomeDoAluno;
                }

                // calcular a média geral da turma
                somaNotas += nota1 + nota2 + nota3;
                totalNotas += 3; // Cada aluno tem 3 notas
                totalAlunos++;
            }
            
            // média geral da turma
            double mediaGeral = (totalNotas > 0) ? somaNotas / totalNotas : 0;

            // Exibe o aluno com a maior nota
            if (alunoComMaiorNota != null) {
                System.out.println("Aluno com a nota mais alta: " + alunoComMaiorNota + " com nota " + maiorNota);
            } else {
                System.out.println("Nenhum aluno encontrado.");
            }

            // Exibe o aluno com a menor nota
            if (alunoComMenorNota != null) {
                System.out.println("Aluno com a nota mais baixa: " + alunoComMenorNota + " com nota " + menorNota);
            }

            // Exibe a média geral da turma
            System.out.println("Média geral da turma: " + mediaGeral);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exercicio2(){

    }
}
