package application;

import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		
		//validando a cria��o da classe
		Department obj = new Department(1, "Books");
		System.out.println(obj);

	}

}
