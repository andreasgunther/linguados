package com.linguados.progresso;

import com.linguados.config.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class ProgressoDAO {

        // 1. Cria os dados de progresso do novo Usuario
        public void criarProgressoInicial(int idUsuario) {
            String sql = "INSERT INTO progresso (id_usuario, xp_atual, nivel_atual) VALUES (?, 0, 1)";

            try (Connection conn = DatabaseConfig.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, idUsuario);
                stmt.executeUpdate();
                System.out.println("Status: Progresso inicial do usuário " + idUsuario + " criado com sucesso.");

            } catch (SQLException e) {
                System.err.println("Erro ao criar progresso inicial: " + e.getMessage());
            }
        }

        // 2. Buscar progresso pelo ID do usuário
        public Progresso buscarPorUsuario(int idUsuario) {
            String sql = "SELECT * FROM progresso WHERE id_usuario = ?";

            try (Connection conn = DatabaseConfig.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, idUsuario);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return new Progresso(
                            rs.getInt("id_usuario"),
                            rs.getInt("xp_atual"),
                            rs.getInt("nivel_atual")
                    );
                }
            } catch (SQLException e) {
                System.err.println("Erro ao buscar progresso: " + e.getMessage());
            }
            return null;
        }

        // 3. Atualizar o XP e Nível (chamado quando o usuário ganha pontos)
        public void atualizarProgresso(Progresso progresso) {
            String sql = "UPDATE progresso SET xp_atual = ?, nivel_atual = ? WHERE id_usuario = ?";

            try (Connection conn = DatabaseConfig.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, progresso.getXpAtual());
                stmt.setInt(2, progresso.getNivelAtual());
                stmt.setInt(3, progresso.getIdUsuario());

                stmt.executeUpdate();
                System.out.println("Progresso salvo no banco!");

            } catch (SQLException e) {
                System.err.println("Erro ao salvar progresso: " + e.getMessage());
            }
        }
    }
}
