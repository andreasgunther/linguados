package com.linguados.usuario;

public class Usuario {
	
	private int id;
	private String username;
	private String senha;

    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

	public Usuario(int id, String username, String senha) {
        this.id = id;
        this.username = username;
        this.senha = senha;
    }

    public int getId() { return id; }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }
}
