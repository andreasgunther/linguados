package com.linguados.progresso;

public class Progresso {
    private int idUsuario;
    private int xpAtual;
    private int nivelAtual;

    public Progresso(int idUsuario, int xpAtual, int nivelAtual) {
        this.xpAtual = xpAtual;
        this.nivelAtual = nivelAtual;
    }

    //METODOS
    void adicionarXp(int pontos) {
        this.xpAtual = xpAtual + pontos;
        this.nivelAtual = calcularNivel();
    }

    int calcularNivel() {
        return (xpAtual/100) + 1;
    }

    //GET E SET
    public int getXpAtual() {
        return xpAtual;
    }
    public int getNivelAtual() {
        return nivelAtual;
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setXpAtual(int xpAtual) {
        this.xpAtual = xpAtual;
    }
    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

}
