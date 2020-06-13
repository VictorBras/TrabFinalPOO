package com.poo.trabFinal.models;

public class Vaga {
	private int id;
	private String cargo;
	private String descricao;
	private int IdEmpresa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdEmpresa() {
		return IdEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		IdEmpresa = idEmpresa;
	}

}
