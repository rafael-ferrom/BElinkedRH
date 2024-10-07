package com.rafaelFerroPS.desafioLinkedRHBE.model;

import java.util.Objects;

public class Curso {

	private int codigo;
	private String nome;
	private String descricao;
	private int duracao;
	
	public Curso() {
		
	}

	public Curso(int codigo, String nome, String descricao, int duracao) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricao, duracao, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return codigo == other.codigo && Objects.equals(descricao, other.descricao) && duracao == other.duracao
				&& Objects.equals(nome, other.nome);
	}
	
	

}// curso
