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
@WebServlet("/deletar")
public class DeletarContato extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nome = req.getParameter("Nome do Contato");
		Agenda agenda = new Agenda();
		agenda.deletarPorNome(nome);
		
		vaiParaPagina(req, resp, "site/deletado.jsp");
	}

}
