package up.biblioteca.facede;

import up.biblioteca.bean.Usuario;
import up.biblioteca.dao.UsuarioDAO;

public class UsuarioFacade implements IFacade<Integer, Usuario>{

	private UsuarioDAO dao = new UsuarioDAO();
	
	@Override
	public void salvar(Usuario objeto) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public Usuario buscar(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Usuario usuario = dao.find(id);
			dao.commitAndCloseTransaction();
			return usuario;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public void update(Usuario objeto) throws Exception {
		try {
			dao.beginTransaction();
			dao.update(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw new Exception(e);
		}
	}

	@Override
	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Usuario u = dao.findReferenceOnly(id);
			dao.delete(u);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public Usuario buscarPorLogin(String login) {
		try {
			dao.beginTransaction();
			Usuario usuario = dao.buscarPorLogin(login);
			dao.commitAndCloseTransaction();
			return usuario;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public Usuario buscarUsuario(String login, String senha) {
		try {
			dao.beginTransaction();
			Usuario usuario = dao.buscarUsuario(login, senha);
			dao.commitAndCloseTransaction();
			return usuario;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public boolean validarLogin(String login) {
		try {
			dao.beginTransaction();
			boolean teste = dao.validarLogin(login);
			dao.commitAndCloseTransaction();
			return teste;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

}
