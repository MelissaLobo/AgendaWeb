package persistencia;

import java.util.HashMap;
import java.util.Map;

import model.Usuario;

public class UsuarioEmMemoriaDAO implements UsuarioDAO{

	
	private static Map<String, Usuario> usuariosCadastrados = new HashMap<>();
	
	static {
		usuariosCadastrados.put("a", new Usuario("a","a", "a"));
	}

	@Override
	public void salvaUsuario(Usuario usuario) {
		usuariosCadastrados.put(usuario.getEmail(), usuario);
	}

	@Override
	public Usuario buscaPorLoginESenha(String login, String senha) {
		
		Usuario usuario = usuariosCadastrados.get(login);
		if(usarionaonulo(usuario) && senhaValida(senha, usuario)){
			return usuario;
		}else{
			return null;
		}
		
	}

	private boolean usarionaonulo(Usuario usuario) {
		return usuario!=null;
	}

	private boolean senhaValida(String senha, Usuario usuario) {
		return usuario.getSenha().equals(senha);
	}
	

}
