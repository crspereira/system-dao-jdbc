package model.dao;

import db.DB;
import model.dao.toimplement.SellerDaoJDBC;

//Classe respons�vel por Instanciar as EntitiesDAO utilizando m�todos Statics das diferentes
//   tecnologias, que por sua vez, disper� a necessidade de inst�ncia��o no programa principal.
//A classe ir� expor um m�todo que retornar� o tipo da Interface, mais internamente ela ir�
//   inst�nciar uma implementa��o.
//Macete para evita expor a implementa��o, apena a interface que � gen�rica.
//Forma de injetar dependeciaas sem explicitar a implementa��o

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

}
