<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${listaDePessoas}" var="pessoa">
		<a href="/crud/pessoas?metodo=detalhar&idPessoa=${pessoa.id}">${pessoa.nome}</a>
		<a href="/crud/pessoas?metodo=excluir&idPessoa=${pessoa.id}">Remover</a><br>
	</c:forEach>

	${mensagem}

</body>
</html>