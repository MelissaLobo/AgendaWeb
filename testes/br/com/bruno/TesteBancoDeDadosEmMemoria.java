package br.com.bruno;

import java.util.List;

import model.Contato;

import org.junit.*;

import persistencia.AgendaEmMemoriaDAO;
import persistencia.AgendaDAO;
import static org.junit.Assert.*;

public class TesteBancoDeDadosEmMemoria {
	@Test
	public void adicionaUmContato(){
		Contato contato = new Contato();
		contato.setNome("Bruno");
		contato.setTelefone("9999-8888");

		AgendaDAO banco = new AgendaEmMemoriaDAO();
		banco.salvaContato(contato);
	}

	@Test
	public void testaBuscaDeTodosOsContatos(){
		Contato contato1 = new Contato();
		contato1.setNome("Bruno");
		contato1.setTelefone("9999-8888");


		Contato contato2 = new Contato();
		contato2.setNome("Melissa");
		contato2.setTelefone("9344-2890");

		AgendaDAO banco = new AgendaEmMemoriaDAO();
		banco.salvaContato(contato1);
		banco.salvaContato(contato2);

		List<Contato> buscaTodosOsContatos = banco.buscaTodosOsContatos();

		assertEquals(buscaTodosOsContatos.get(0), contato1);
		assertEquals(buscaTodosOsContatos.get(1), contato2);	
	}
}