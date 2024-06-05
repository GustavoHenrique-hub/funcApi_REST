package br.edu.senaisp.FuncGerente.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.FuncGerente.model.Funcionario;

@Repository
public class FuncRepository implements iCrudFunc{
	
	private String qrSelectAll = "SELECT id, nome, cpf, tel, salario FROM funcionario";
	private String qrInsert = "INSERT INTO funcionario (nome, cpf, tel, salario) VALUES (?, ?, ?, ?)";
	private String qrUpdate = "UPDATE funcionario SET nome = ?, cpf = ?, tel = ?, salario = ? WHERE id = ?";
	private String qrDelete = "DELETE FROM funcionario WHERE id = ?";
	private String qrSelectById = "SELECT id, nome, cpf, tel, salario FROM funcionario WHERE id = ?";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Funcionario> lista() {
		return jdbcTemplate.query(qrSelectAll, (rs, rowNum) -> {
			return new Funcionario(
					rs.getInt("id"),
					rs.getString("nome"),
					rs.getString("cpf"),
					rs.getString("tel"),
					rs.getFloat("salario"));
		});
	}

	@Override
	public int insere(Funcionario func) {
		Object[] params = {func.getNome(), func.getCpf(), func.getTel(), func.getSalario()};
		return jdbcTemplate.update(qrInsert, params);
	}

	@Override
	public int update(Funcionario func, Integer id) {
		Object[] params = {func.getNome(), func.getCpf(), func.getTel(), func.getSalario(), id};
		return jdbcTemplate.update(qrUpdate, params);
	}

	@Override
	public int delete(Integer id) {
		Object[] params = {id};
		return jdbcTemplate.update(qrDelete, params);
	}

	@Override
	public Funcionario buscaPorId(Integer id) {
		Object[] params = {id};
		
		return jdbcTemplate.queryForObject(qrSelectById, params,(rs, rowNum) -> {
			return new Funcionario(
					rs.getInt("id"),
					rs.getString("nome"),
					rs.getString("cpf"),
					rs.getString("tel"),
					rs.getFloat("salario"));
		});
	}

}
