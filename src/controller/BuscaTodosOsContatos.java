package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;

@SuppressWarnings("serial")
@WebServlet("/contatos")
public class BuscaTodosOsContatos extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Agenda agenda = new Agenda();
		agenda.adicionaContato("bruno", "11");
		agenda.adicionaContato("xxx", "11");

		request.setAttribute("contatos",agenda.buscarTodosOsContatos() );

		RequestDispatcher rd = request.getRequestDispatcher("site/contatos.jsp");
		rd.forward(request, response);

	}


}
