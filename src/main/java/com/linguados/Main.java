package com.linguados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        System.out.println("\n--- BEM VINDO AO LINGUADOS CLI ---");

        while (rodando) {
            System.out.println("\n[1] Testar Conexão Banco");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            if (opcao.equals("0")) {
                rodando = false;
                System.out.println("Tchau! 🦆");
            } else if (opcao.equals("1")) {
                System.out.println("✅ O banco continua conectado!");
            } else {
                System.out.println("❌ Opção inválida!");
            }
        }
    }
}