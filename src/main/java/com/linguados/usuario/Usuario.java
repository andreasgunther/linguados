package com.linguados.usuario;

public class Usuario {
	
	private int id;
	private String username;
	private String senha;
    private int nivel;
    private int xp;


    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

	public Usuario(int id, String username, String senha) {
        this.id = id;
        this.username = username;
        this.senha = senha;
        this.nivel = 1;
        this.xp = 0;
    }

    public int getId() { return id; }

    public int getNivel() {
        return nivel;
    }

    public int getXp() {
        return xp;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }
}
