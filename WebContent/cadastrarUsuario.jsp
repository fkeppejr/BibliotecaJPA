<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Cadastro de usuários</title>
	</head>
	<body>
		<FORM NAME='formCadastrarUsuario' METHOD='POST' ACTION='usuarios.do?acao=2'>
			<BR> Nome:<BR>
			<INPUT TYPE='TEXT' NAME='nome' VALUE='' SIZE='50' MAXLENGTH='50'>
			<BR> Nome de login:<BR>
			<INPUT TYPE='TEXT' NAME='login' VALUE='' SIZE='20' MAXLENGTH='20'>
			<BR> Senha:<BR>
			<INPUT TYPE='PASSWORD' NAME='senha' VALUE='' SIZE='20' MAXLENGTH='20'>
			<BR>
			<BR>
			<INPUT TYPE = 'SUBMIT' NAME = "btnSalvar" VALUE = "Cadastrar">			
		</FORM>
		<br><A HREF="login.jsp">Cancelar</A>
</html>