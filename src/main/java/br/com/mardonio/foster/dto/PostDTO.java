package br.com.mardonio.foster.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.mardonio.foster.domain.Post;

public class PostDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String conteudo;
	private Date createdAT;
	private Date updatedAT;
	
	public PostDTO() {}

	public PostDTO(Post obj) {
		super();
		id = obj.getId();
		titulo = obj.getTitulo();
		conteudo = obj.getConteudo();
		createdAT = obj.getCreatedAT();
		updatedAT = obj.getUpdatedAT();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getCreatedAT() {
		return createdAT;
	}

	public void setCreatedAT(Date createdAT) {
		this.createdAT = createdAT;
	}

	public Date getUpdatedAT() {
		return updatedAT;
	}

	public void setUpdatedAT(Date updatedAT) {
		this.updatedAT = updatedAT;
	}
	
	

}
