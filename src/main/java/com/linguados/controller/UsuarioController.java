package com.linguados.controller;

import com.google.gson.Gson;
import com.linguados.model.Usuario;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UsuarioController implements HttpHandler {
    private Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Crio um dado (Model) e o transformo em JSON (View)
        Usuario user = new Usuario("admin", "admin@admin.com", "1234");
        String response = gson.toJson(user);

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes(StandardCharsets.UTF_8);
        os.close();
    }


}
