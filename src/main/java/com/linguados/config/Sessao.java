package com.linguados.config;

import com.linguados.usuario.Usuario;

public class Sessao {
    // Variável estática que guarda o usuário logado no sistema todo
    private static Usuario usuarioLogado;

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void encerrarSessao() {
        usuarioLogado = null;
    }
}
