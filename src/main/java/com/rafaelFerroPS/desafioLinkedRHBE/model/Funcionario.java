package com.rafaelFerroPS.desafioLinkedRHBE.model;

import java.util.Date;
import java.util.Objects;

public class Funcionario {

	private int codigo;
    private String nome;
    private String cpf;
    private Date nascimento;
    private String cargo;
    private Date admissao;
    private boolean status;
    
    public Funcionario() {
    	
    }//funcionario

	public Funcionario(int codigo, String nome, String cpf, Date nascimento, String cargo, Date admissao,
			boolean status) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.cargo = cargo;
		this.admissao = admissao;
		this.status = status;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(admissao, cargo, codigo, cpf, nascimento, nome, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(admissao, other.admissao) && Objects.equals(cargo, other.cargo) && codigo == other.codigo
				&& Objects.equals(cpf, other.cpf) && Objects.equals(nascimento, other.nascimento)
				&& Objects.equals(nome, other.nome) && status == other.status;
	}
    
    
	
}//funcionario
