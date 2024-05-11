package br.edu.senaisp.FuncGerente.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.FuncGerente.model.Gerente;

@Repository
public class GerenteRepository implements iCrudGerente{

	private String qrSelectAll = "SELECT id, nome, cpf, tel, salario FROM gerente";
	private String qrInsert = "INSERT INTO gerente (nome, cpf, tel, salario) VALUES (?, ?, ?, ?)";
	private String qrUpdate = "UPDATE gerente SET nome = ?, cpf = ?, tel = ?, salario = ? WHERE id = ?";
	private String qrDelete = "DELETE FROM gerente WHERE id = ?";
	private String qrSelectById = "SELECT id, nome, cpf, tel, salario FROM gerente WHERE id = ?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Gerente> lista() {
		return jdbcTemplate.query(qrSelectAll, (rs, rowNum) -> {
			return new Gerente(
					rs.getInt("id"),
					rs.getString("nome"),
					rs.getString("cpf"),
					rs.getString("tel"),
					rs.getFloat("salario"));
		});
	}

	@Override
	public int insere(Gerente gen) {
		Object[] params = {gen.getNome(), gen.getCpf(), gen.getTel(), gen.getSalario()};
		
		return jdbcTemplate.update(qrInsert, params);
	}

	@Override
	public int altera(Gerente gen, Integer id) {
		Object[] params = {gen.getNome(), gen.getCpf(), gen.getTel(), gen.getSalario(), id};
		
		return jdbcTemplate.update(qrUpdate, params);
	}

	@Override
	public int delete(Integer id) {
		Object[] params = {id};
		
		return jdbcTemplate.update(qrDelete, params);
	}

	@Override
	public Gerente buscaPorId(Integer id) {
		Object[] params = {id};
		
		return jdbcTemplate.queryForObject(qrSelectById, params, (rs, rowNum) -> {
			return new Gerente(
					rs.getInt("id"),
					rs.getString("nome"),
					rs.getString("cpf"),
					rs.getString("tel"),
					rs.getFloat("salario"));
		});
	}

}
