<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Login Agenda</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<br/>
	
<c:if test="${not empty erro}">
	${erro}<br/>
</c:if>
<h2>Login:</h2>
	<form action="http://localhost:8080/Agenda/login" method="POST">
		<input type="text" name="login" /> 
		<input type="password" name="pass" /> 
		<input type="submit" value="efetuar login" />
	</form>
	
<a href="http://localhost:8080/Agenda/cadastro.jsp">Cadastre-se</a>	
</body>
</html>