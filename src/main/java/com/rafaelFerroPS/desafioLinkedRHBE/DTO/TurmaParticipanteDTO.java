package com.rafaelFerroPS.desafioLinkedRHBE.DTO;

public class TurmaParticipanteDTO {
	
	private int codigo;
    private int turmaId;
    private int funcionarioId;

    public TurmaParticipanteDTO() {
    }

    public TurmaParticipanteDTO(int codigo, int turmaId, int funcionarioId) {
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

}//TurmaParticipanteDTO
