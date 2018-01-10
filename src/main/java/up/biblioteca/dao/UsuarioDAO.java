package up.biblioteca.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import up.biblioteca.bean.Usuario;

public class UsuarioDAO extends GenericDAO<Integer, Usuario>{

	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public Usuario buscarPorLogin(String login){
		String sql = "select u from Usuario u"
				+ " where u.login = :login";
		TypedQuery<Usuario> query = super.getEntityManager().createQuery(sql, Usuario.class);
		query.setParameter("login", login);

		try {
			Usuario retorno = query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public boolean validarLogin(String login){
		String sql = "select u from Usuario u"
				+ " where u.login = :login";
		TypedQuery<Usuario> query = super.getEntityManager().createQuery(sql, Usuario.class);
		query.setParameter("login", login);

		try{
			Usuario retorno = query.getSingleResult();
			if (retorno != null){
				return true;
			} else {
				return false;
			}
		} catch (NoResultException ex) {
			return false;
		}
	}

	public Usuario buscarUsuario(String login, String senha) {
		String sql = "select u from Usuario u"
				+ " where u.login = :login and u.senha = :senha";
		TypedQuery<Usuario> query = super.getEntityManager().createQuery(sql, Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);

		try {
			Usuario retorno = query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}

}
