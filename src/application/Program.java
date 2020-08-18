package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//validando a cria��o da classe
		//Department obj = new Department(1, "Books");
		//System.out.println(obj);
		
		//Seller seller = new Seller(21, "Bob", "bob@gmail", new Date(), 3000.00, obj);
		//System.out.println(seller);
		
		//validando a instancia��o do "new SellerDaoJDBC()" pela interface chamando a Factory 
		//SellerDao sellerDao1 = DaoFactory.createSellerDao();

		//validando leitura de dados
		SellerDao sellerDao2 = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: Seller findById ====");
		Seller seller2 = sellerDao2.findById(3);
		System.out.println(seller2);
		
		System.out.println("\n==== TEST 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao2.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);	
		}
		
		
		
	}

}
