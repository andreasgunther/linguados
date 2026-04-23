package com.linguados.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // 1. Tenta pegar o Host (localhost ou db), se não houver, usa localhost
    private static final String HOST = System.getenv("DB_HOST") != null
            ? System.getenv("DB_HOST")
            : "localhost";

    // 2. Tenta pegar a Porta, se não houver, usa a 3306 (padrão do grupo)
    private static final String PORT = System.getenv("DB_PORT") != null
            ? System.getenv("DB_PORT")
            : "3306";

    private static final String DB_NAME = "linguados";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // 3. Monta a URL usando Host e Porta dinâmicos + parâmetros de segurança
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver MySQL não encontrado...", e);
            }
        }
        return connection;
    }
}