package model.dao;

import model.dao.toimplement.SellerDaoJDBC;

//Classe responsável por Instanciar as EntitiesDAO utilzando métodos Statics, que por sua vez
//   disperá a necessidade de instânciação no programa principal.
//A classe irá expor um método que retornará o tipo da Interface, mais internamente ela irá
//   instânciar uma implementação.
//Macete para evita expor a implementação, apena a interface que é genérica.
//Forma de injetar dependeicas sem explicitar a implementação

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}

}
