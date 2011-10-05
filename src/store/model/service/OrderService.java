package store.model.service;

import java.util.List;

import store.model.entity.Customer;
import store.model.entity.Order;

/**
 * The Order service interface.
 */
public interface OrderService {
	/**
	 * Process the order.
	 * 
	 * Validates the required information: A customer and the payment are
	 * required.
	 * 
	 * Send the payment to be processed by a MessageDriven.
	 * 
	 * @param order
	 */
	public Order checkout(Order order);

	public List<Order> getAll();
	/**
	 * Returns the last order made by the customer.
	 * @param customer
	 * @return
	 */
	public Order getLastByCustomer(Customer customer);
	/**
	 * Returns all the orders from the customer.
	 * @param customer
	 * @return
	 */
	public List<Order> getAllOrdersByCustomer(Customer customer);
}
