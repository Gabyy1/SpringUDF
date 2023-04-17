package br.edu.fateczl.SpringUDF.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fateczl.SpringUDF.model.Funcionario;
import br.edu.fateczl.SpringUDF.model.Soma;
import br.edu.fateczl.SpringUDF.persistence.FuncionarioDao;
import br.edu.fateczl.SpringUDF.persistence.SomaDao;

@Controller
public class FuncionarioController {
	
	@Autowired
	SomaDao sDao;
	
	@Autowired
	FuncionarioDao fDao;
	
	@RequestMapping(name= "funcionario", value="/funcionario", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		String erro = "";
		List<Soma> soma = new ArrayList<Soma>();
		try {
			 soma = listaSoma();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();		
		}finally {
			model.addAttribute("erro", erro);
			model.addAttribute("soma", soma);
		}
		
		return new ModelAndView("funcioanrio");		
	}
	
	@RequestMapping(name= "funcionario", value="/funcionario", method = RequestMethod.POST)
	public ModelAndView funcionarios(ModelMap model, @RequestParam  Map<String, String> allParam) {
	String cod = allParam.get("cod");
	String botao = allParam.get("botao");
	
	Funcionario funcionario = new Funcionario();
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	String erro = "";
	List<Soma> soma = new ArrayList<Soma>();
	
	try {
		soma = listaSoma();
		if (botao.equals("Listar")) {
			funcionarios = fDao.findFuncionario();
			funcionario = null;
		}else {
			if(botao.equals("Consultar") && !cod.equals("")) {
				funcionario.setCodigo(Integer.parseInt(cod));
				fDao.fiindFuncionario(funcionario);
		}else {
				erro = "Preencha os campos corretamente";
			}
		}
	}catch (ClassNotFoundException | SQLException e) {
		erro = e.getMessage();
	}finally {
		model.addAttribute("erro", erro);
		model.addAttribute("soma", soma);
		model.addAttribute("funcionario", funcionario);
		model.addAttribute("funcionarios", funcionarios);
	}
		return new ModelAndView("funcioanrio");
	}

	private List<Soma> listaSoma() throws ClassNotFoundException, SQLException {
		List<Soma> soma = sDao.listaSoma();		
		return soma;
	}

}
