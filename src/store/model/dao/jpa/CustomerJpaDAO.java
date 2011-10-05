package store.model.dao.jpa;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import store.model.dao.CustomerDAO;
import store.model.entity.Customer;

public class CustomerJpaDAO extends JpaDaoSupport implements CustomerDAO {

	@Override
	public List<Customer> getAll() {
		return getJpaTemplate().find("FROM " + Customer.class.getName());
	}

	@Override
	public Customer findByLogin(String login) {
		List<Customer> customers = getJpaTemplate().find("FROM " + Customer.class.getName() + " c WHERE c.login = ?" , login);
		if(customers!=null && !customers.isEmpty()){
			return customers.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void save(Customer customer) {
		getJpaTemplate().persist(customer);
	}

}
