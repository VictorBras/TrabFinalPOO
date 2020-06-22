package com.poo.trabFinal.interfaces;

import java.sql.SQLException;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.models.Vaga;

public interface IController<T> {
	public Retorno<T> getAll() throws SQLException;;

	public Retorno<T> find(int id) throws SQLException;;

	public Retorno<T> insert(T data) throws SQLException;;

	public Retorno<T> update(int id, T data) throws SQLException;;

	public Retorno<T> delete(int id) throws SQLException;

}
