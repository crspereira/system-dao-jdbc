package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//validando a criação da classe
		//Department obj = new Department(1, "Books");
		//System.out.println(obj);
		
		//Seller seller = new Seller(21, "Bob", "bob@gmail", new Date(), 3000.00, obj);
		//System.out.println(seller);
		
		//validando a instanciação do "new SellerDaoJDBC()" pela interface chamando a Factory 
		//SellerDao sellerDao1 = DaoFactory.createSellerDao();

		//validando leitura de dados
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: Seller findById ====");
		Seller seller2 = sellerDao.findById(3);
		System.out.println(seller2);
		
		System.out.println("\n==== TEST 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);	
		}
		
		System.out.println("\n==== TEST 3: Seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);	
		}
		
		/*System.out.println("\n==== TEST 4: Seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());*/
		
		System.out.println("\n==== TEST 5: Seller update ====");
		seller2 = sellerDao.findById(11);
		Seller newSeller = new Seller(seller2.getId(), "Greg", "greg@gmail.com", new Date(), 8000.0, department);
		sellerDao.update(newSeller);
		System.out.println(newSeller);
		seller2.setName("MARTHA WAINE");
		sellerDao.update(seller2);
		System.out.println(seller2);
		System.out.println("Updated Completed!");
		
		System.out.println("\n==== TEST 6: Seller remove ====");;
		sellerDao.deleteById(12);
		System.out.println("Removed Completed!");
		
		
	}

}
