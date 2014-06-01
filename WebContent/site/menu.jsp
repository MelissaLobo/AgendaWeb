<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}<br/>
</c:if>

	<h1>Bem Vindo a sua Agenda!</h1>
<br />
<h2>Funções:</h2>
	<br />
	<a href="http://localhost:8080/Agenda/site/salvar.jsp">Adicionar um novo contato</a>
	<br />
	<a href="http://localhost:8080/Agenda/contatos">Buscar todos os contatos </a>
	<br />
	<a href="http://localhost:8080/Agenda/site/buscarContato.jsp">Buscar contato por ID </a>
	<br />
	<a href="http://localhost:8080/Agenda/site/deletar.jsp">Deletar contato </a>
	<br />
	
	<form action="http://localhost:8080/Agenda/deslogar" method="POST">
		<input type="hidden" name="logout" value="Logout" /> 
		<input type="submit" value="Deslogar" />
	</form>
</body>
</html>