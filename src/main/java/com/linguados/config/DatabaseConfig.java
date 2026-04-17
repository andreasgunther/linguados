package com.linguados.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // Pega o host da variável de ambiente DB_HOST, se não existir usa localhost
    private static final String HOST = System.getenv("DB_HOST") != null
            ? System.getenv("DB_HOST")
            : "localhost";

    private static final String DB_NAME = "linguados";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String URL = "jdbc:mysql://" + HOST + ":3306/" + DB_NAME;

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