package com.poo.trabFinal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.poo.trabFinal.classes.Dao;
import com.poo.trabFinal.models.Empresa;
import com.poo.trabFinal.models.Vaga;

public class EmpresaDAO extends Dao<Empresa> {

	public EmpresaDAO() {
		super();
		
		this.table = "Empresa";
		this.getAllSQL = "select * from Empresa";
		this.readSQL = "select * from Empresa where id = ?";
		this.insertSQL = "insert into Empresa(nome,endereco,email, id) values (? , ?, ?, ?)";
		this.updateSQL = "update Empresa set nome = ?, endereco = ?, email = ? where id = ?";
	}

	@Override
	protected void setStatementValues(PreparedStatement stmt, Empresa data) throws SQLException {
		stmt.setString(1, data.getNome());
		stmt.setString(2, data.getEndereco());
		stmt.setString(3, data.getEmail());
		stmt.setInt(4, data.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Empresa createObject(ResultSet rs) throws SQLException {
		Empresa empresa = new Empresa();
		
		empresa.setId(rs.getInt("id"));
		empresa.setNome(rs.getString("nome"));
		empresa.setEndereco(rs.getString("endereco"));
		empresa.setEmail(rs.getString("email"));
		//empresa.setVagas((List<Vaga>) rs.getObject("vagas"));
		
		return empresa;
	}

}
