package com.example.exercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.example.exercicios.Aluno;

public class ExerciciosLeitura {

    // Arquivos de entrada e saída
    String inputFile = "alunosNota.txt";
    String outputFile = "resultados.txt";

    // Lista para armazenar os alunos e suas médias
    List<Aluno> alunos = new ArrayList<>();
    double somaTotalNotas = 0; // Soma total das médias de todos os alunos
    int totalAlunos = 0; // Contador de alunos

    public void exercicio1corrigido() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length < 2) {
                    System.err.println("Linha com formato errado");
                    continue;
                }
                String nome = partes[0];
                double somaNotas = 0;
                int numeroNotas = 0;
                try {
                    for (int i = 1; i < partes.length; i++) {
                        somaNotas += Double.parseDouble(partes[i]);
                        numeroNotas++;
                    }
                } catch (NumberFormatException e) {
                    somaNotas += 0;
                }

                double media = somaNotas / numeroNotas;
                alunos.add(new Aluno(nome, media));

                somaTotalNotas += media;
                totalAlunos++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Aluno alunoMaoirNota = alunos.get(0);
        Aluno alunoMenorNota = alunos.get(0);

        for (Aluno aluno : alunos) {
            if (aluno.getMedia() > alunoMaoirNota.getMedia()) {
                alunoMaoirNota = aluno;
            }
            if (aluno.getMedia() > alunoMenorNota.getMedia()) {
                alunoMenorNota = aluno;
            }
        }
        double mediaGeralTurma = somaTotalNotas / totalAlunos;

        System.out.println("Aluno com maior nota" + alunoMaoirNota.getNome() + "- Media" + alunoMaoirNota.getMedia());
        System.out.println("Aluno com menor nota" + alunoMenorNota.getNome() + "- Media" + alunoMenorNota.getMedia());

        System.out.println("Media geral da turma" + mediaGeralTurma);
    }



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

    public static void main(String[] args) {
        System.out.println();
        new ExerciciosLeitura().exercicio1();
    }
}
