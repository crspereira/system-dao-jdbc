package model.dao.toimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

//Classe respons�vel por implementar as Interfaces SellerDAO
//com a tecnologia JDBC
public class SellerDaoJDBC implements SellerDao{
	
	// criando DEPENDENCIA do SellerDaoJDBC com a CONEX�O ao Banco de Dados
	private Connection conn;
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	} 
	//
	

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			st.setInt(1, id); //1 para o primeiro interroga��o
			//resultado da consulta SQL em formato de tabela � armazenado na vari�vel rs
			rs = st.executeQuery(); //aponta como padr�o para a posi��o O, n�o contem objeto necess�rio instanciar 
			
			//criando/instanciando o objeto "Seller" associado ao "Department" na mem�ria
			if (rs.next()) { //testa se a consulta retornou algum registro
				
				//instanciando e setando o Objeto Department
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				
				//instanciando e setando o Objeto Seller
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep); //traz o objeto department instanciado inteiro
				
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
