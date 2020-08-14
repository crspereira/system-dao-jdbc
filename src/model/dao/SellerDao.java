package model.dao;

import java.util.List;

//Classe respons�vel por definir as opera��oes de acesso a dados (Acesso ao Banco de Dados) relacinado a Sellers
//Classe definida como Interface para dar flexibilidade e preserva��o do Contrato de objetos de acesso a dados
import model.entities.Seller;

public interface SellerDao {
	
	public void insert(Seller obj);
	public void update(Seller obj);
	public void deleteById(Integer id);
	public Seller findById(Integer id); //retorna o ID ou Null
	public List<Seller> findAll(); //retorna a lista de Vendedores
	
}
