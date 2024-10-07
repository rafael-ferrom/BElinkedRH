package com.rafaelFerroPS.desafioLinkedRHBE.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rafaelFerroPS.desafioLinkedRHBE.model.TurmaParticipante;

@Repository
public class TurmaParticipanteRepository {

	private final JdbcTemplate jdbcTemplate;

    public TurmaParticipanteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<TurmaParticipante> findByTurmaId(int turmaId) {
        String sql = "SELECT * FROM TurmaParticipante WHERE Turma = ?";
        return jdbcTemplate.query(sql, new TurmaParticipanteRowMapper(), turmaId);
    }
    
    public TurmaParticipante save(TurmaParticipante participante) {
        String sql = "INSERT INTO TurmaParticipante (Turma, Funcionario) VALUES (?, ?)";
        jdbcTemplate.update(sql, participante.getTurmaId(), participante.getFuncionarioId());
        return participante;
    }
    
    public void deleteByTurmaAndFuncionario(int turmaId, int funcionarioId) {
        String sql = "DELETE FROM TurmaParticipante WHERE Turma = ? AND Funcionario = ?";
        jdbcTemplate.update(sql, turmaId, funcionarioId);
    }
    
    private static class TurmaParticipanteRowMapper implements RowMapper<TurmaParticipante> {
        @Override
        public TurmaParticipante mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new TurmaParticipante(rs.getInt("Codigo"), rs.getInt("Turma"), rs.getInt("Funcionario"));
        }
    }
	
}//TurmaParticipanteRepository
