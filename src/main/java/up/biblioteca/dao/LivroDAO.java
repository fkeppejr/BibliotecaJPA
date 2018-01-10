package up.biblioteca.dao;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import up.biblioteca.bean.Livro;

public class LivroDAO extends GenericDAO<Integer, Livro>{

	public LivroDAO() {
		super(Livro.class);
	}
	
	public List<Livro> buscarLivros(){
		String sql = "select l from Livro l";
		Query query = super.getEntityManager().createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Livro> retorno = query.getResultList();
		return retorno;
	}
	
	public List<Livro> buscarPorAutor(String autor){
		String sql = "select l from Livro l "
				+ " where l.autor like :autor";
		TypedQuery<Livro> query = super.getEntityManager().createQuery(sql, Livro.class);
		query.setParameter("autor", "%"+autor+"%");

		try {
			List<Livro> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public List<Livro> buscarPorTitulo(String titulo){
		String sql = "select l from Livro l "
				+ " where l.titulo like :titulo";
		TypedQuery<Livro> query = super.getEntityManager().createQuery(sql, Livro.class);
		query.setParameter("titulo", "%"+titulo+"%");

		try {
			List<Livro> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public Livro buscarPorIsbn(String isbn){
		String sql = "select l from Livro l "
				+ " where l.isbn = :isbn";
		TypedQuery<Livro> query = super.getEntityManager().createQuery(sql, Livro.class);
		query.setParameter("isbn", isbn);

		try {
			Livro retorno = query.getSingleResult();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public List<Livro> buscar(String autor, String titulo, String isbn){
		String sql = "select l from Livro l where 1=1 ";
		if (!autor.equals("")) {
			sql += " and l.autor like :autor ";
		}
		if (!titulo.equals("")) {
			sql += " and l.titulo like :titulo ";
		}
		if (!isbn.equals("")) {
			sql += " and l.isbn like :isbn ";
		}
		
		TypedQuery<Livro> query = super.getEntityManager().createQuery(sql, Livro.class);
		if (!autor.equals("")) {
			query.setParameter("autor", "%"+autor+"%");
		}
		if (!titulo.equals("")) {
			query.setParameter("titulo", "%"+titulo+"%");
		}
		if (!isbn.equals("")) {
			query.setParameter("isbn", "%"+isbn+"%");
		}
		
		try {
			List<Livro> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public boolean validarIsbn(String isbn){
		String sql = "select l from Livro l "
				+ " where l.isbn = :isbn";
		TypedQuery<Livro> query = super.getEntityManager().createQuery(sql, Livro.class);
		query.setParameter("isbn", isbn);

		try{
			Livro retorno = query.getSingleResult();
			if (retorno != null){
				return true;
			} else {
				return false;
			}
		} catch (NoResultException ex) {
			return false;
		}
	}
}
