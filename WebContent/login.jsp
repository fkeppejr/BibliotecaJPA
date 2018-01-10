<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<title>BIBLIOTECA - LOGIN</title>
	<body>
		
	<FORM NAME='formLogin' METHOD='POST' ACTION='usuarios.do?acao=1'>
		<BR> Login:<BR>
		<INPUT TYPE='TEXT' NAME='login' VALUE='' SIZE='15' MAXLENGTH='11'>
		<BR> Senha:<BR>
		<INPUT TYPE='password' NAME='senha' VALUE='' SIZE='15'>
		<BR>
		<BR>
		<INPUT TYPE = 'SUBMIT' NAME = "btnLogin" VALUE = "Entrar">			
	</FORM>
	<a href=cadastrarUsuario.jsp>Me cadastrar</a>
	</body>
	
</html>