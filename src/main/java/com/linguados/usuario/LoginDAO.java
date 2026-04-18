package com.linguados.usuario;

import com.linguados.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginDAO {

    public void cadastrar(Usuario usuario) {

        String sql = "INSERT INTO usuario (username, senha) VALUES (?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getSenha());

            stmt.execute();
            System.out.println("Usuário cadastrado!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
	public boolean login(String username, String senha) {
	
	    String sql = "SELECT * FROM usuario WHERE username=? AND senha=?";
	
	    try (Connection conn = DatabaseConfig.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	        stmt.setString(1, username);
	        stmt.setString(2, senha);
	
	        var rs = stmt.executeQuery();
	
	        return rs.next();
	
	    } catch (Exception e) {
	        System.out.println("Erro login: " + e.getMessage());
	        return false;
	    }
	}
}