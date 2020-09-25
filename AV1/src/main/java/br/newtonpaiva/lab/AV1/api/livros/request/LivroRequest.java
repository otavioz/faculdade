package br.newtonpaiva.lab.AV1.api.livros.request;

import java.util.Date;

import br.newtonpaiva.lab.AV1.domain.entity.Livro;
import lombok.Data;
import lombok.With;

@Data
@With
public class LivroRequest {
	
	private String id;
	private String titulo;
	private String autor;
	private String editora;
	private Date dataDePublicacao;
	private int status;
	
	
	public LivroRequest(String id, String titulo, String autor, String editora, Date dataDePublicacao, int status) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.dataDePublicacao = dataDePublicacao;
		this.status = status;
	}
	

	public LivroRequest(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getEditora();
		this.editora = livro.getEditora();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.status = livro.getStatus();
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}
	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
