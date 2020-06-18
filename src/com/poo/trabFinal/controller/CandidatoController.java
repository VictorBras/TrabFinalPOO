package com.poo.trabFinal.controller;

import java.sql.SQLException;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.dao.CandidatoDAO;
import com.poo.trabFinal.interfaces.IController;
import com.poo.trabFinal.models.Candidato;

public class CandidatoController implements IController<Candidato>{

	@Override
	public Retorno<Candidato> getAll() throws SQLException{
		
		Retorno<Candidato> retorno = new Retorno<Candidato>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = dao.getAll();
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Candidato> find(int id) throws SQLException {
		
		Retorno<Candidato> retorno = new Retorno<Candidato>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = dao.read(id);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Candidato> update(int id, Candidato data) throws SQLException {
		
		Retorno<Candidato> retorno = new Retorno<Candidato>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = dao.update(id, (Candidato) data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Candidato> delete(int id) throws SQLException {
		
		Retorno<Candidato> retorno = new Retorno<Candidato>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = dao.delete(id);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Candidato> insert(Candidato data) throws SQLException {
		
		Retorno<Candidato> retorno = new Retorno<Candidato>();
		CandidatoDAO dao = new CandidatoDAO();
		
		try {		
			
			retorno = dao.create((Candidato) data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}


}
