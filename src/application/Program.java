package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.toimplement.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//validando a criação da classe
		Department obj = new Department(1, "Books");
		System.out.println(obj);
		
		Seller seller = new Seller(21, "Bob", "bob@gmail", new Date(), 3000.00, obj);
		System.out.println(seller);
		
		//validando a instanciação do "new SellerDaoJDBC()" pela interface chamando a Factory 
		SellerDao sellerDao = DaoFactory.createSellerDao();

	}

}
