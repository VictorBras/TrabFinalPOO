package com.poo.trabFinal.interfaces;

import java.sql.SQLException;

import com.poo.trabFinal.classes.Retorno;

public interface IDao<T> {
	public Retorno<T> getAll() throws SQLException;;

	public Retorno<T> read(int id) throws SQLException;;

	public Retorno<T> create(T data) throws SQLException;;

	public Retorno<T> update(int id, T data) throws SQLException;;

	public Retorno<T> delete(int id) throws SQLException;;
	
	public Retorno<T> deleteAll(int id) throws SQLException;;
}
