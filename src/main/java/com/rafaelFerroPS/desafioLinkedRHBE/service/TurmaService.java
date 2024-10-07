package com.rafaelFerroPS.desafioLinkedRHBE.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rafaelFerroPS.desafioLinkedRHBE.DTO.TurmaDTO;
import com.rafaelFerroPS.desafioLinkedRHBE.Repository.TurmaRepository;
import com.rafaelFerroPS.desafioLinkedRHBE.model.Turma;

@Service
public class TurmaService {

	private final TurmaRepository turmaRepository;

	public TurmaService(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}

	public List<TurmaDTO> getTurmasByCurso(int cursoId) {
		List<Turma> turmas = turmaRepository.findByCursoId(cursoId);
		return turmas.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public TurmaDTO createTurma(TurmaDTO turmaDTO) {
		Turma turma = toEntity(turmaDTO);
		Turma savedTurma = turmaRepository.save(turma);
		return toDTO(savedTurma);
	}

	public TurmaDTO updateTurma(int id, TurmaDTO turmaDTO) {
		Turma turma = toEntity(turmaDTO);
		turma.setCodigo(id);
		Turma updatedTurma = turmaRepository.update(turma);
		return toDTO(updatedTurma);
	}

	public void deleteTurma(int id) {
		turmaRepository.delete(id);
	}

	private Turma toEntity(TurmaDTO turmaDTO) {
		return new Turma(turmaDTO.getCodigo(), turmaDTO.getInicio(), turmaDTO.getFim(), turmaDTO.getLocal(),
				turmaDTO.getCursoId());
	}

	private TurmaDTO toDTO(Turma turma) {
		return new TurmaDTO(turma.getCodigo(), turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCursoId());
	}

}// TurmaService
