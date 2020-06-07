package com.poo.trabFinal.models;

import java.util.List;

public class Empresa {
	private String id;
	private String nome;
	private List<Vaga> vagas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public void addVagas(Vaga vaga) {
		this.addVagas(vaga);
	}
}
