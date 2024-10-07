package com.rafaelFerroPS.desafioLinkedRHBE.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rafaelFerroPS.desafioLinkedRHBE.Repository.TurmaRepository;
import com.rafaelFerroPS.desafioLinkedRHBE.model.Turma;

public class TurmaServiceTest {
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    private TurmaRepository turmaRepository;

	    @BeforeEach
	    void setUp() {
	        turmaRepository = new TurmaRepository(jdbcTemplate);
	        // Insira dados de teste no banco de dados em memória
	        jdbcTemplate.update("INSERT INTO Curso (Codigo, Nome, Descricao, Duracao) VALUES (1, 'Curso 1', 'Desc 1', 40)");
	        jdbcTemplate.update("INSERT INTO Turma (Codigo, Inicio, Fim, Local, Curso) VALUES (1, '2024-01-01', '2024-01-10', 'Sala A', 1)");
	    }

	    @Test
	    void testFindByCursoId() {
	        // Execute a consulta
	        List<Turma> turmas = turmaRepository.findByCursoId(1);

	        // Verifique os resultados
	        assertEquals(1, turmas.size());
	        assertEquals("Sala A", turmas.get(0).getLocal());
	    }

	    @Test
	    void testSaveTurma() {
	        // Cria uma nova turma
	        Turma turma = new Turma(0, new Date(), new Date(), "Sala B", 1);
	        Turma savedTurma = turmaRepository.save(turma);

	        // Verifica se a turma foi salva corretamente
	        assertNotNull(savedTurma);
	        assertEquals("Sala B", savedTurma.getLocal());
	    }

	    @Test
	    void testUpdateTurma() {
	        // Atualiza uma turma existente
	        Turma turma = new Turma(1, new Date(), new Date(), "Sala C", 1);
	        Turma updatedTurma = turmaRepository.update(turma);

	        // Verifica se a turma foi atualizada corretamente
	        assertEquals("Sala C", updatedTurma.getLocal());
	    }

	    @Test
	    void testDeleteTurma() {
	        // Deleta uma turma existente
	        turmaRepository.delete(1);

	        // Verifica se foi deletado corretamente (não deve mais encontrar a turma)
	        List<Turma> turmas = turmaRepository.findByCursoId(1);
	        assertEquals(0, turmas.size());
	    }

}//TurmaServiceTest
