package persistencia;

import model.Usuario;

public interface UsuarioDAO {

	void salvaUsuario(Usuario usuario);

	Usuario buscaPorLoginESenha(String login,String senha);

}