package up.biblioteca;

import java.util.List;

import up.biblioteca.bean.Livro;
import up.biblioteca.dao.GenericDAO;
import up.biblioteca.dao.LivroDAO;
import up.biblioteca.utils.DateUtils;

public class Main {

	public static void main(String[] args) {

		LivroDAO LivroDAO = new LivroDAO();
		try{
			LivroDAO.beginTransaction();
			List<Livro> livros = LivroDAO.buscarLivros();
			for (Livro l : livros){
				System.out.println(l.getTitulo());
				System.out.println("\t"+l.getAutor());
				System.out.println("\t"+l.getIsbn());
				System.out.println("\t"+DateUtils.dateToString(l.getPublicacao()));
			}
			
//			Livro livro = LivroDAO.buscarPorIsbn("8533613385");
//			System.out.println(livro.getTitulo());
//			System.out.println("\t"+livro.getAutor());
//			System.out.println("\t"+livro.getIsbn());
			
		}
		catch(Exception e){
			LivroDAO.rollbackAndCloseTransaction();
			e.printStackTrace();
		}
		finally{
			GenericDAO.fecharEntityManagerFactory();
			System.out.println("Fim!");
		}
	}

}
