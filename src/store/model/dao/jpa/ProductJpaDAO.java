package store.model.dao.jpa;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import store.model.dao.ProductDAO;
import store.model.entity.Product;

public class ProductJpaDAO extends JpaDaoSupport implements ProductDAO {

	@Override
	public List<Product> getAll() {
		return getJpaTemplate().find("FROM " + Product.class.getName());
	}

	@Override
	public void save(Product product) {
		getJpaTemplate().persist(product);
		
	}

}
