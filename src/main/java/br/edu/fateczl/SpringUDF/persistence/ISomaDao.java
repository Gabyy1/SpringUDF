package br.edu.fateczl.SpringUDF.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.SpringUDF.model.Soma;

public interface ISomaDao {
	public List<Soma> listaSoma() throws SQLException, ClassNotFoundException;

}
