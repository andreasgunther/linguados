package com.linguados.usuario;

import com.linguados.config.DatabaseConfig;
import com.linguados.progresso.ProgressoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class LoginDAO {

    public void cadastrar(Usuario usuario) {

        String sql = "INSERT INTO usuario (username, senha) VALUES (?, ?)";

		try (Connection conn = DatabaseConfig.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // <--- AVISO ADICIONADO!

			stmt.setString(1, usuario.getUsername());
			stmt.setString(2, usuario.getSenha());

			stmt.executeUpdate();

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

	public Usuario login(String username, String senha) {
		String sql = "SELECT * FROM usuario WHERE username=? AND senha=?";

		try (Connection conn = DatabaseConfig.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, username);
			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// 1. Primeiro cria o objeto
				Usuario user = new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("senha"));

				// 2. Depois preenche os dados que vêm do banco (Docker)
				user.setXp(rs.getInt("xp"));
				user.setNivel(rs.getInt("nivel"));

				// 3. Só agora retorna o usuário completo
				return user;
			}

		} catch (Exception e) {
			System.out.println("Erro login: " + e.getMessage());
		}
		return null;
	}
}