package com.poo.trabFinal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poo.trabFinal.classes.Dao;
import com.poo.trabFinal.models.Candidato;

public class CandidatoDAO extends Dao<Candidato> {

	public CandidatoDAO() {
		super();
		
		this.table = "candidato";
		this.insertSQL = "insert into candidato(nome, idade, id) values (?, ?, ?)";
		this.updateSQL = "update candidato set nome = ?, idade = ? where id = ?";	
	}

	@Override
	protected void setStatementValues(PreparedStatement stmt, Candidato data) throws SQLException {
		stmt.setString(1, data.getNome());
		stmt.setInt(2, data.getIdade());
		stmt.setString(3, data.getId());
	}

	@Override
	protected Candidato createObject(ResultSet rs) throws SQLException {
		Candidato candidato = new Candidato();
		
		candidato.setId(rs.getString("id"));
		candidato.setNome(rs.getString("nome"));
		candidato.setIdade(rs.getInt("idade"));
		
		return candidato;
	}

}
