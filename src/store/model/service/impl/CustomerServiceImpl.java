package store.model.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import store.model.dao.CustomerDAO;
import store.model.entity.Customer;
import store.model.service.CustomerService;

public class CustomerServiceImpl implements CustomerService, UserDetailsService {
	
	private CustomerDAO customerDAO;
	
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException,
			DataAccessException {
	
		Customer customer = 
			 customerDAO.findByLogin(login);
		if(customer != null){
			return customer;
		}
		
		throw new UsernameNotFoundException(
				"Usuário não encontrado.");
	}

	@Override
	public List<Customer> getAll() {
		return customerDAO.getAll();
	}

	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);
		
	}

}
