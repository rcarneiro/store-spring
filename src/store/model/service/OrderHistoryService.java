package store.model.service;

import store.model.entity.Order;

/**
 * 
 * @author Tarso Bessa
 *
 */
public interface OrderHistoryService {
	/**
	 * Persists the order history.
	 * @param orderHistory
	 */
	public void saveHistoryFor(Order order);
	
	
}
