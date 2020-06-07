package com.poo.trabFinal.interfaces;

import java.sql.SQLException;

import com.poo.trabFinal.classes.Retorno;

public interface IDao<T> {
	public Retorno<T> getAll() throws SQLException;;

	public Retorno<T> read(String id) throws SQLException;;

	public Retorno<T> create(T data) throws SQLException;;

	public Retorno<T> update(String id, T data) throws SQLException;;

	public Retorno<T> delete(String id) throws SQLException;;
}
