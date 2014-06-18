package controller;

import static util.Ferramentas.vaiParaPagina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import model.Usuario;

@SuppressWarnings("serial")
@WebServlet("/salvar")
public class SalvaContato extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
				
		Agenda agenda = new Agenda();
		agenda.adicionaContato(nome, telefone,usuario);
		
		req.setAttribute("contatos", agenda.buscarTodosOsContatos(usuario));
		vaiParaPagina(req, resp, "site/contatos.jsp");

	}
}
