package com.linguados.usuario;

import java.util.Scanner;

public class LoginView {
    public void inicializar() {
        Scanner sc = new Scanner(System.in);
        LoginController controller = new LoginController();

        int x=1;
        while (x != 0) {
            System.out.println("=======================");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");
            System.out.println("=======================");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                	System.out.println("=======================");
                    System.out.println("    C A D A S T R O    ");
                    System.out.println("=======================");
                    
                    System.out.print("Digite seu Usuario: ");
                    String userC = sc.next();
                    
                    System.out.print("\nDigite sua Senha: ");
                    String senhaC = sc.next();
                    
                    System.out.print("\nConfirme sua Senha: ");
                    String senha1 = sc.next();
                    
                    if (senhaC.equals(senha1)) {
                    	controller.cadastrar(userC, senhaC);
                    } else {
                    	System.out.print("\nAs senhas nao correspondem");
                    	System.out.println("Tente Novamente!");
                    	break;
                    }
                    
                    break;
                
                case 2:
                	System.out.println("=======================");
                    System.out.println("       L O G I N       ");
                    System.out.println("=======================");
                    
                    System.out.print("Digite seu Usuario: ");
                    String userL = sc.next();
                    
                    System.out.print("\nDigite sua Senha: ");
                    String senhaL = sc.next();

                    Usuario logado = controller.login(userL, senhaL);

                    if (logado != null) {
                        com.linguados.config.Sessao.setUsuarioLogado(logado);
                        System.out.println("Entrou Papito");
                        x = 0; // Vai para o jogo
                    } else {
                        System.out.println("Deu Ruim!");
                    }
                    break;
                    
                case 0:
                    x = 0;
                    break;
                    
                default:
                    break;
            }
        }
    }
}
