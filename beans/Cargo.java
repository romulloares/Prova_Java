package br.com.fiap.beans;

public class Cargo{

	private int codigo;
	private String cargo;
	private String nivel;
	private float salario;
	
	
	public Cargo() {
		super();
	}

	public Cargo(int codigo, String cargo, String nivel, float salario) {
		super();
		setCodigo(codigo);
		setCargo(cargo);
		setNivel(nivel);
		setSalario(salario);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
}
