<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
	
			<jsp:include flush="true" page="header.jsp">
				<jsp:param name="tituloPagina" value="Biblioteca"/>
				<jsp:param name="titulo" value="Menu principal"/>
			</jsp:include>
			
			<body>
				
			<a href="cadastrarLivro.jsp">Cadastrar Livro</a><br>
			<a href="listarLivros.jsp">Listar Livros</a><br>
			
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