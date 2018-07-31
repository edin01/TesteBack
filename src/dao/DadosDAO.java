package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dados.Dados;

public class DadosDAO {
	private Connection con;
	
	public DadosDAO() {
		try {
			this.con = new dao.ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void inserir(Dados d) {
		try {
			String sql = "INSERT INTO tb_customer_account (cpf_cnpj, nm_customer, is_active, vl_total) values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, d.getCpf_cnpj());
			stmt.setString(2, d.getNm_customer());
			stmt.setString(3, d.getIs_active());
			stmt.setDouble(4, d.getVl_total());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void select(Dados d) {
		try {
			String sql = "SELECT * FROM tb_customer_account WHERE vl_total > 560 AND id_customer BETWEEN 1500 AND 2700 ORDER BY"
					+ " vl_total DESC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id_customer");
				long cpf = rs.getLong("cpf_cnpj");
				String nm = rs.getString("nm_customer");
				String status = rs.getString("is_active");
				double total = rs.getDouble("vl_total");
				
				System.out.println("Nome: "+ nm +", Id: "+ id +", CPF/CNPJ: "+ cpf +", Ativo: "+ status +", Saldo: R$"+ total);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void media(Dados d) {
		try {
			
			String sql = "SELECT TRUNCATE(AVG(vl_total),2) AS 'Média' FROM tb_customer_account "
					+ "WHERE vl_total > 560 AND id_customer BETWEEN 1500 AND 2700";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				float media = rs.getFloat("Média");
				System.out.println("A média dos valores, nos requisitos pré-determinados, é: R$" + media);
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void limpar(Dados d) throws SQLException{
		
		String sql = "TRUNCATE TABLE tb_customer_account";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.execute();
		stmt.close();
		
		
	}
	}
