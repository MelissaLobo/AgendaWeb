<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	${umcontato}
	
	
	<c:if test="${not empty contatos}">
	<h1><a href="http://localhost:8080/Agenda/contatos">Todos os contatos </a><br/></h1>

	<ul>
		<c:forEach var="contato" items="${contatos}">
			<li>${contato.id }:${contato.nome }: ${contato.telefone }</li>
		</c:forEach>
	</ul>
</c:if>
	
<a href="http://localhost:8080/Agenda/site/menu.jsp">Inicio</a><br/>
</body>
</html>

