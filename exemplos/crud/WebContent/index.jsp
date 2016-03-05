<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INDEX</title>
</head>
<body>

	<form action="pessoas" method="post">
		<input type="hidden"
		       name="metodo"
		       value="inserir"/>
		Nome: <input name="nome" type="text" /> <br>
		Sexo: <input name="sexo" type="text" /> <br>
		E-mail: <input name="email" type="text" /> <br>
		CPF: <input name="cpf" type="text" /> <br>
		<input type="submit" value="Cadastrar Pessoa" />
	</form>

	<form action="pessoas" method="post">
		<input type="hidden"
		       name="metodo"
		       value="listar"/>
		<input type="submit" value="Listar Pessoas" />
	</form>

	${mensagem}

</body>
</html>