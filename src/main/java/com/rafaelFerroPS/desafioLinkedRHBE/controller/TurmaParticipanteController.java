package com.rafaelFerroPS.desafioLinkedRHBE.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelFerroPS.desafioLinkedRHBE.DTO.TurmaParticipanteDTO;
import com.rafaelFerroPS.desafioLinkedRHBE.service.TurmaParticipanteService;

@RestController
@RequestMapping("/turmas/{turmaId}/participantes")
public class TurmaParticipanteController {

	private final TurmaParticipanteService turmaParticipanteService;

	public TurmaParticipanteController(TurmaParticipanteService turmaParticipanteService) {
		this.turmaParticipanteService = turmaParticipanteService;
	}

	@GetMapping
	public ResponseEntity<List<TurmaParticipanteDTO>> getAllParticipantes(@PathVariable("turmaId") int turmaId) {
		List<TurmaParticipanteDTO> participantes = turmaParticipanteService.getAllParticipantes(turmaId);
		return new ResponseEntity<>(participantes, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TurmaParticipanteDTO> addParticipante(@PathVariable("turmaId") int turmaId,
			@RequestBody TurmaParticipanteDTO participanteDTO) {
		TurmaParticipanteDTO novoParticipante = turmaParticipanteService.addParticipante(turmaId, participanteDTO);
		return new ResponseEntity<>(novoParticipante, HttpStatus.CREATED);
	}

	@DeleteMapping("/{participanteId}")
	public ResponseEntity<Void> removeParticipante(@PathVariable("turmaId") int turmaId,
			@PathVariable("participanteId") int participanteId) {
		turmaParticipanteService.removeParticipante(turmaId, participanteId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}// TurmaParticipanteController
