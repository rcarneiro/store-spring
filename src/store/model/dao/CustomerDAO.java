package store.model.dao;

import java.util.List;

import store.model.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getAll();
	public Customer findByLogin(String login);
	public void save(Customer customer);
}
