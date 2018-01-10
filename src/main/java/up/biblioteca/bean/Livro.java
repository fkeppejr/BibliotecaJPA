package up.biblioteca.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Livro")
public class Livro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLivro;
	@Column(length=200, nullable=false)
	private String titulo;
	@Column(length=200, nullable=false)
	private String autor;
	@Column(length=50, nullable=false)
	private String isbn;
	@Column(nullable=false)
	private int paginas;
	@Column(nullable=false)
	private double valor;
	@Column(nullable=false)
	private Date publicacao;
	@Column(nullable=false)
	private int quantidade;
	
	public int getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getPaginas() {
		return paginas;
	}
	
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getPublicacao() {
		return publicacao;
	}
	
	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLivro;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (idLivro != other.idLivro)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", paginas="
				+ paginas + ", valor=" + valor + ", publicacao=" + publicacao + ", quantidade=" + quantidade + "]";
	}
}
