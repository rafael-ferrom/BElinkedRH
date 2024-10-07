package com.rafaelFerroPS.desafioLinkedRHBE.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rafaelFerroPS.desafioLinkedRHBE.DTO.TurmaParticipanteDTO;
import com.rafaelFerroPS.desafioLinkedRHBE.Repository.TurmaParticipanteRepository;
import com.rafaelFerroPS.desafioLinkedRHBE.model.TurmaParticipante;

@Service
public class TurmaParticipanteService {

	private final TurmaParticipanteRepository turmaParticipanteRepository;

	public TurmaParticipanteService(TurmaParticipanteRepository turmaParticipanteRepository) {
		this.turmaParticipanteRepository = turmaParticipanteRepository;
	}

	public List<TurmaParticipanteDTO> getAllParticipantes(int turmaId) {
		List<TurmaParticipante> participantes = turmaParticipanteRepository.findByTurmaId(turmaId);
		return participantes.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public TurmaParticipanteDTO addParticipante(int turmaId, TurmaParticipanteDTO participanteDTO) {
		TurmaParticipante participante = toEntity(participanteDTO);
		participante.setTurmaId(turmaId);
		TurmaParticipante savedParticipante = turmaParticipanteRepository.save(participante);
		return toDTO(savedParticipante);
	}

	public void removeParticipante(int turmaId, int funcionarioId) {
		turmaParticipanteRepository.deleteByTurmaAndFuncionario(turmaId, funcionarioId);
	}

	private TurmaParticipante toEntity(TurmaParticipanteDTO participanteDTO) {
		return new TurmaParticipante(participanteDTO.getCodigo(), participanteDTO.getTurmaId(),
				participanteDTO.getFuncionarioId());
	}

	private TurmaParticipanteDTO toDTO(TurmaParticipante participante) {
		return new TurmaParticipanteDTO(participante.getCodigo(), participante.getTurmaId(),
				participante.getFuncionarioId());
	}

}// TurmaParticipanteService
