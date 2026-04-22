package com.linguados.menu;

import com.linguados.desafio.DesafioController;
import com.linguados.progresso.ProgressoView;
import java.util.Scanner;

    public class MenuController {
        private Scanner scanner = new Scanner(System.in);

        public void exibirMenuPrincipal() {
            boolean sair = false;

            while (!sair) {
                System.out.println("\n===== 🌍 LINGUADOS - MENU PRINCIPAL =====");
                System.out.println("1. ⚔️ Ir para os Desafios");
                System.out.println("2. 📊 Ver Meu Progresso");
                System.out.println("3. 🚪 Sair do Jogo");
                System.out.print("Escolha uma opção: ");

                String opcao = scanner.nextLine();

                switch (opcao) {
                    case "1":
                        // Chama o módulo do Andreas
                        new DesafioController().iniciarModulo();
                        break;
                    case "2":
                        // Chama o SEU módulo de progresso
                        new ProgressoView().exibirMenuProgresso();
                        break;
                    case "3":
                        System.out.println("Até a próxima, Linguado!");
                        sair = true;
                        System.exit(0); // Fecha o programa
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }