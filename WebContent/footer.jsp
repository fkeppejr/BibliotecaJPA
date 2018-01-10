<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
</P>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
			<c:set var="rodape" value="${param.rodape}"/>
			<c:if test="${rodape == null || empty rodape}">
				<c:set var="rodape" value="UM RODAPÉ"/>
			</c:if>
	
		<DIV STYLE='background-color: #A9A9A9'>
	  		<P ALIGN='center'>
	  		<B><FONT FACE='Arial' COLOR='#FFFFFF'>
	  		<c:out value="${rodape}"/>
	  		</FONT></B></P>
	  	</DIV>
	  	</c:when>
		<c:otherwise>
			<font color='red'>Você não está logado</font>
			<br><a href='login.jsp'>Ir para o login</a>
		</c:otherwise>
	</c:choose>
</html>