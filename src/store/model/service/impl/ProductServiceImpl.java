package store.model.service.impl;

import java.util.List;

import javax.jws.WebService;

import store.model.dao.ProductDAO;
import store.model.entity.Product;
import store.model.service.ProductService;
  @WebService(endpointInterface=
	    "store.model.service.ProductService")
  public class ProductServiceImpl
        implements ProductService {
	
	private ProductDAO productDAO;

	@Override
	public List<Product> getAll() {
		return productDAO.getAll();
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public void save(Product prod) {
		productDAO.save(prod);
	}

}
