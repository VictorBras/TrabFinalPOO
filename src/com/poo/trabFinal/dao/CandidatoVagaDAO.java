package com.poo.trabFinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poo.trabFinal.classes.Dao;
import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.jdbc.ConnectionFactory;
import com.poo.trabFinal.models.CandidatoVaga;

public class CandidatoVagaDAO extends Dao<CandidatoVaga>{
	
	public CandidatoVagaDAO() {
		super();
		
		this.table = "CandidatoVaga";
		this.getAllSQL = "select * from CandidatoVaga";
		this.getAllEmpSQL = "select * from CandidatoVaga where idCandidato = ?";
		this.readSQL = "select * from CandidatoVaga where idCandidato = ? and idVaga = ?";
		this.insertSQL = "insert into CandidatoVaga(idCandidato, idVaga) values (?, ?)";
		this.updateSQL = "update Vaga set cargo = ?, descricao = ? where id = ?";
		this.deleteAllSQL = "delete from CandidatoVaga where idCandidato = ?";
	}

	@Override
	protected void setStatementValues(PreparedStatement stmt, CandidatoVaga data) throws SQLException {
		stmt.setInt(1,data.getIdCandidato());
		stmt.setInt(2, data.getIdVaga());
		
	}

	@Override
	protected CandidatoVaga createObject(ResultSet rs) throws SQLException {
		
		CandidatoVaga candVaga = new CandidatoVaga();
		candVaga.setId(rs.getInt("id"));
		candVaga.setIdCandidato(rs.getInt("idCandidato"));
		candVaga.setIdVaga(rs.getInt("idVaga"));
		
		return candVaga;
	}

	public Retorno<CandidatoVaga> read(int idCandidato, int idVaga) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
		
		try {
			stmt = con.prepareStatement(this.readSQL);
			stmt.setInt(1, idCandidato);
			stmt.setInt(2, idVaga);
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				retorno.data = this.createObject(rs);
			}
			if(retorno.data == null)
			{
				retorno.mensagem = "Falha ao encontrar dados";
				retorno.success = false;
			}
			else
			{
				retorno.mensagem = "Dados retornados com sucesso";
				retorno.success = true;
			}
		} catch (SQLException e) {
			retorno.mensagem = "Falha ao encontrar dados";
			retorno.success = false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return retorno;
	}





}
