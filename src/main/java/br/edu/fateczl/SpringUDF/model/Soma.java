package br.edu.fateczl.SpringUDF.model;

public class Soma {
	private double salario;
	private double salarioDep;
	private double soma;
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getSalarioDep() {
		return salarioDep;
	}
	public void setSalarioDep(double salarioDep) {
		this.salarioDep = salarioDep;
	}
	public double getSoma() {
		return soma;
	}
	public void setSoma(double soma) {
		this.soma = soma;
	}
	@Override
	public String toString() {
		return "Soma [salario=" + salario + ", salarioDep=" + salarioDep + ", soma=" + soma + "]";
	}

}
