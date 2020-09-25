package br.newtonpaiva.lab.AV1.domain.entity;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;


public class Livro {
	private String id;
	private String titulo;
	private String autor;
	private String editora;
	private Date dataDePublicacao;
	private int status;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
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
	public static Livro get(String string) {
		
		Date date = new Date();
		return new Livro("IDLivro", "TituloLivro", "Autor", "EditoraLivro", date, 0);
	}
	
	public Livro(String id, String titulo, String autor, String editora, Date dataDePublicacao, int status) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.dataDePublicacao = dataDePublicacao;
		this.status = status;
	}
	public void setCreated(LocalDateTime now) {
		this.createdAt = now;
		
	}
	public void setModified(LocalDateTime now) {
		this.modifiedAt = now;
		
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}
}
