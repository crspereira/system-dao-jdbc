package model.dao;

import model.dao.toimplement.SellerDaoJDBC;

//Classe respons�vel por Instanciar as EntitiesDAO utilzando m�todos Statics, que por sua vez
//   disper� a necessidade de inst�ncia��o no programa principal.
//A classe ir� expor um m�todo que retornar� o tipo da Interface, mais internamente ela ir�
//   inst�nciar uma implementa��o.
//Macete para evita expor a implementa��o, apena a interface que � gen�rica.
//Forma de injetar dependeicas sem explicitar a implementa��o

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}

}
