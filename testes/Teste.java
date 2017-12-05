package br.com.fiap.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cargo;
import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Telefone;
import br.com.fiap.bo.ClienteBO;

public class Teste {

	public static void main(String[] args) throws Exception{
		
		List<Telefone> listT = new ArrayList<Telefone>();
		
		Telefone t = new Telefone(11, "621621211", "Tim", 1);
		listT.add(t);
		
		Telefone t2 = new Telefone(11, "349589340", "Vivo", 2);
		listT.add(t2);
		
		Cargo c = new Cargo(1, "Desenvolvedor", "Ninja", 50000);
		
		ClienteBO.novoCliente(new Cliente("Braufagelio", 11, 5, listT, c));
	}

}
