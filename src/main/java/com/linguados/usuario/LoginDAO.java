package com.linguados.usuario;

import com.linguados.config.DatabaseConfig;
import com.linguados.progresso.ProgressoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {

    public void cadastrar(Usuario usuario) {

        String sql = "INSERT INTO usuario (username, senha) VALUES (?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getSenha());

            stmt.execute();

			// Aqui pegamos o ID que o MySQL acabou de criar
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int idGerado = rs.getInt(1);

				// Agora chamamos o SEU método para criar o registro de XP 0
				ProgressoDAO progressoDAO = new ProgressoDAO();
				progressoDAO.criarProgressoInicial(idGerado);
				System.out.println("Usuário cadastrado!");
			}

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