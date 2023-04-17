package br.edu.fateczl.SpringUDF.model;

public class Funcionario {
	private int codigo;
	private String nome;
	private double salario;
	private String Nome_dependente;
	private double Salario_dependente;
	private double SalarioTotal;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getNome_dependente() {
		return Nome_dependente;
	}
	public void setNome_dependente(String nome_dependente) {
		Nome_dependente = nome_dependente;
	}
	public double getSalario_dependente() {
		return Salario_dependente;
	}
	public void setSalario_dependente(double salario_dependente) {
		Salario_dependente = salario_dependente;
	}
	public double getSalarioTotal() {
		return SalarioTotal;
	}
	public void setSalarioTotal(double salarioTotal) {
		SalarioTotal = salarioTotal;
	}
	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", salario=" + salario + ", Nome_dependente="
				+ Nome_dependente + ", Salario_dependente=" + Salario_dependente + ", SalarioTotal=" + SalarioTotal
				+ "]";
	}

}
