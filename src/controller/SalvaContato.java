package controller;

import static util.Ferramentas.vaiParaPagina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;

@SuppressWarnings("serial")
@WebServlet("/salvar")
public class SalvaContato extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		
		Agenda agenda = new Agenda();
		agenda.adicionaContato(nome, telefone);
		
		req.setAttribute("contatos", agenda.buscarTodosOsContatos());
		vaiParaPagina(req, resp, "site/contatos.jsp");

	}
}
