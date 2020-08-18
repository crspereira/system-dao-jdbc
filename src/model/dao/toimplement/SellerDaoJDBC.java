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

//Classe responsável por implementar as Interfaces SellerDAO
//com a tecnologia JDBC
public class SellerDaoJDBC implements SellerDao{
	
	// criando DEPENDENCIA do SellerDaoJDBC com a CONEXÃO ao Banco de Dados
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
			
			st.setInt(1, id); //1 para o primeiro interrogação
			//resultado da consulta SQL em formato de tabela é armazenado na variável rs
			rs = st.executeQuery(); //aponta como padrão para a posição O, não contem objeto necessário instanciar 
			
			//criando/instanciando o objeto "Seller" associado ao "Department" na memória
			if (rs.next()) { //testa se a consulta retornou algum registro
				
				//instanciando e setando o Objeto Department atravéz da função "instantiateDepartment"
				Department dep = instantiateDepartment(rs);
				//instanciando e setando o Objeto Seller atravéz da função "instantiateSeller"
				Seller obj = instantiateSeller(rs, dep);
				
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
	//função auxiliar que instancia o objeto Seller
	//ajuda da Reutilização do código muito verboso
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep); //traz o objeto department instanciado inteiro
		return obj;
	}
	//função auxiliar que instancia o objeto Department
	//ajuda da Reutilização do código muito verboso
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}
	
	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
