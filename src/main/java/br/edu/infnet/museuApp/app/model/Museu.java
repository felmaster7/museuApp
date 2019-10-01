package br.edu.infnet.museuApp.app.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Museu {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String endereco;
	private String imagem;
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Obra> acervo = new HashSet<Obra>();
	

	public Museu() {
	}

	public Museu(String nome, String endereco, String imagem) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.imagem = imagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Obra> getAcervo() {
		return acervo;
	}

	public void setAcervo(Set<Obra> acervo) {
		this.acervo = acervo;
	}

	
}
