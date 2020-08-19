package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
		 
		//validando a criação da classe
		//Department obj = new Department(1, "Books");
		//System.out.println(obj);
		
		//Seller seller = new Seller(21, "Bob", "bob@gmail", new Date(), 3000.00, obj);
		//System.out.println(seller);
		
		//validando a instanciação do "new DepartmentDaoJDBC()" pela interface chamando a Factory 
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		//validando a leitura de dados por id
		System.out.println("\n==== TEST 1: Department findById ====");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		//
		
		System.out.println("\n==== TEST 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n==== TEST 3: Department insert ====");
		Department newDepartment = new Department(null, "Video");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== TEST 4: Department update ====");
		department = new Department(8, "Administrativo");
		departmentDao.update(department);
		System.out.println("Update Completed!");
		
		System.out.println("\n==== TEST 5: Department delete ====");
		System.out.print ("Enter Department ID for delete: ");
		int id = in.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Department Deleted Succeful!");
		
		
		in.close();
		
	}

}
