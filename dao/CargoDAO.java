package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cargo;
import br.com.fiap.conexao.ConexaoFactory;

public class CargoDAO {
	
	private Connection con;

	public CargoDAO() throws Exception {
		con = new ConexaoFactory().conectar();
	}
	
	public String fechar() throws Exception {
		con.close();
		return "Conexão fechada!";
	}
	
	public String gravar(Cargo c, int codCliente) throws Exception{
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement("INSERT INTO TB_DDD_CARGO(CD_CARGO, NM_CARGO, NM_NIVEL, VL_SALARIO, NR_CLIENTE)"
				+ " VALUES (?,?,?,?,?)");
		estrutura.setInt(1, c.getCodigo());
		estrutura.setString(2, c.getCargo());
		estrutura.setString(3, c.getNivel());
		estrutura.setFloat(4, c.getSalario());
		estrutura.setInt(5, codCliente);
		estrutura.executeUpdate();
		estrutura.close();
		return "Cargo adicionado!";
	}
	
	public String atualizar(Cargo c, int numeroCli) throws Exception {
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement("UPDATE TB_DDD_CARGO SET NM_CARGO = ?, NM_NIVEL = ?, VL_SALARIO = ?"
				+ " WHERE NR_CLIENTE = ?");
		estrutura.setString(1, c.getCargo());
		estrutura.setString(2, c.getNivel());
		estrutura.setFloat(3, c.getSalario());
		estrutura.setInt(4, numeroCli);
		estrutura.executeUpdate();
		estrutura.close();
		
		return "Cargo atualizado!";
	}
	
	public List<Cargo> getAll(String nivel) throws Exception {
		List<Cargo> lista = new ArrayList<Cargo>();
		Cargo c = null;
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement("SELECT * FROM TB_DDD_CARGO WHERE NM_NIVEL = ?");
		estrutura.setString(1, nivel);
		ResultSet rs = null;
		rs = estrutura.executeQuery();
		while (rs.next()) {
			c = new Cargo();
			c.setCodigo(rs.getInt("CD_CARGO"));
			c.setCargo(rs.getString("NM_CARGO"));
			c.setNivel(rs.getString("NM_NIVEL"));
			c.setSalario(rs.getFloat("VL_SALARIO"));
			lista.add(c);
		}
		
		rs.close();
		estrutura.close();
		return lista;
	}

}
