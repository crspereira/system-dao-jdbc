package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	
	public void insert(Seller obj);
	public void update(Seller obj);
	public void deleteById(Integer id);
	public Seller findById(Integer id); //retorna o ID ou Null
	public List<Seller> findAll(); //retorna a lista de Vendedores
	
}
