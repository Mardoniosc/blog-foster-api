package br.com.mardonio.foster.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.mardonio.foster.domain.Post;

public class PostDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 80, message = "Tamanho deve ser entre 5 e 80 caracteres")
	private String titulo;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String conteudo;
	private Date createdAT;
	private Date updatedAT;
	
	public PostDTO() {}

	public PostDTO(Post obj) {
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
