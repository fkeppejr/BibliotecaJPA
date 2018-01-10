<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<html>
	
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
	
			<jsp:include flush="true" page="header.jsp">
				<jsp:param name="tituloPagina" value="Biblioteca" />
				<jsp:param name="titulo" value="Listar Livros" />
			</jsp:include>
			
			<body>
				<c:if test="${param.autor != null && param.autor != ''}">
					<B>Autor:</B> <c:out value="${param.autor}"/> 
				</c:if>
				<c:if test="${param.titulo != null && param.titulo != ''}">
					<B>Título:</B> <c:out value="${param.titulo}"/> 
				</c:if>
				<c:if test="${param.isbn != null && param.isbn != ''}">
					<B>ISBN:</B> <c:out value="${param.isbn}"/> 
				</c:if>
				<BR>
				<BR>
				<B>Livros </B><BR>
				<TABLE BORDER=1>
					<TR bgcolor='#E6E6FA'>
						<TH>Título</TH>
						<TH>Autor</TH>
						<TH>Data de publicação</TH>
						<TH>ISBN</TH>
						<TH>Qtd. páginas</TH>
						<TH>Qtd. em estoque</TH>
						<TH>Valor unitário</TH>
					</TR>
					
					<c:forEach var="livro" items="${listaLivros}">
						<TR>
							<jsp:useBean id="livro" scope="page" class="up.biblioteca.bean.Livro"/>
							<jsp:setProperty name="livro" property="idLivro" value="${livro.idLivro}" />
							<jsp:setProperty name="livro" property="titulo" value="${livro.titulo}" />
							<jsp:setProperty name="livro" property="autor" value="${livro.autor}" />
							<jsp:setProperty name="livro" property="publicacao" value="${livro.publicacao}" />
							<jsp:setProperty name="livro" property="isbn" value="${livro.isbn}" />
							<jsp:setProperty name="livro" property="paginas" value="${livro.paginas}" />
							<jsp:setProperty name="livro" property="quantidade" value="${livro.quantidade}" />
							<jsp:setProperty name="livro" property="valor" value="${livro.valor}" />
							<TD>${livro.titulo}</TD>
							<TD>${livro.autor}</TD>
							<fmt:parseDate value="${livro.publicacao}" var="dataTemp" pattern="yyyy-MM-dd"/>
							<TD><fmt:formatDate pattern="dd/MM/yyyy" value="${dataTemp}"/></TD>
							<TD>${livro.isbn}</TD>
							<TD>${livro.paginas}</TD>
							<TD>${livro.quantidade}</TD>
							<TD><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${livro.valor}" /></TD>
							<TD><A HREF="livros.do?acao=4&id=${livro.idLivro}">Alterar</A></TD>
							<TD><A HREF="livros.do?acao=2&id=${livro.idLivro}">Excluir</A></TD>
						</TR>
					</c:forEach>
					
				</TABLE>
				<br>
				<A HREF="listarLivros.jsp">Voltar</A>
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