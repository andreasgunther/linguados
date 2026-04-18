package com.linguados.desafio;

import com.linguados.config.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesafioDAO {

    // Busca todos os desafios cadastrados no banco de dados
    // @return Uma lista de objetos Desafio
    public List<Desafio> listarTodos() {
        List<Desafio> desafios = new ArrayList<>();
        String sql = "SELECT * FROM desafio";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Desafio desafio = new Desafio();
                desafio.setId(rs.getInt("id"));
                desafio.setTitulo(rs.getString("titulo"));
                desafio.setDescricao(rs.getString("descricao"));
                desafio.setPontosXp(rs.getInt("pontos_xp"));
                desafio.setDificuldade(rs.getString("dificuldade"));

                desafios.add(desafio);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar desafios: " + e.getMessage());
        }
        return desafios;
    }

    // Busca um desafio específico pelo ID
    public Desafio buscarPorId(int id) {
        String sql = "SELECT * FROM desafio WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Desafio(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getInt("pontos_xp"),
                            rs.getString("dificuldade")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar desafio: " + e.getMessage());
        }
        return null;
    }
}