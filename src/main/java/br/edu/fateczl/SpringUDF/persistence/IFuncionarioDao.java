package br.edu.fateczl.SpringUDF.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.SpringUDF.model.Funcionario;

public interface IFuncionarioDao {
	public List<Funcionario> findFuncionario() throws SQLException, ClassNotFoundException;
	public Funcionario fiindFuncionario(Funcionario f) throws SQLException, ClassNotFoundException;

}
