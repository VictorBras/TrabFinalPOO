package com.poo.trabFinal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poo.trabFinal.classes.Dao;
import com.poo.trabFinal.models.Candidato;

public class CandidatoDAO extends Dao<Candidato> {

	public CandidatoDAO() {
		super();
		
		this.table = "Candidato";
		this.readSQL = "select * from Candidato where id = ?";
		this.insertSQL = "insert into Candidato(nome, idade,email, id) values (?, ?, ?, ?)";
		this.updateSQL = "update Candidato set nome = ?, idade = ?, email = ? where id = ?";
		this.getAllSQL = "select * from Candidato";
	}

	@Override
	protected void setStatementValues(PreparedStatement stmt, Candidato data) throws SQLException {
		stmt.setString(1, data.getNome());
		stmt.setInt(2, data.getIdade());
		stmt.setString(3, data.getEmail());
		stmt.setInt(4, data.getId());
	}

	@Override
	protected Candidato createObject(ResultSet rs) throws SQLException {
		Candidato candidato = new Candidato();
		
		candidato.setId(rs.getInt("id"));
		candidato.setNome(rs.getString("nome"));
		candidato.setIdade(rs.getInt("idade"));
		candidato.setEmail(rs.getString("email"));
		
		return candidato;
	}

}
