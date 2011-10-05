package store.model.service;

import java.util.List;

import store.model.entity.Customer;

public interface CustomerService {
	public List<Customer> getAll();
	public void save(Customer customer);
	
}
