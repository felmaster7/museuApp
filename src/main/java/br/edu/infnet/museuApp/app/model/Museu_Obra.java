package br.edu.infnet.museuApp.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Museu_Obra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer acervo_id;
	
	private Integer Museu_id;
	
	
	public Museu_Obra() {
		// TODO Auto-generated constructor stub
	}
	
	public Museu_Obra(Integer obra, Integer museu) {
		this.acervo_id=obra;
		this.Museu_id=museu;
	}
	
	public Integer getMuseu_id() {
		return Museu_id;
	}
	public void setMuseu_id(Integer museu_id) {
		Museu_id = museu_id;
	}
	public Integer getAcervo_id() {
		return acervo_id;
	}
	public void setAcervo_id(Integer acervo_id) {
		this.acervo_id = acervo_id;
	}
	
	
	
	
}
