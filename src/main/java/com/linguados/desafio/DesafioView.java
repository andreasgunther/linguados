package com.linguados.desafio;

import java.util.List;
import java.util.Scanner;

public class DesafioView {
    private Scanner scanner = new Scanner(System.in);

    // Exibe a lista de desafios de forma formatada
    public void mostrarListaDesafios(List<Desafio> desafios) {
        System.out.println("\n========================================");
        System.out.println("         DESAFIOS DISPONÍVEIS         ");
        System.out.println("========================================");

        if (desafios.isEmpty()) {
            System.out.println("Poxa, não há desafios no momento.");
        } else {
            for (Desafio d : desafios) {
                System.out.printf("[%d] %-20s | XP: %d | %s%n",
                        d.getId(), d.getTitulo(), d.getPontosXp(), d.getDificuldade());
            }
        }
        System.out.println("========================================\n");
    }

    // Exibe os detalhes de um único desafio.
    public void mostrarDetalhesDesafio(Desafio d) {
        if (d == null) {
            System.out.println("Desafio não encontrado!");
            return;
        }
        System.out.println("\n--- " + d.getTitulo().toUpperCase() + " ---");
        System.out.println("Dificuldade: " + d.getDificuldade());
        System.out.println("Recompensa:  " + d.getPontosXp() + " XP");
        System.out.println("\nDESCRIÇÃO:");
        System.out.println(d.getDescricao());
        System.out.println("\n----------------------------------------");
    }

    // Solicita ao usuário o ID do desafio que ele deseja ver/resolver.
    public int solicitarIdDesafio() {
        System.out.print("Digite o ID do desafio para ver detalhes (ou 0 para voltar): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}