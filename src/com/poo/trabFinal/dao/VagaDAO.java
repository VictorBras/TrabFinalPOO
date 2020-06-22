package com.poo.trabFinal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poo.trabFinal.classes.Dao;
import com.poo.trabFinal.models.Vaga;

public class VagaDAO extends Dao<Vaga> {

	public VagaDAO() {
		super();
		
		this.table = "Vaga";
		this.getAllSQL = "select * from Vaga";
		this.getAllEmpSQL = "select * from Vaga where idEmpresa = ?";
		this.readSQL = "select * from Vaga where id = ?";
		this.insertSQL = "insert into Vaga(cargo, descricao, idEmpresa) values (?, ?, ?)";
		this.updateSQL = "update Vaga set cargo = ?, descricao = ? where id = ?";
	}
	
	@Override
	protected void setStatementValues(PreparedStatement stmt, Vaga data) throws SQLException {
		stmt.setString(1, data.getCargo());
		stmt.setString(2, data.getDescricao());
		
		if(stmt.toString().equals("com.mysql.cj.jdbc.ClientPreparedStatement: update Vaga set cargo = '" + data.getCargo() + "', descricao = '" + data.getDescricao() + "' where id = ** NOT SPECIFIED **"))
		{
			stmt.setInt(3, data.getId());
		}
		else
		stmt.setInt(3, data.getIdEmpresa());
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
