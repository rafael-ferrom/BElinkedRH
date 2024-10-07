package com.rafaelFerroPS.desafioLinkedRHBE.model;

import java.util.Objects;

public class TurmaParticipante {

    private int codigo;
    private int turmaId;
    private int funcionarioId;
    
    public TurmaParticipante() {
    	
    }//turmaparticpante

	public TurmaParticipante(int codigo, int turmaId, int funcionarioId) {
		this.codigo = codigo;
		this.turmaId = turmaId;
		this.funcionarioId = funcionarioId;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}

	public int getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(int funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, funcionarioId, turmaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurmaParticipante other = (TurmaParticipante) obj;
		return codigo == other.codigo && funcionarioId == other.funcionarioId && turmaId == other.turmaId;
	}
    
    
	
}//turmaParticipante
