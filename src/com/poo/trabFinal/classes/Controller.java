package com.poo.trabFinal.classes;

import com.poo.trabFinal.interfaces.IController;

public abstract class Controller<T> implements IController<T>{
	
	protected String nome;

	@Override
	public Retorno<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno<T> find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno<T> insert(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno<T> update(int id, T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno<T> delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
