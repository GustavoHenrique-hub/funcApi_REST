package br.edu.senaisp.FuncGerente.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Gerente {
	private Integer id;
	
	@NotNull
	@Size(min=2, max=30)
	private String nome;
	
	@NotNull
	@Size(min=2, max=30)
	private String cpf;
	
	@NotNull
	@Size(min=2, max=30)
	private String tel;
	
	@NotNull
	private Float salario;
	
	public Gerente() {
		
	}

	public Gerente(Integer id, String nome, String cpf, String tel, Float salario) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.tel = tel;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
	
}
