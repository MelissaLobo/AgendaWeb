package persistencia;

import static util.Ferramentas.getConection;
import static util.Ferramentas.releaseDatabaseResources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contato;
import model.Usuario;

public class AgendaBancoDeDadosDAO implements AgendaDAO{

	public Contato salvaContato(Contato contato,Usuario usuario) {
     	Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = getConection();
			String sql = "INSERT INTO Agenda (nome, telefone,usuario_id) VALUES (?, ?, ?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getTelefone());
			statement.setLong(3, usuario.getId());
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			long key = keys.getLong(1);
			keys.close();
			contato.setId(key);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir contato", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return contato;
	}

	public Contato buscaContatoPorID(Long id) {
		Contato contact = null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "SELECT * FROM Agenda WHERE ID = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
	
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				contact = new Contato();
				contact.setId(resultSet.getLong("id"));
				contact.setNome(resultSet.getString("nome"));
				contact.setTelefone(resultSet.getString("telefone"));
			}
			resultSet.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar contato.", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}return contact;
	}

	public List<Contato> buscaTodosOsContatos(Usuario usuario) {
		List<Contato> contatos = new ArrayList<Contato>();
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "SELECT * FROM agenda where usuario_id = ? ORDER BY nome ASC";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, usuario.getId());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Contato contact = new Contato();
				contact.setId(resultSet.getLong("id"));
				contact.setNome(resultSet.getString("nome"));
				contact.setTelefone(resultSet.getString("telefone"));
				contatos.add(contact);
			}
			resultSet.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar todos os contatos", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
		return contatos;
	}

	public void deletarPorNome(String nome) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConection();
			String sql = "DELETE FROM Agenda WHERE nome = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar contato.", e);
		} finally {
			releaseDatabaseResources(statement, connection);
		}
	}		


}
