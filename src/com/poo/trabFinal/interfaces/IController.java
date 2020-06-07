package com.poo.trabFinal.interfaces;

import com.poo.trabFinal.classes.Retorno;

public interface IController<T> {
	public Retorno<T> getAll();

	public Retorno<T> find(String id);

	public Retorno<T> insert(T data);

	public Retorno<T> update(String id, T data);

	public Retorno<T> delete(String id);
}
