package com.poo.trabFinal.controller;

import java.sql.SQLException;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.dao.CandidatoVagaDAO;
import com.poo.trabFinal.dao.VagaDAO;
import com.poo.trabFinal.interfaces.IController;
import com.poo.trabFinal.models.CandidatoVaga;
import com.poo.trabFinal.models.Vaga;

public class CandidatoVagaController implements IController<CandidatoVaga>{

	public Retorno<CandidatoVaga> getAll(int idCandidato) throws SQLException {
		
		Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
		CandidatoVagaDAO dao = new CandidatoVagaDAO();
		
		try {		
			retorno = dao.getAllEmp(idCandidato);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	public Retorno<CandidatoVaga> find(int idCandidato, int idVaga) throws SQLException {
		
		Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
		CandidatoVagaDAO dao = new CandidatoVagaDAO();
		
		try {		
			retorno = dao.read(idCandidato, idVaga);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<CandidatoVaga> insert(CandidatoVaga data) throws SQLException {
		
		Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
		CandidatoVagaDAO dao = new CandidatoVagaDAO();
		
		try {		
			retorno = dao.create((CandidatoVaga) data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<CandidatoVaga> update(int id, CandidatoVaga data) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno<CandidatoVaga> delete(int id) throws SQLException {
		
		Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
		CandidatoVagaDAO dao = new CandidatoVagaDAO();
		
		try {		
			retorno = dao.delete(id);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}
	
public Retorno<CandidatoVaga> deleteAll(int idCandidato) throws SQLException {
		
		Retorno<CandidatoVaga> retorno = new Retorno<CandidatoVaga>();
		CandidatoVagaDAO dao = new CandidatoVagaDAO();
		
		try {		
			retorno = dao.deleteAll(idCandidato);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<CandidatoVaga> find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno<CandidatoVaga> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
