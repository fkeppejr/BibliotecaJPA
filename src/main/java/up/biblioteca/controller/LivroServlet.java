package up.biblioteca.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import up.biblioteca.bean.Livro;
import up.biblioteca.facede.LivroFacade;
import up.biblioteca.utils.DateUtils;

public class LivroServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("chegou no servlet");
		String acao = request.getParameter("acao");
		LivroFacade lFacede = new LivroFacade();
		
		//acao = 1 -> incluir livro
		if(acao.equals("1")){
			System.out.println("entrou na ação -> "+acao);
			if(!request.getParameter("titulo").equals("") 
					&& !request.getParameter("autor").equals("")
					&& !request.getParameter("isbn").equals("")
					&& !request.getParameter("paginas").equals("")
					&& !request.getParameter("publicacao").equals("")
					&& !request.getParameter("quantidade").equals("")
					&& !request.getParameter("valor").equals("")){
				
				System.out.println("entrou no if -> nada nulo");
				Livro livro = new Livro();
				livro.setTitulo(request.getParameter("titulo"));
				livro.setAutor(request.getParameter("autor"));
				livro.setIsbn(request.getParameter("isbn"));
				livro.setPaginas(Integer.parseInt(request.getParameter("paginas")));
				livro.setPublicacao(DateUtils.stringToDate(request.getParameter("publicacao")));
				livro.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
				livro.setValor(Double.parseDouble(request.getParameter("valor")));
				System.out.println("livro -> "+livro.toString());
				
				if(lFacede.buscarPorIsbn(livro.getIsbn()) == null){
					try {
						System.out.println("vai salvar livro");
						lFacede.salvar(livro);
						System.out.println("livro salvo");
						request.getRequestDispatcher("/mensagens.jsp?mensagem=Livro cadastrado com sucesso&pagina=menu.jsp").forward(request, response);
					} catch (Exception e) {
						System.out.println("livro não salvo");
						request.getRequestDispatcher("/mensagens.jsp?mensagem=Erro ao salvar livro&pagina=cadastrarLivro.jsp").forward(request, response);
						e.printStackTrace();
					}
				} else {
					System.out.println("erro ao salvar livro");
					request.getRequestDispatcher("/mensagens.jsp?mensagem=Livro já cadastrado&pagina=cadastrarLivro.jsp").forward(request, response);
				}
			}
			else{
				System.out.println("campos vazios");
				request.getRequestDispatcher("/mensagens.jsp?mensagem=Todos os campos são de preenchimento obrigatório&pagina=cadastrarLivro.jsp").forward(request, response);
			}
		}
		
		//acao = 2 -> Excluir livro
		else if(acao.equals("2")){
			System.out.println("entrou no if -> "+acao);
			if(!request.getParameter("id").equals("")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					lFacede.delete(id);
					request.getRequestDispatcher("/mensagens.jsp?mensagem=Livro excluído&pagina=listarLivros.jsp").forward(request, response);
				} catch (Exception e) {
					request.getRequestDispatcher("/mensagens.jsp?mensagem=Erro ao excluir livro&pagina=listarLivros.jsp").forward(request, response);
					e.printStackTrace();
				}
			}
			else{
				request.getRequestDispatcher("/mensagens.jsp?mensagem=Nenhum livro selecionado pra exclusao&pagina=listarLivros.jsp").forward(request, response);
			}
		}
		
		//acao = 3 -> listar livros
		else if(acao.equals("3"))
		{
			System.out.println("entrou no if -> "+acao);
			if(!request.getParameter("titulo").equals("") 
					|| !request.getParameter("autor").equals("")
					|| !request.getParameter("isbn").equals("")){
				
				String titulo = request.getParameter("titulo");
				String autor = request.getParameter("autor");
				String isbn = request.getParameter("isbn");
				try {
					List<Livro> listaLivros = lFacede.buscar(autor, titulo, isbn);
					if (listaLivros != null) {
						System.out.println("listaLivros -> "+listaLivros.toString());
						HttpSession session = request.getSession();
						session.setAttribute("listaLivros", listaLivros);
						request.getRequestDispatcher("/listarLivrosResult.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("/mensagens.jsp?mensagem=Nenhum livro encontrado&pagina=listarLivros.jsp").forward(request, response);
					}
				} catch (Exception e) {
					request.getRequestDispatcher("/mensagens.jsp?mensagem=Erro ao consultar livros&pagina=listarLivros.jsp").forward(request, response);
					e.printStackTrace();
				}
			}
			else{
				request.getRequestDispatcher("/mensagens.jsp?mensagem=Preencha ao menos um campo de filtro&pagina=listarLivros.jsp").forward(request, response);
			}
		}
		//acao = 4 -> Alterar livro
		else if(acao.equals("4"))
		{
			System.out.println("entrou no if -> "+acao);
			if(!request.getParameter("id").equals("")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					Livro livro = lFacede.buscar(id);
					if (livro != null) {
						System.out.println("livro -> "+livro.toString());
						HttpSession session = request.getSession();
						session.setAttribute("livroAlterar", livro);
						request.getRequestDispatcher("/alterarLivro.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("/mensagens.jsp?mensagem=Nenhum livro encontrado para alteração&pagina=listarLivros.jsp").forward(request, response);
					}
				} catch (Exception e) {
					request.getRequestDispatcher("/mensagens.jsp?mensagem=Erro ao consultar livro para alteração&pagina=listarLivros.jsp").forward(request, response);
					e.printStackTrace();
				}
			}
			else{
				request.getRequestDispatcher("/mensagens.jsp?mensagem=Nenhum livro selecionado pra alteração&pagina=listarLivros.jsp").forward(request, response);
			}
		}
		//acao = 5 -> Atualizar livro
		else if(acao.equals("5"))
		{
			System.out.println("entrou na ação -> "+acao);
			if(!request.getParameter("titulo").equals("") 
					&& !request.getParameter("autor").equals("")
					&& !request.getParameter("isbn").equals("")
					&& !request.getParameter("paginas").equals("")
					&& !request.getParameter("publicacao").equals("")
					&& !request.getParameter("quantidade").equals("")
					&& !request.getParameter("valor").equals("")){
				
				System.out.println("entrou no if -> nada nulo");
				Livro livro = new Livro();
				livro.setTitulo(request.getParameter("titulo"));
				livro.setAutor(request.getParameter("autor"));
				livro.setIsbn(request.getParameter("isbn"));
				livro.setPaginas(Integer.parseInt(request.getParameter("paginas")));
				livro.setPublicacao(DateUtils.stringToDate(request.getParameter("publicacao")));
				livro.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
				livro.setValor(Double.parseDouble(request.getParameter("valor")));
				livro.setIdLivro(Integer.parseInt(request.getParameter("idLivro")));
				System.out.println("livro -> "+livro.toString());
				
				try {
					if (lFacede.buscarPorIsbn(livro.getIsbn()) == null 
							|| (lFacede.buscarPorIsbn(livro.getIsbn()).getIdLivro() == livro.getIdLivro())) {
					//if (livro.getIdLivro() == lValidacao.getIdLivro()) {
						System.out.println("isbn é o mesmo -> vai atualizar");
						lFacede.update(livro);
						System.out.println("livro atualizado");
						request.getRequestDispatcher("/mensagens.jsp?mensagem=Livro alterado com sucesso&pagina=menu.jsp").forward(request, response);
					} else {
						System.out.println("código ISBN diferente -> não vai atualizar");
						request.getRequestDispatcher("/mensagens.jsp?mensagem=Código ISBN já em uso&pagina=alterarLivro.jsp").forward(request, response);
					}
				} catch (Exception e) {
					System.out.println("erro au atualizar livro");
					request.getRequestDispatcher("/mensagens.jsp?mensagem=Erro ao salvar livro&pagina=alterarLivro.jsp").forward(request, response);
					e.printStackTrace();
				}
			} else {
				request.getRequestDispatcher("/mensagens.jsp?mensagem=Preencha todos os campos&pagina=alterarLivro.jsp").forward(request, response);
			}
		}
	}

}
