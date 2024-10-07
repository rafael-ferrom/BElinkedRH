package com.rafaelFerroPS.desafioLinkedRHBE.model;

import java.util.Date;
import java.util.Objects;

public class Turma {

	private int codigo;
    private Date inicio;
    private Date fim;
    private String local;
    private int cursoId;  // Referência ao curso
    
    public Turma() {
    	
    }//turma

	public Turma(int codigo, Date inicio, Date fim, String local, int cursoId) {
		this.codigo = codigo;
		this.inicio = inicio;
		this.fim = fim;
		this.local = local;
		this.cursoId = cursoId;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, cursoId, fim, inicio, local);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return codigo == other.codigo && cursoId == other.cursoId && Objects.equals(fim, other.fim)
				&& Objects.equals(inicio, other.inicio) && Objects.equals(local, other.local);
	}
	
}//turma
