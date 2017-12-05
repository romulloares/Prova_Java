package br.com.fiap.beans;

import java.util.List;

public class Cliente {
	private String nome;
	private int numero;
	private int qtdeEstrelas;
	private List<Telefone> fones;
	private Cargo cargo;
	
	public Cliente(String nome, int numero, int qtdeEstrelas, List<Telefone> fones, Cargo cargo) {
		super();
		setNome(nome);
		setNumero(numero);
		setQtdeEstrelas(qtdeEstrelas);
		setFones(fones);
		setCargo(cargo);
	}
	public Cliente() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getQtdeEstrelas() {
		return qtdeEstrelas;
	}
	public void setQtdeEstrelas(int qtdeEstrelas) {
		this.qtdeEstrelas = qtdeEstrelas;
	}
	public List<Telefone> getFones() {
		return fones;
	}
	public void setFones(List<Telefone> fones) {
		this.fones = fones;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
