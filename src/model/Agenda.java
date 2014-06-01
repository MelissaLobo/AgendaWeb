package model;

import java.util.List;

import persistencia.AgendaBancoDeDadosDAO;
import persistencia.AgendaDAO;

public class Agenda {
	
	AgendaDAO banco = new AgendaBancoDeDadosDAO();
	
	public List<Contato> buscarTodosOsContatos() {
		return banco.buscaTodosOsContatos();
	}

	public void adicionaContato(String nome, String telefone) {

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setTelefone(telefone);

		banco.salvaContato(contato);
}
	public Contato buscandoContato(Long id){
		return banco.buscaContatoPorID(id);
	}
	
	public void deletarPorNome(String nome) {
		banco.deletarPorNome(nome);
	}

}