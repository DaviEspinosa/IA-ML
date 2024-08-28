package com.example.exemplosLeitura;

import java.util.Scanner;

public class LeituraTeclado {

    public void teste() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        
        System.out.println("Digite sua idade: ");
        String idade = sc.nextLine();

        System.out.println("Seu nome: " +nome+ "\nSua idade: " +idade);
    }

}
