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

import com.rafaelFerroPS.desafioLinkedRHBE.DTO.CursoDTO;
import com.rafaelFerroPS.desafioLinkedRHBE.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAllCursos() {
        List<CursoDTO> cursos = cursoService.getAllCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<CursoDTO> createCurso(@RequestBody CursoDTO cursoDTO) {
        CursoDTO novoCurso = cursoService.createCurso(cursoDTO);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable("id") int id, @RequestBody CursoDTO cursoDTO) {
        CursoDTO cursoAtualizado = cursoService.updateCurso(id, cursoDTO);
        return new ResponseEntity<>(cursoAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable("id") int id) {
        cursoService.deleteCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
}
