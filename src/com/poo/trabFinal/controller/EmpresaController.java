package com.poo.trabFinal.controller;

import java.sql.SQLException;

import com.poo.trabFinal.classes.Retorno;
import com.poo.trabFinal.dao.EmpresaDAO;
import com.poo.trabFinal.interfaces.IController;
import com.poo.trabFinal.models.Empresa;

public class EmpresaController implements IController<Empresa> {

	@Override
	public Retorno<Empresa> getAll() throws SQLException {
		
		Retorno<Empresa> retorno = new Retorno<Empresa>();
		EmpresaDAO dao = new EmpresaDAO();
		
		try {		
			
			retorno = dao.getAll();
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Empresa> find(int id) throws SQLException {
		
		Retorno<Empresa> retorno = new Retorno<Empresa>();
		EmpresaDAO dao = new EmpresaDAO();
		
		try {		
			retorno = dao.read(id);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Empresa> insert(Empresa data) throws SQLException {
		
		Retorno<Empresa> retorno = new Retorno<Empresa>();
		EmpresaDAO dao = new EmpresaDAO();
		
		try {		
			
			retorno = dao.create((Empresa) data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Empresa> update(int id, Empresa data) throws SQLException {
		
		Retorno<Empresa> retorno = new Retorno<Empresa>();
		EmpresaDAO dao = new EmpresaDAO();
		
		try {		
			retorno = dao.update(id, (Empresa) data);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

	@Override
	public Retorno<Empresa> delete(int id) throws SQLException {
		
		Retorno<Empresa> retorno = new Retorno<Empresa>();
		EmpresaDAO dao = new EmpresaDAO();
		
		try {		
			
			retorno = dao.delete(id);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return retorno;
	}

}
