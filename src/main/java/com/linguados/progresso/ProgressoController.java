package com.linguados.progresso;

import com.linguados.config.Sessao;
import com.linguados.desafio.Desafio;
import com.linguados.usuario.Usuario;

public class ProgressoController {

    private ProgressoDAO dao = new ProgressoDAO();
    private ProgressoView view = new ProgressoView();

    public void concluirDesafio(Desafio desafio) {

        Usuario user = Sessao.getUsuarioLogado();

        // 1. Calcula o novo XP
        int novoXp = user.getXp() + desafio.getPontosXp();
        user.setXp(novoXp);

        // 2. Lógica de Level Up
        if (novoXp >= user.getNivel() * 100) {
            user.setNivel(user.getNivel() + 1);
            view.mostrarLevelUp(user.getNivel());
        }

        // 3. Salvar no banco (correto agora)
        dao.atualizarProgresso(user);

        // 4. Mostrar feedback
        view.mostrarXpGanhos(desafio.getTitulo(), desafio.getPontosXp());
    }
}