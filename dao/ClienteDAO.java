package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Telefone;
import br.com.fiap.conexao.ConexaoFactory;

public class ClienteDAO {
	private Connection con;
	
	public ClienteDAO()throws Exception{
		con = new ConexaoFactory().conectar();
	}
	
	public String fechar()throws Exception{
		con.close();
		return "Conexão encerrada!!";
	}
	
	public String gravar(Cliente cli) throws Exception{
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
		("INSERT INTO TB_CLIENTE(NR_CLIENTE, NM_CLIENTE, QT_ESTRELAS)"
				+ " VALUES (?,?,?)");
		estrutura.setInt(1, cli.getNumero());
		estrutura.setString(2, cli.getNome());
		estrutura.setInt(3, cli.getQtdeEstrelas());
		estrutura.execute();
		estrutura.close();
		TelefoneDAO tDao = new TelefoneDAO();
		for(Telefone obj : cli.getFones()){
			tDao.gravar(obj, cli.getNumero());
		}
		tDao.fechar();
		CargoDAO cDao = new CargoDAO();
		cDao.gravar(cli.getCargo(), cli.getNumero());
		cDao.fechar();
		return "Gravado com sucesso";
	}
	
	public Cliente getCliente(int num)throws Exception{
		Cliente cli = new Cliente();
		PreparedStatement estrutura=null;
		estrutura=con.prepareStatement
		("SELECT * FROM TB_CLIENTE WHERE NR_CLIENTE=?");
		estrutura.setInt(1, num);
		ResultSet resultado = null;
		resultado=estrutura.executeQuery();
		if(resultado.next()){	
			cli.setNome(resultado.getString("NM_CLIENTE"));
			cli.setNumero(resultado.getInt("NR_CLIENTE"));
			cli.setQtdeEstrelas(resultado.getInt("QT_ESTRELAS"));
			TelefoneDAO dao = new TelefoneDAO();
			//cli.setFones(dao.getTelefone(num));
			dao.fechar();
		}	
		resultado.close();
		estrutura.close();
		return cli;
	}
}

















