package up.biblioteca.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import up.biblioteca.bean.Usuario;
import up.biblioteca.facede.UsuarioFacade;


public class UsuarioServlet extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String acao = request.getParameter("acao");
		UsuarioFacade uFacede = new UsuarioFacade();
		
		//acao = 1 -> validar usu�rio
		if(acao.equals("1")){
			if(!request.getParameter("login").equals("") && !request.getParameter("senha").equals("")){
				Usuario usuario = new Usuario();
				usuario.setLogin(request.getParameter("login"));
				usuario.setSenha(request.getParameter("senha"));
				if(uFacede.validarLogin(usuario.getLogin())){
					usuario = uFacede.buscarPorLogin(usuario.getLogin());
					HttpSession session = request.getSession();
					session.setAttribute("user", usuario.getLogin());
					session.setAttribute("nomeUser", usuario.getNome());
					request.getRequestDispatcher("/menu.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("/mensagens.jsp?mensagem=Usu�rio/Senha inv�lidos&pagina=login.jsp").forward(request, response);
				}
			}
			else{
				request.getRequestDispatcher("/mensagens.jsp?mensagem=Os campos login e senha s�o de preenchimento obrigat�rio&pagina=login.jsp").forward(request, response);
			}
		}
		
		//acao = 2 -> incluir usuario
		else if(acao.equals("2")){
			if(!request.getParameter("login").equals("") && !request.getParameter("senha").equals("")){
				Usuario usuario = new Usuario();
				usuario.setNome(request.getParameter("nome"));
				usuario.setLogin(request.getParameter("login"));
				usuario.setSenha(request.getParameter("senha"));
				if(uFacede.buscarUsuario(usuario.getLogin(), usuario.getSenha()) == null){
					try {
						uFacede.salvar(usuario);
						request.getRequestDispatcher("/mensagens.jsp?mensagem=Usu�rio cadastrado com sucesso&pagina=login.jsp").forward(request, response);
					} catch (Exception e) {
						request.getRequestDispatcher("/mensagens.jsp?mensagem=Erro ao cadastrar usu�rio&pagina=cadastrarUsuario.jsp").forward(request, response);
						e.printStackTrace();
					}
					
				}
				else{
					request.getRequestDispatcher("/mensagens.jsp?mensagem=Usu�rio j� cadastrado&pagina=cadastrarUsuario.jsp").forward(request, response);
				}
			}
			else{
				request.getRequestDispatcher("/mensagens.jsp?mensagem=Os campos nome, login e senha s�o de preenchimento obrigat�rio&pagina=cadastrarUsuario.jsp").forward(request, response);
			}
		}
		
		//acao = 3 -> invalidar sessao
		else if(acao.equals("3"))
		{
			HttpSession session = request.getSession();
			session.invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
}
