package br.edu.senaisp.FuncGerente.dto;

public class FuncionarioDTO {
	private String nome;
	private String cpf;
	private Float salario;
	
	public FuncionarioDTO() {
		
	}

	public FuncionarioDTO(String nome, String cpf, Float salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	
}
