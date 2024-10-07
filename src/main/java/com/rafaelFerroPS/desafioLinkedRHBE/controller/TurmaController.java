package com.rafaelFerroPS.desafioLinkedRHBE.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelFerroPS.desafioLinkedRHBE.DTO.TurmaDTO;
import com.rafaelFerroPS.desafioLinkedRHBE.service.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

	private final TurmaService turmaService;

	public TurmaController(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	@GetMapping
	public ResponseEntity<List<TurmaDTO>> getTurmasByCurso(@PathVariable("cursoId") int cursoId) {
		List<TurmaDTO> turmas = turmaService.getTurmasByCurso(cursoId);
		return new ResponseEntity<>(turmas, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TurmaDTO> createTurma(@RequestBody TurmaDTO turmaDTO) {
		TurmaDTO novaTurma = turmaService.createTurma(turmaDTO);
		return new ResponseEntity<>(novaTurma, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TurmaDTO> updateTurma(@PathVariable("id") int id, @RequestBody TurmaDTO turmaDTO) {
		TurmaDTO turmaAtualizada = turmaService.updateTurma(id, turmaDTO);
		return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTurma(@PathVariable("id") int id) {
		turmaService.deleteTurma(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

}// TurmaController
