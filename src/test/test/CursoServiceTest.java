package com.rafaelFerroPS.desafioLinkedRHBE.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.rafaelFerroPS.desafioLinkedRHBE.DTO.CursoDTO;
import com.rafaelFerroPS.desafioLinkedRHBE.Repository.CursoRepository;
import com.rafaelFerroPS.desafioLinkedRHBE.model.Curso;
import com.rafaelFerroPS.desafioLinkedRHBE.service.CursoService;

public class CursoServiceTest {

	@Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void testGetAllCursos() {
        // Mocking the behavior of cursoRepository
        Curso curso1 = new Curso(1, "Curso 1", "Descrição 1", 40);
        Curso curso2 = new Curso(2, "Curso 2", "Descrição 2", 30);
        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso1, curso2));

        // Calling the service method
        List<CursoDTO> cursos = cursoService.getAllCursos();

        // Verifying the result
        assertEquals(2, cursos.size());
        assertEquals("Curso 1", cursos.get(0).getNome());
        assertEquals("Curso 2", cursos.get(1).getNome());
    }

    @Test
    void testCreateCurso() {
        // Creating mock input and output
        CursoDTO cursoDTO = new CursoDTO(0, "Novo Curso", "Nova Descrição", 50);
        Curso curso = new Curso(0, "Novo Curso", "Nova Descrição", 50);

        // Mocking save method
        when(cursoRepository.save(any(Curso.class))).thenReturn(curso);

        // Calling the service method
        CursoDTO savedCurso = cursoService.createCurso(cursoDTO);

        // Verifying the result
        assertNotNull(savedCurso);
        assertEquals("Novo Curso", savedCurso.getNome());
    }

    @Test
    void testUpdateCurso() {
        // Creating mock input and output
        CursoDTO cursoDTO = new CursoDTO(0, "Curso Atualizado", "Descrição Atualizada", 60);
        Curso curso = new Curso(0, "Curso Atualizado", "Descrição Atualizada", 60);

        // Mocking update method
        when(cursoRepository.update(any(Curso.class))).thenReturn(curso);

        // Calling the service method
        CursoDTO updatedCurso = cursoService.updateCurso(1, cursoDTO);

        // Verifying the result
        assertNotNull(updatedCurso);
        assertEquals("Curso Atualizado", updatedCurso.getNome());
    }

    @Test
    void testDeleteCurso() {
        // No return value for delete, so just verify interaction
        doNothing().when(cursoRepository).delete(anyInt());

        // Calling the service method
        cursoService.deleteCurso(1);

        // Verifying if delete was called
        verify(cursoRepository, times(1)).delete(1);
    }
	
}//CursoServiceTest
