package com.linguados.progresso;

import com.linguados.config.Sessao;
import com.linguados.usuario.Usuario;
import com.linguados.desafio.Desafio;

public class ProgressoController {
    private ProgressoDAO progressoDAO;

    public ProgressoController() {
        this.progressoDAO = new ProgressoDAO();
    }

    /**
     * Método principal: registra que o usuário concluiu um desafio
     * e atualiza o XP dele no banco de dados.
     */
    public void concluirDesafio(Desafio desafio) {
        // 1. Descobre quem é o usuário atual via Sessão
        Usuario usuarioAtual = Sessao.getUsuarioLogado();

        if (usuarioAtual == null) {
            System.out.println("Erro: Nenhum usuário logado para registrar progresso.");
            return;
        }

        // 2. Busca o objeto de Progresso desse usuário no banco
        Progresso p = progressoDAO.buscarPorUsuario(usuarioAtual.getId());

        if (p != null) {
            // 3. Lógica do seu diagrama: adiciona o XP e calcula o nível
            int xpGanho = desafio.getPontosXp();
            p.adicionarXp(xpGanho);

            // 4. Salva o histórico da conclusão (tabela progresso do seu SQL)
            progressoDAO.registrarHistoricoConclusao(usuarioAtual.getId(), desafio.getId());

            // 5. Atualiza o XP total e nível (na tabela usuario ou progresso, conforme seu DAO)
            progressoDAO.atualizarStatusProgresso(p);

            System.out.println("\n----------------------------------------");
            System.out.println("🎉 DESAFIO CONCLUÍDO!");
            System.out.println("Você ganhou " + xpGanho + " XP!");
            System.out.println("Nível Atual: " + p.getNivelAtual());
            System.out.println("----------------------------------------\n");
        }
    }

    // Método para ser usado na tela de Perfil
    public void exibirStatus() {
        Usuario u = Sessao.getUsuarioLogado();
        if (u != null) {
            Progresso p = progressoDAO.buscarPorUsuario(u.getId());
            System.out.println("Jogador: " + u.getUsername());
            System.out.println("Nível: " + p.getNivelAtual() + " | XP: " + p.getXpAtual());
        }
    }
}
