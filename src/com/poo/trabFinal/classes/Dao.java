package com.poo.trabFinal.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.poo.trabFinal.interfaces.IDao;

public abstract class Dao<T> implements IDao<T> {

	private Connection con;
	private String table;
	private String insertSQL;
	private String updateSQL;
	
	protected abstract void setStatementValues(PreparedStatement stmt, T data) throws SQLException;
	protected abstract T createObject(ResultSet rs) throws SQLException;
	
	public Dao(Connection con, String table, String insertSQL, String updateSQL) {
		this.con = con;
		this.table = table;
		this.insertSQL = insertSQL;
		this.updateSQL = updateSQL;
	}
	
	@Override
	public Retorno<T> getAll() throws SQLException {
		Retorno<T> retorno = new Retorno<T>();
		ResultSet rs = null;
		String sql = String.format("SELECT * FROM %s", this.table);
		
		try (Statement stmt = this.con.createStatement()) {
			rs = stmt.executeQuery(sql);
            
			while(rs.next()) {
				retorno.dataList.add(this.createObject(rs));
			}
			
			retorno.mensagem = "Dados retornados com sucesso";
			retorno.success = true;
		} catch (SQLException e) {
        	retorno.mensagem = "Falha ao retornar dados";
			retorno.success = false;
        }
		
		return retorno;
	}

	@Override
	public Retorno<T> read(String id) throws SQLException {
		Retorno<T> retorno = new Retorno<T>();
		ResultSet rs = null;
		String sql = String.format("DELETE FROM %s WHERE id = ?", this.table);
        
		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            
            retorno.data = this.createObject(rs);
            retorno.mensagem = "Dados retornados com sucesso";
			retorno.success = true;
        } catch (SQLException e) {
        	retorno.mensagem = "Falha ao encontrar dados";
			retorno.success = false;
        }
		
		return retorno;
	}

	@Override
	public Retorno<T> create(T data) throws SQLException {
		Retorno<T> retorno = new Retorno<T>();
		
		try (PreparedStatement stmt = this.con.prepareStatement(this.insertSQL)) {
			this.setStatementValues(stmt, data);
			stmt.executeUpdate();
			
			retorno.mensagem = "Dados inseridos com sucesso";
			retorno.success = true;
		} catch (SQLException e) {
			retorno.mensagem = "Falha na inserção dos dados";
			retorno.success = false;
		}
		return retorno;
	}

	@Override
	public Retorno<T> update(String id, T data) throws SQLException {
		Retorno<T> retorno = new Retorno<T>();
		
		try (PreparedStatement stmt = this.con.prepareStatement(this.updateSQL)) {
			this.setStatementValues(stmt, data);
            stmt.executeUpdate();
            
            retorno.mensagem = "Dados atualizados com sucesso";
			retorno.success = true;
		} catch (SQLException e) {
			retorno.mensagem = "Falha na atualização dos dados";
			retorno.success = false;
		}
		return retorno;
	}

	@Override
	public Retorno<T> delete(String id) throws SQLException {
		Retorno<T> retorno = new Retorno<T>();
		String sql = String.format("DELETE FROM %s WHERE id = ?", this.table);
		
		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
            
            retorno.mensagem = "Dados deletados com sucesso";
			retorno.success = true;
        } catch (SQLException e) {
        	retorno.mensagem = "Falha ao deletar dados";
			retorno.success = false;
        }
		return retorno;
	}

	
}
