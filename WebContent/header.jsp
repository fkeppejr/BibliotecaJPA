<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" %>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="usuarioDao" scope="session" class="up.biblioteca.dao.UsuarioDAO" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
	
			<title>
			<c:set var="titulo" value="${param.titulo}"/>
			<c:if test="${titulo == null || empty titulo}">
				<c:set var="titulo" value="SISTEMA DE FOLHA DE PAGAMENTOS"/>
			</c:if>
			<c:choose>
				<c:when test="${param.tituloPagina == null || empty param.tituloPagina}">
					SISTEMA DE FOLHA DE PAGAMENTOS
				</c:when>
				<c:otherwise>
					<c:out value="${param.tituloPagina}"/>
				</c:otherwise>
			</c:choose>
			</title>
				<p ALIGN='right'><B><c:out value="${sessionScope.nomeUser}"/></B><BR>
		  		<a href='usuarios.do?acao=3'>Sair</a>
		  		</p>
			<DIV STYLE='background-color: #666699'>
		  		<P ALIGN='center'><B><FONT FACE='Arial' COLOR='#FFFFFF'><c:out value="${titulo}"/></FONT></B>
		  		
		  	</DIV>
			<P ALIGN='left'>
	
		</c:when>
		<c:otherwise>
			<font color='red'>Você não está logado</font>
			<br><a href='login.jsp'>Ir para o login</a>
		</c:otherwise>
	</c:choose>
</head>
