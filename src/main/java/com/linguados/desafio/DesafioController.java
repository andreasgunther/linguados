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
                desafioView.mostrarMensagem("\nPressione ENTER para voltar à lista...");
                new java.util.Scanner(System.in).nextLine();
            } else {
                desafioView.mostrarMensagem("Opção inválida! Tente novamente.");
            }
        }
    }
}