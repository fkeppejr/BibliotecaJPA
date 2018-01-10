package up.biblioteca.facede;

import java.util.List;

import up.biblioteca.bean.Livro;
import up.biblioteca.dao.LivroDAO;

public class LivroFacade implements IFacade<Integer, Livro>{

	private LivroDAO dao = new LivroDAO();
	
	@Override
	public void salvar(Livro objeto) throws Exception {
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
	public Livro buscar(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Livro livro = dao.find(id);
			dao.commitAndCloseTransaction();
			return livro;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

	@Override
	public void update(Livro objeto) throws Exception {
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
			Livro u = dao.findReferenceOnly(id);
			dao.delete(u);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public Livro buscarPorIsbn(String isbn) {
		try {
			dao.beginTransaction();
			Livro livro = dao.buscarPorIsbn(isbn);
			dao.commitAndCloseTransaction();
			return livro;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public List<Livro> buscarPorAutor(String autor) {
		try {
			dao.beginTransaction();
			List<Livro> livros = dao.buscarPorAutor(autor);
			dao.commitAndCloseTransaction();
			return livros;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public List<Livro> buscarPorTitulo(String titulo) {
		try {
			dao.beginTransaction();
			List<Livro> livros = dao.buscarPorTitulo(titulo);
			dao.commitAndCloseTransaction();
			return livros;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public List<Livro> buscar(String autor, String titulo, String isbn) {
		try {
			dao.beginTransaction();
			List<Livro> livros = dao.buscar(autor, titulo, isbn);
			dao.commitAndCloseTransaction();
			return livros;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public List<Livro> buscarTodosLivros() {
		try {
			dao.beginTransaction();
			List<Livro> livros = dao.buscarLivros();
			dao.commitAndCloseTransaction();
			return livros;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	public boolean validarIsbn(String isbn) {
		try {
			dao.beginTransaction();
			boolean teste = dao.validarIsbn(isbn);
			dao.commitAndCloseTransaction();
			return teste;
		} catch (Exception e) {
			dao.rollbackAndCloseTransaction();
			throw e;
		}
	}

}
