package com.rafaelFerroPS.desafioLinkedRHBE.DTO;

import java.util.Date;

public class TurmaDTO {

	private int codigo;
    private Date inicio;
    private Date fim;
    private String local;
    private int cursoId;

    public TurmaDTO() {
    }

    public TurmaDTO(int codigo, Date inicio, Date fim, String local, int cursoId) {
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
	
}//TurmaDTO
