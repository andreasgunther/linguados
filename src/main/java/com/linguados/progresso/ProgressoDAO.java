package com.linguados.progresso;

import com.linguados.config.DatabaseConfig;
import com.linguados.usuario.Usuario;

import java.sql.*;

public class ProgressoDAO {

    // 1. Criar progresso inicial (nível 1, XP 0 já deve estar no usuário)
    public void criarProgressoInicial(int idUsuario) {

        String sql = "INSERT INTO progresso (usuario_id, desafio_id) VALUES (?, NULL)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();

            System.out.println("Progresso inicial criado!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar progresso inicial: " + e.getMessage());
        }
    }

    // 2. Buscar progresso (XP e nível)
    public Progresso buscarPorUsuario(int idUsuario) {

        String sql = "SELECT xp, nivel FROM usuario WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Progresso(
                        idUsuario,
                        rs.getInt("xp"),
                        rs.getInt("nivel")
                );
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar progresso: " + e.getMessage());
        }

        return null;
    }

    // 3. Atualizar progresso (VERSÃO PADRÃO)
    public void atualizarProgresso(Usuario usuario) {

        String sql = "UPDATE usuario SET xp = ?, nivel = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getXp());
            stmt.setInt(2, usuario.getNivel());
            stmt.setInt(3, usuario.getId());

            stmt.executeUpdate();

            System.out.println("💾 Progresso atualizado!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar progresso: " + e.getMessage());
        }
    }

    // 4. Registrar histórico de desafios
    public void registrarConclusao(int idUsuario, int idDesafio) {

        String sql = "INSERT INTO progresso (usuario_id, desafio_id) VALUES (?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idDesafio);

            stmt.executeUpdate();

            System.out.println("LOG: Desafio registrado no histórico!");

        } catch (SQLException e) {
            System.err.println("Erro ao registrar histórico: " + e.getMessage());
        }
    }
}