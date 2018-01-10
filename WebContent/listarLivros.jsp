<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<html>
	
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
	
			<jsp:include flush="true" page="header.jsp">
				<jsp:param name="tituloPagina" value="Biblioteca" />
				<jsp:param name="titulo" value="Listar Livros" />
			</jsp:include>
			
			<body>
				<FORM NAME='formListarLivros' METHOD='POST' ACTION='livros.do?acao=3'>
					<BR> Autor:<BR>
					<INPUT TYPE='TEXT' NAME='autor' VALUE='' SIZE='100' MAXLENGTH='200'>
					<BR> Título:<BR>
					<INPUT TYPE='TEXT' NAME='titulo' VALUE='' SIZE='100' MAXLENGTH='200'>
					<BR> ISBN:<BR>
					<INPUT TYPE='TEXT' NAME='isbn' VALUE='' SIZE='50' MAXLENGTH='50'>
					<BR><BR>
					<INPUT TYPE = 'SUBMIT' NAME = "btnConsultar" VALUE = "Consultar Livros">		
				</FORM>
				<br>
				<A HREF="menu.jsp">Voltar</A>
			</body>
			<jsp:include flush="true" page="footer.jsp">
				<jsp:param name="rodape" value="Trabalho Final - Fernando Antonio Keppe Junior"/>
			</jsp:include>
		</c:when>
		<c:otherwise>
			<font color='red'>Você não está logado</font>
			<br><a href='login.jsp'>Ir para o login</a>
		</c:otherwise>
	</c:choose>
</html>