package controller;

import static util.Ferramentas.vaiParaPagina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import model.Contato;

@SuppressWarnings("serial")
@WebServlet("/buscarContato")
public class BuscaContatoPorID extends HttpServlet{


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Agenda agenda = new Agenda();
		Long id= null;
		try{
			id = Long.parseLong(req.getParameter("id"));
		}catch(NumberFormatException e){
			req.setAttribute("erro", "Digite somente numeros");
		    vaiParaPagina(req, resp, "site/buscarContato.jsp");
		    return;
		}
		Contato buscandoContato = agenda.buscandoContato(id);
		req.setAttribute("umcontato", buscandoContato);
		vaiParaPagina(req, resp,"site/contatos.jsp");
				
	}


}
