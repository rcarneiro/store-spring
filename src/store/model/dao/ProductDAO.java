package store.model.dao;

import java.util.List;

import store.model.entity.Product;

public interface ProductDAO {
	/**
	 * Returns the list of all procucts
	 * @return
	 */
	public List<Product> getAll();
	
	public void save(Product product);
}
