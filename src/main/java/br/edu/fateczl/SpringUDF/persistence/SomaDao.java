package br.edu.fateczl.SpringUDF.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import br.edu.fateczl.SpringUDF.model.Soma;

@Repository
public class SomaDao implements ISomaDao{
	
	@Autowired
	GenericDao gDao;


	public List<Soma> listaSoma() throws SQLException, ClassNotFoundException {
		List<Soma> somas = new ArrayList<Soma>();
		
		Connection c = gDao.getConnection();
		String sql = "Select Salario, Salario_dependente, Soma From fn_soma()";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Soma soma = new Soma();
			soma.setSalario(rs.getDouble("Salario"));
			soma.setSalarioDep(rs.getDouble("Salario_dependente"));
			soma.setSoma(rs.getDouble("Soma"));
			
			somas.add(soma);
		}
		rs.close();
		ps.close();
		c.close();
		
		return somas;
	}

}
