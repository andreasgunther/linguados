package com.linguados.desafio;

import java.util.List;

public class DesafioController {
    private DesafioDAO desafioDAO;
    private DesafioView desafioView;

    public DesafioController() {
        this.desafioDAO = new DesafioDAO();
        this.desafioView = new DesafioView();
    }

    public void iniciarModulo() {
        boolean voltando = false;
        while (!voltando) {
            List<Desafio> lista = desafioDAO.listarTodos();
            desafioView.mostrarListaDesafios(lista);

            int idEscolhido = desafioView.solicitarIdDesafio();

            if (idEscolhido == 0) {
                voltando = true;
            } else if (idEscolhido > 0) {
                Desafio detalhe = desafioDAO.buscarPorId(idEscolhido);
                desafioView.mostrarDetalhesDesafio(detalhe);

                // --- SEU NOVO EXEMPLO DE CONCLUSÃO ---
                System.out.println("\n[S] Resolver Desafio | [N] Voltar");
                String acao = new java.util.Scanner(System.in).nextLine();

                if (acao.equalsIgnoreCase("S")) {
                    System.out.println("Simulando resolução... Concluiu com sucesso!");

                    // Instancia o seu controller e entrega o XP!
                    com.linguados.progresso.ProgressoController progressoCtrl = new com.linguados.progresso.ProgressoController();
                    progressoCtrl.concluirDesafio(detalhe);
                }
                // ---------------------------------------

            } else {
                desafioView.mostrarMensagem("Opção inválida! Tente novamente.");
            }
        }
    }
}