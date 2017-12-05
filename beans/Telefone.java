package br.com.fiap.beans;

public class Telefone {
	private int ddd;
	private String numero;
	private String operadora;
	private int codigo;
	public Telefone(int ddd, String numero, String operadora, int codigo) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.operadora = operadora;
		this.codigo = codigo;
	}
	public Telefone() {
		super();
	}
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
