package br.edu.senaisp.FuncGerente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.FuncGerente.model.Funcionario;
import br.edu.senaisp.FuncGerente.repository.FuncRepository;

@RestController
@RequestMapping("/funcNovo")
public class FuncController {

	@Autowired
	FuncRepository repository;

	@GetMapping("/lista")
	public String listar() {
		StringBuffer strBuffer = new StringBuffer();

		for (Funcionario funcs : repository.lista()) {
			strBuffer.append(funcs.getId() + ", ");
			strBuffer.append(funcs.getNome() + ", ");
			strBuffer.append(funcs.getCpf() + ", ");
			strBuffer.append(funcs.getTel() + ", ");
			strBuffer.append(String.format(funcs.getSalario() + " \n"));
		}

		return strBuffer.toString();

	}

	@GetMapping("/busca/{id}")
	public String buscaPorId(@PathVariable Integer id) {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(String.format(repository.buscaPorId(id).getNome() + " \n"));
		strBuffer.append(String.format(repository.buscaPorId(id).getCpf() + " \n"));
		strBuffer.append(String.format(repository.buscaPorId(id).getTel() + " \n"));
		strBuffer.append(String.format(repository.buscaPorId(id).getSalario() + " \n"));

		return strBuffer.toString();

	}

	@PostMapping("/insere")
	public ResponseEntity<Funcionario> insere(@RequestBody Funcionario func) {
		int teste = repository.insere(func);

		if (func.getNome().replace(" ", "").equals("") && teste != 0)
			return (ResponseEntity<Funcionario>) ResponseEntity.status(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(func);

	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody Funcionario func, @PathVariable Integer id) {
		int teste = repository.update(func, id);

		if (teste != 0) {
			return "Funcionário atualizado com sucesso!";
		} else {
			return "ERRO: Funcionário não foi atualizado!";
		}

	}

	@DeleteMapping("/delete/{id}")
	public String update(@PathVariable Integer id) {
		int teste = repository.delete(id);

		if (teste != 0) {
			return "Funcionário deletado com sucesso!";
		} else {
			return "ERRO: Funcionário não foi deletado!";
		}

	}
}
