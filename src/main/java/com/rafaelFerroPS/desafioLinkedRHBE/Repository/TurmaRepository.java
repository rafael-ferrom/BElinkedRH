package com.rafaelFerroPS.desafioLinkedRHBE.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rafaelFerroPS.desafioLinkedRHBE.model.Turma;

@Repository
public class TurmaRepository {

	private final JdbcTemplate jdbcTemplate;

	public TurmaRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Turma> findByCursoId(int cursoId) {
		String sql = "SELECT * FROM Turma WHERE Curso = ?";
		return jdbcTemplate.query(sql, new TurmaRowMapper(), cursoId);
	}

	public Turma save(Turma turma) {
		String sql = "INSERT INTO Turma (Inicio, Fim, Local, Curso) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCursoId());
		return turma;
	}
	
	public Turma update(Turma turma) {
        String sql = "UPDATE Turma SET Inicio = ?, Fim = ?, Local = ? WHERE Codigo = ?";
        jdbcTemplate.update(sql, turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCodigo());
        return turma;
    }
	
	public void delete(int id) {
        String sql = "DELETE FROM Turma WHERE Codigo = ?";
        jdbcTemplate.update(sql, id);
    }

	private static class TurmaRowMapper implements RowMapper<Turma> {
		@Override
		public Turma mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Turma(rs.getInt("Codigo"), rs.getDate("Inicio"), rs.getDate("Fim"), rs.getString("Local"),
					rs.getInt("Curso"));
		}
	}

}// TurmaRepository
