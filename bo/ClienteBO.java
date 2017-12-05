package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cargo;
import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Telefone;
import br.com.fiap.dao.ClienteDAO;

public class ClienteBO {
	
	public static String novoCliente(Cliente cli) throws Exception {
		
		ClienteDAO dao = new ClienteDAO();
		
		if (cli.getCargo().getCargo().length() > 20) {
			return "Nome do cargo inválido!";
		} 
		if (cli.getNumero() <= 0 ) {
			return "Código do cliente inválido!";
		}
		
		cli.setNome(cli.getNome().toUpperCase());
		
		Telefone tel = null;
		List<Telefone> listaT = new ArrayList<Telefone>();
		for (Telefone t : cli.getFones()) {
			tel = new Telefone();
			tel.setNumero(t.getNumero().toUpperCase());
			tel.setOperadora(t.getOperadora().toUpperCase());
			tel.setCodigo(t.getCodigo());
			tel.setDdd(t.getDdd());
			listaT.add(tel);
		}
		
		cli.setFones(listaT);
		
		Cargo c = new Cargo();
		c.setCargo(cli.getCargo().getCargo().toUpperCase());
		c.setNivel(cli.getCargo().getNivel().toUpperCase());
		c.setCodigo(cli.getCargo().getCodigo());
		c.setSalario(cli.getCargo().getSalario());
		
		cli.setCargo(c);
		
		String msg = dao.gravar(cli);
		
		dao.fechar();
		
		return msg;
	}
}
