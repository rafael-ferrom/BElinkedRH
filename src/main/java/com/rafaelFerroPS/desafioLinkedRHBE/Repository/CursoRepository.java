package com.rafaelFerroPS.desafioLinkedRHBE.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rafaelFerroPS.desafioLinkedRHBE.model.Curso;

@Repository
public class CursoRepository {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public CursoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Curso> findAll() {
		String sql = "SELECT * FROM Curso";
		return jdbcTemplate.query(sql, new CursoRowMapper());
	}

	public Curso save(Curso curso) {
		String sql = "INSERT INTO Curso (Nome, Descricao, Duracao) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, curso.getNome(), curso.getDescricao(), curso.getDuracao());
		return curso;
	}

	public Curso update(Curso curso) {
		String sql = "UPDATE Curso SET Nome = ?, Descricao = ?, Duracao = ? WHERE Codigo = ?";
		jdbcTemplate.update(sql, curso.getNome(), curso.getDescricao(), curso.getDuracao(), curso.getCodigo());
		return curso;
	}
	
	public void delete(int id) {
        String sql = "DELETE FROM Curso WHERE Codigo = ?";
        jdbcTemplate.update(sql, id);
    }
	
	private static class CursoRowMapper implements RowMapper<Curso> {
        @Override
        public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Curso(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Descricao"), rs.getInt("Duracao"));
        }
    }

}// CursoRepository
