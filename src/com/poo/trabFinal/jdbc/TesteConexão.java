package com.poo.trabFinal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteConexão {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from Candidato where id = ?";
		String test;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, 1);
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				test = rs.getString("Nome");
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
