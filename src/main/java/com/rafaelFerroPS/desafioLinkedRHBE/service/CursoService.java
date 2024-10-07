package com.rafaelFerroPS.desafioLinkedRHBE.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rafaelFerroPS.desafioLinkedRHBE.DTO.CursoDTO;
import com.rafaelFerroPS.desafioLinkedRHBE.Repository.CursoRepository;
import com.rafaelFerroPS.desafioLinkedRHBE.model.Curso;

@Service
public class CursoService {

	private final CursoRepository cursoRepository;

	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	public List<CursoDTO> getAllCursos() {
		List<Curso> cursos = cursoRepository.findAll();
		return cursos.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public CursoDTO createCurso(CursoDTO cursoDTO) {
		Curso curso = toEntity(cursoDTO);
		Curso savedCurso = cursoRepository.save(curso);
		return toDTO(savedCurso);
	}

	public CursoDTO updateCurso(int id, CursoDTO cursoDTO) {
		Curso curso = toEntity(cursoDTO);
		curso.setCodigo(id);
		Curso updatedCurso = cursoRepository.update(curso);
		return toDTO(updatedCurso);
	}

	public void deleteCurso(int id) {
		cursoRepository.delete(id);
	}

	private Curso toEntity(CursoDTO cursoDTO) {
		return new Curso(cursoDTO.getCodigo(), cursoDTO.getNome(), cursoDTO.getDescricao(), cursoDTO.getDuracao());
	}

	private CursoDTO toDTO(Curso curso) {
		return new CursoDTO(curso.getCodigo(), curso.getNome(), curso.getDescricao(), curso.getDuracao());
	}

}// CursoService
