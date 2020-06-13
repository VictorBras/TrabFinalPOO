package com.poo.trabFinal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poo.trabFinal.classes.Dao;
import com.poo.trabFinal.models.Vaga;

public class VagaDAO extends Dao<Vaga> {

	public VagaDAO() {
		super();
		
		this.table = "vaga";
		this.getAllSQL = "select * from vaga";
		this.readSQL = "select * from vaga where id = ?";
		this.insertSQL = "insert into vaga(cargo, descricao, idEmpresa) values (?, ?, ?)";
		this.updateSQL = "update vaga set cargo = ?, descricao = ?, idEmpresa = ? where id = ?";
	}
	
	@Override
	protected void setStatementValues(PreparedStatement stmt, Vaga data) throws SQLException {
		stmt.setString(1, data.getCargo());
		stmt.setString(2, data.getDescricao());
		stmt.setInt(3, data.getIdEmpresa());
		stmt.setInt(4, data.getId());
	}

	@Override
	protected Vaga createObject(ResultSet rs) throws SQLException {
		Vaga vaga = new Vaga();
		
		vaga.setId(rs.getInt("id"));
		vaga.setIdEmpresa(rs.getInt("idEmpresa"));
		vaga.setCargo(rs.getString("cargo"));
		vaga.setDescricao(rs.getString("descricao"));
		
		return vaga;
	}

}
