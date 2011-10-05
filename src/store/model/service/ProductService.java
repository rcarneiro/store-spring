package store.model.service;

import java.util.List;

import javax.jws.WebService;

import store.model.entity.Product;
/**
 * The products service interface.
 * @author tarso.bessa
 *
 */
@WebService
public interface ProductService {
	/**
	 * Returns the list of all procucts
	 * @return
	 */
	public List<Product> getAll();
	
	public void save(Product prod);
}

