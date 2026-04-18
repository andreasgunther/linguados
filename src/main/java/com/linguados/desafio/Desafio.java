package com.linguados.desafio;

public class Desafio {
    private int id;
    private String titulo;
    private String descricao;
    private int pontosXp;
    private String dificuldade;

    public Desafio() {}

    public Desafio(int id, String titulo, String descricao, int pontosXp, String dificuldade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontosXp = pontosXp;
        this.dificuldade = dificuldade;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getPontosXp() { return pontosXp; }
    public void setPontosXp(int pontosXp) { this.pontosXp = pontosXp; }

    public String getDificuldade() { return dificuldade; }
    public void setDificuldade(String dificuldade) { this.dificuldade = dificuldade; }

    @Override
    public String toString() {
        return String.format("[%s] %s - Recompensa: %d XP", dificuldade, titulo, pontosXp);
    }
}