package com.linguados.usuario;

public class LoginController {

    LoginDAO dao = new LoginDAO();

    public void cadastrar(String user, String senha) {
    	
    	if (senha.length() < 8) {
    		System.out.println("Sua senha deve ter mais de 8 caracteres!");
    		return;
    	}
    	
    	if (!senha.matches(".*\\d.*")) {
    		System.out.println("Sua senha deve ter letras e números!");
    		return;
    	}
    	
    	if (!senha.matches(".*[a-zA-Z].*")) {
    		System.out.println("Sua senha deve ter letras e números!");
    		return;
    	}
    	
        Usuario u = new Usuario(user, senha);
        dao.cadastrar(u);
    }

    public Usuario login(String user, String senha) {
        return dao.login(user, senha);
    }
}