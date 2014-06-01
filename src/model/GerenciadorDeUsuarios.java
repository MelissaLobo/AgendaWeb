package model;

import persistencia.UsuarioDAO;
import persistencia.UsuarioEmMemoriaDAO;

public class GerenciadorDeUsuarios {
	
	UsuarioDAO banco = new UsuarioEmMemoriaDAO();

	public void cadastrarUsuario(String nome, String email, String senha) {

		Usuario usuario = new Usuario(nome, email, senha);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);

		banco.salvaUsuario(usuario);
	}

	public Usuario tentaLogar(String login, String senha) {
		return banco.buscaPorLoginESenha(login, senha);
	}
}