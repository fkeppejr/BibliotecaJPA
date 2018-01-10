<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
	
			<jsp:include flush="true" page="header.jsp">
				<jsp:param name="tituloPagina" value="Biblioteca"/>
				<jsp:param name="titulo" value="Atualização de livros"/>
			</jsp:include>
			<body>
				<FORM NAME='formCadastrarLivro' METHOD='POST' ACTION='livros.do?acao=5&idLivro=${livroAlterar.idLivro}'>
					
					<!-- Cria variável livro -->
					<jsp:useBean id="livro" scope="page" class="up.biblioteca.bean.Livro"/>
					<jsp:setProperty name="livro" property="idLivro" value="${livroAlterar.idLivro}" />
					<jsp:setProperty name="livro" property="titulo" value="${livroAlterar.titulo}" />
					<jsp:setProperty name="livro" property="autor" value="${livroAlterar.autor}" />
					<jsp:setProperty name="livro" property="publicacao" value="${livroAlterar.publicacao}" />
					<jsp:setProperty name="livro" property="isbn" value="${livroAlterar.isbn}" />
					<jsp:setProperty name="livro" property="paginas" value="${livroAlterar.paginas}" />
					<jsp:setProperty name="livro" property="quantidade" value="${livroAlterar.quantidade}" />
					<jsp:setProperty name="livro" property="valor" value="${livroAlterar.valor}" />
					
					<BR> Título:<BR>
					<INPUT TYPE='TEXT' NAME='titulo' VALUE='${livro.titulo}' SIZE='100' MAXLENGTH='200'>
					<BR> Autor:<BR>
					<INPUT TYPE='TEXT' NAME='autor' VALUE='${livro.autor}' SIZE='100' MAXLENGTH='200'>
					<BR> ISBN:<BR>
					<INPUT TYPE='TEXT' NAME='isbn' VALUE='${livro.isbn}' SIZE='50' MAXLENGTH='50'>
					<BR> Quant. páginas:<BR>
					<INPUT TYPE='NUMBER' NAME='paginas' VALUE='${livro.paginas}' SIZE='50'>
					<BR> Valor:<BR>
					<INPUT TYPE='NUMBER' NAME='valor' VALUE='${livro.valor}' SIZE='50'>
					<BR> Data de publicação:<BR>
					<fmt:formatDate var="dateString" pattern="yyyy-MM-dd" value="${livro.publicacao}" />
					<INPUT TYPE='DATE' ID='publicacao' NAME='publicacao' VALUE='${dateString}'> 
					<BR> Quantidade unitária:<BR>
					<INPUT TYPE='NUMBER' NAME='quantidade' VALUE='${livro.quantidade}' SIZE='50'>
					<BR>
					<BR>
					<INPUT TYPE='SUBMIT' NAME="btnSalvar" VALUE="Atualizar">	
				</FORM>
				<br><A HREF="menu.jsp">Voltar</A>
				
			</body>
			
			<jsp:include flush="true" page="footer.jsp">
				<jsp:param name="rodape" value="Trabalho Final - Fernando Antonio Keppe Junior"/>
			</jsp:include>
	
		</c:when>
		<c:otherwise>
			<font color='red'>Você não está logado.</font>
			<br><a href='login.jsp'>Ir para o login</a>
		</c:otherwise>
	</c:choose>
	
</html>