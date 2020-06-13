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
		this.readSQL = "select * from candidato where id = ?";
		this.insertSQL = "insert into candidato(nome, idade, id) values (?, ?, ?)";
		this.updateSQL = "update candidato set nome = ?, idade = ? where id = ?";
		this.getAllSQL = "select * from candidato";
	}

	@Override
	protected void setStatementValues(PreparedStatement stmt, Candidato data) throws SQLException {
		stmt.setString(1, data.getNome());
		stmt.setInt(2, data.getIdade());
		stmt.setInt(3, data.getId());
	}

	@Override
	protected Candidato createObject(ResultSet rs) throws SQLException {
		Candidato candidato = new Candidato();
		
		candidato.setId(rs.getInt("id"));
		candidato.setNome(rs.getString("nome"));
		candidato.setIdade(rs.getInt("idade"));
		
		return candidato;
	}

}
