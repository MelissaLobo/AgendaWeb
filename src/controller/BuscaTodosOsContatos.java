package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import model.Usuario;

@SuppressWarnings("serial")
@WebServlet("/contatos")
public class BuscaTodosOsContatos extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Agenda agenda = new Agenda();
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		request.setAttribute("contatos",agenda.buscarTodosOsContatos(usuario) );

		RequestDispatcher rd = request.getRequestDispatcher("site/contatos.jsp");
		rd.forward(request, response);

	}


}
