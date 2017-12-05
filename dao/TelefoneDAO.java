package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import br.com.fiap.beans.Telefone;
import br.com.fiap.conexao.ConexaoFactory;

public class TelefoneDAO {
	private Connection con;

	public TelefoneDAO()throws Exception{
		con=new ConexaoFactory().conectar();
	}
	
	public void fechar()throws Exception{
		con.close();
	}
	
	public String gravar(Telefone obj, int numero) throws Exception{
		PreparedStatement stmt = con.prepareStatement
				("INSERT INTO TB_TELEFONE "
		+ "(CD_TELEFONE, NR_TELEFONE, NR_DDD, NM_OPERADORA, NR_CLIENTE) "
		+ "VALUES (?,?,?,?,?)");
		stmt.setInt(1, obj.getCodigo());
		stmt.setString(2, obj.getNumero());
		stmt.setInt(3, obj.getDdd());
		stmt.setString(4, obj.getOperadora());
		stmt.setInt(5, numero);
		stmt.executeUpdate();
		stmt.close();
		return "Telefone adicionado";
	}
	
}


















