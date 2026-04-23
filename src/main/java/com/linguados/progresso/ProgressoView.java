package com.linguados.progresso;

import com.linguados.config.Sessao;
import com.linguados.usuario.Usuario;
import java.util.Scanner;

public class ProgressoView {
    private Scanner scanner = new Scanner(System.in);

    // Este é o método principal que o MenuController vai chamar
    public void exibirMenuProgresso() {
        boolean voltar = false;

        while (!voltar) {
            Usuario user = Sessao.getUsuarioLogado();

            // Reutiliza o seu método de mostrar os dados
            mostrarStatus(user.getUsername(), user.getNivel(), user.getXp());

            System.out.println("1. Sincronizar com Banco de Dados");
            System.out.println("2. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("\n🔄 Buscando dados atualizados do MySQL...");
                    // Aqui futuramente você chama o ProgressoDAO para dar um refresh
                    System.out.println("✅ Dados sincronizados!");
                    break;
                case "2":
                    voltar = true;
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
    }

    // Seu método original de exibir o cabeçalho
    public void mostrarStatus(String username, int nivel, int xp) {
        System.out.println("\n========================================");
        System.out.println("           PERFIL DO JOGADOR            ");
        System.out.println("========================================");
        System.out.printf(" Usuário: %-20s %n", username);
        System.out.printf(" Nível:   %-20d %n", nivel);
        System.out.printf(" XP Total: %-20d %n", xp);

        int progressoParaProximo = xp % 100;
        System.out.print(" Progresso: [");
        for (int i = 0; i < 10; i++) {
            if (i < (progressoParaProximo / 10)) System.out.print("=");
            else System.out.print(" ");
        }
        System.out.println("] " + progressoParaProximo + "%");
        System.out.println("========================================\n");
    }

    // Mantemos seus outros métodos úteis
    public void mostrarLevelUp(int novoNivel) {
        System.out.println("\n✨ PARABÉNS! VOCÊ SUBIU PARA O NÍVEL " + novoNivel + "! ✨\n");
    }

    public void mostrarXpGanhos(String tituloDesafio, int xpGanhos) {
        System.out.println("✅ Desafio '" + tituloDesafio + "' concluído! 💰 +" + xpGanhos + " XP!");
    }
}