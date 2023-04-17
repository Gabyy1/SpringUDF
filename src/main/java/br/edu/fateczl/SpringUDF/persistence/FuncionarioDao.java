package br.edu.fateczl.SpringUDF.persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.SpringUDF.model.Funcionario;



	@Repository
	public class FuncionarioDao implements IFuncionarioDao {
	
	@Autowired
	GenericDao gDao;

	@Override
	public List<Funcionario> findFuncionario() throws SQLException, ClassNotFoundException {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Connection c = gDao.getConnection();
		String sql = "Select Codigo, Nome, Salario, Nome_dependente, Salario_dependente, SalarioTotal From fn_tablefd()";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Funcionario f = new Funcionario();
			f.setCodigo(rs.getInt("Codigo"));
			f.setNome(rs.getString("Nome"));
			f.setSalario(rs.getDouble("Salario"));
			f.setNome_dependente(rs.getString("Nome_dependente"));
			f.setNome_dependente(rs.getString("Salario_dependente"));
			f.setSalarioTotal(rs.getDouble("SalarioTotal"));
			
			funcionarios.add(f);			
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return funcionarios;
	}

	@Override
	public Funcionario fiindFuncionario(Funcionario f) throws SQLException, ClassNotFoundException {

		Connection c = gDao.getConnection();
		String sql = "Select Codigo, Nome, Salario, Nome_dependente, Salario_dependente, SalarioTotal From fn_tablefd() WHERE Codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			f.setCodigo(rs.getInt("Codigo"));
			f.setNome(rs.getString("Nome"));
			f.setSalario(rs.getDouble("Salario"));
			f.setNome_dependente(rs.getString("Nome_dependente"));
			f.setNome_dependente(rs.getString("Salario_dependente"));
			f.setSalarioTotal(rs.getDouble("SalarioTotal"));
						
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return f;

}
}