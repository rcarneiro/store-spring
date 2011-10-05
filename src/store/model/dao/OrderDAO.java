package store.model.dao;

import java.util.List;

import store.model.entity.Customer;
import store.model.entity.Order;

public interface OrderDAO {
	public Order save(Order order);
	public Order update(Order order);
	public List<Order> findAll();
	public Order findLastOrderByCustomer(Customer customer);
	public List<Order> findAllOrdersByCustomer(Customer customer);
}
