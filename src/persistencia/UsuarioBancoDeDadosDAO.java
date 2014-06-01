package persistencia;

import static util.Ferramentas.getConection;
import static util.Ferramentas.releaseDatabaseResources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Usuario;

public class UsuarioBancoDeDadosDAO implements UsuarioDAO {

	
	
	
	@Override
	public void salvaUsuario(Usuario usuario) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "INSERT INTO Usuario (nome, email, senha) VALUES (?,?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getSenha());
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			long key = keys.getLong(1);
			keys.close();
			usuario.setId(key);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir usuario", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
	}
	

	@Override
	public Usuario buscaPorLoginESenha(String login, String senha) {
	
		return null;
	}
	
}