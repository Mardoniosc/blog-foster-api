package br.com.mardonio.foster.domain;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String conteudo;
	private Date createdAT;
	private Date updatedAT;
	
	public Post() {}

	public Post(Integer id, String titulo, String conteudo, Date createdAT, Date updatedAT) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.createdAT = createdAT;
		this.updatedAT = updatedAT;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
