package com.poo.trabFinal.controller;

import java.sql.SQLException;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.dao.CandidatoDAO;
import com.poo.trabFinal.interfaces.IController;
import com.poo.trabFinal.models.Candidato;

public class CandidatoController<T> implements IController<T>{

	@Override
	public Retorno<T> getAll() throws SQLException{
		
		Retorno<T> retorno = new Retorno<T>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = (Retorno<T>) dao.getAll();
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<T> find(int id) throws SQLException {
		
		Retorno<T> retorno = new Retorno<T>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = (Retorno<T>) dao.read(id);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<T> update(int id, T data) throws SQLException {
		
		Retorno<T> retorno = new Retorno<T>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = (Retorno<T>) dao.update(id, (Candidato) data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<T> delete(int id) throws SQLException {
		
		Retorno<T> retorno = new Retorno<T>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = (Retorno<T>) dao.delete(id);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<T> insert(T data) throws SQLException {
		
		Retorno<T> retorno = new Retorno<T>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = (Retorno<T>) dao.create((Candidato) data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}


}
