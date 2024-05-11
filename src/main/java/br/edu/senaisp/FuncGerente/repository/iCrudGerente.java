package br.edu.senaisp.FuncGerente.repository;

import java.util.List;

import br.edu.senaisp.FuncGerente.model.Gerente;

public interface iCrudGerente {
	
	public List<Gerente> lista();
	
	public int insere(Gerente gen);
	public int altera(Gerente gen, Integer id);
	public int delete(Integer id);
	
	public Gerente buscaPorId(Integer id);
}
