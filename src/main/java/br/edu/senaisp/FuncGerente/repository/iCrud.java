package br.edu.senaisp.FuncGerente.repository;

import java.util.List;

import br.edu.senaisp.FuncGerente.model.Funcionario;

public interface iCrud {
	public List<Funcionario> lista();
	
	public int insere(Funcionario func);
	public int update(Funcionario func, Integer id);
	public int delete(Integer id);
	
	public Funcionario buscaPorId(Integer id);
}
