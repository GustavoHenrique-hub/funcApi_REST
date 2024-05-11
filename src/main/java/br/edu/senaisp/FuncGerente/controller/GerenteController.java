package br.edu.senaisp.FuncGerente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.FuncGerente.model.Gerente;
import br.edu.senaisp.FuncGerente.repository.GerenteRepository;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

	@Autowired
	GerenteRepository repository;

	@GetMapping("/lista")
	public String lista() {
		StringBuffer strBuffer = new StringBuffer();

		for (Gerente gerentes : repository.lista()) {
			strBuffer.append(gerentes.getId() + ", ");
			strBuffer.append(gerentes.getNome() + ", ");
			strBuffer.append(gerentes.getCpf() + ", ");
			strBuffer.append(gerentes.getTel() + ", ");
			strBuffer.append(String.format(gerentes.getSalario() + "; \n"));
		}

		return strBuffer.toString();
	}

	@PostMapping("/insere")
	public String insere(@RequestBody Gerente gen) {
		int teste = repository.insere(gen);

		if (teste != 0) {
			return "Gerente inserido com sucesso!";
		} else {
			return "ERRO: Gerente não inserido!";
		}
	}

	@PutMapping("/altera/{id}")
	public String altera(@RequestBody Gerente gen, @PathVariable Integer id) {
		int teste = repository.altera(gen, id);

		if (teste != 0) {
			return "Gerente alterado com sucesso!";
		} else {
			return "ERRO: Gerente não alterado!";
		}
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		int teste = repository.delete(id);

		if (teste != 0) {
			return "Gerente deletado com sucesso!";
		} else {
			return "ERRO: Gerente não deletado!";
		}
	}

	@GetMapping("/busca/{id}")
	public Gerente busca(@PathVariable Integer id) {
		return repository.buscaPorId(id);
	}

}
