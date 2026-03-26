package com.linguados;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. Define a porta do servidor (8080 é o padrão comum)
        int porta = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(porta), 0);

        // 2. Cria um "contexto" (a rota/URL que o servidor vai escutar)
        // Aqui, toda vez que acessar http://localhost:8080/saudacao, o handler será chamado
        server.createContext("/login", new SaudacaoHandler());

        // 3. Define um executor padrão (null usa o padrão do sistema)
        server.setExecutor(null);

        System.out.println("Servidor iniciado na porta " + porta);
        server.start();
    }

    // 4. Classe que define o que acontece quando a rota é acessada
    static class SaudacaoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String resposta = "Realize o login.";

            // Define o cabeçalho HTTP (Status 200 OK e tamanho do corpo)
            exchange.sendResponseHeaders(200, resposta.length());

            // Escreve a resposta no corpo da mensagem
            OutputStream os = exchange.getResponseBody();
            os.write(resposta.getBytes());
            os.close();
        }
    }
}