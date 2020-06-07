package com.poo.trabFinal.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poo.trabFinal.interfaces.IDao;
import com.poo.trabFinal.jdbc.ConnectionFactory;

public abstract class Dao<T> implements IDao<T> {

	protected String table;
	protected String insertSQL;
	protected String updateSQL;

	protected abstract void setStatementValues(PreparedStatement stmt, T data) throws SQLException;

	protected abstract T createObject(ResultSet rs) throws SQLException;

	@Override
	public Retorno<T> getAll() throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = String.format("SELECT * FROM %s", this.table);
		ResultSet rs = null;
		Retorno<T> retorno = new Retorno<T>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				retorno.dataList.add(this.createObject(rs));
			}

			retorno.mensagem = "Dados retornados com sucesso";
			retorno.success = true;
		} catch (SQLException e) {
			retorno.mensagem = "Falha ao retornar dados";
			retorno.success = false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return retorno;
	}

	@Override
	public Retorno<T> read(String id) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = String.format("DELETE FROM %s WHERE id = ?", this.table);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Retorno<T> retorno = new Retorno<T>();

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			retorno.data = this.createObject(rs);
			retorno.mensagem = "Dados retornados com sucesso";
			retorno.success = true;
		} catch (SQLException e) {
			retorno.mensagem = "Falha ao encontrar dados";
			retorno.success = false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return retorno;
	}

	@Override
	public Retorno<T> create(T data) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Retorno<T> retorno = new Retorno<T>();

		try {
			stmt = con.prepareStatement(this.insertSQL);
			this.setStatementValues(stmt, data);
			stmt.executeUpdate();

			retorno.mensagem = "Dados inseridos com sucesso";
			retorno.success = true;
		} catch (SQLException e) {
			retorno.mensagem = "Falha na inserção dos dados";
			retorno.success = false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return retorno;
	}

	@Override
	public Retorno<T> update(String id, T data) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Retorno<T> retorno = new Retorno<T>();

		try {
			stmt = con.prepareStatement(this.updateSQL);
			this.setStatementValues(stmt, data);
			stmt.executeUpdate();

			retorno.mensagem = "Dados atualizados com sucesso";
			retorno.success = true;
		} catch (SQLException e) {
			retorno.mensagem = "Falha na atualização dos dados";
			retorno.success = false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return retorno;
	}

	@Override
	public Retorno<T> delete(String id) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = String.format("DELETE FROM %s WHERE id = ?", this.table);
		Retorno<T> retorno = new Retorno<T>();

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();

			retorno.mensagem = "Dados deletados com sucesso";
			retorno.success = true;
		} catch (SQLException e) {
			retorno.mensagem = "Falha ao deletar dados";
			retorno.success = false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

		return retorno;
	}

}
