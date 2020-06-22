package com.poo.trabFinal.controller;

import java.sql.SQLException;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.dao.VagaDAO;
import com.poo.trabFinal.interfaces.IController;
import com.poo.trabFinal.models.Candidato;
import com.poo.trabFinal.models.Vaga;

public class VagaController implements IController<Vaga>{

	@Override
	public Retorno getAll() throws SQLException {
		
		Retorno<Vaga> retorno = new Retorno<Vaga>();
		VagaDAO dao = new VagaDAO();
		
		try {		
			retorno = dao.getAll();
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
		
	}
	
	public Retorno getAllEmp(int idEmpresa) throws SQLException {
		
		Retorno<Vaga> retorno = new Retorno<Vaga>();
		VagaDAO dao = new VagaDAO();
		
		try {		
			retorno = dao.getAllEmp(idEmpresa);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
		
	}

	@Override
	public Retorno find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retorno<Vaga> insert(Vaga data) throws SQLException {
		
		Retorno<Vaga> retorno = new Retorno<Vaga>();
		VagaDAO dao = new VagaDAO();
		
		try {		
			retorno = dao.create((Vaga) data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Vaga> update(int id, Vaga data) throws SQLException {
		
		Retorno<Vaga> retorno = new Retorno<Vaga>();
		VagaDAO dao = new VagaDAO();
		
		try {		
			retorno = dao.update(id, data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno delete(int id) throws SQLException {
		
		Retorno<Vaga> retorno = new Retorno<Vaga>();
		VagaDAO dao = new VagaDAO();
		
		try {		
			retorno = dao.delete(id);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

}
