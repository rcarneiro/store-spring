package store.model.dao;

import store.model.entity.OrderHistory;

public interface OrderHistoryDAO {
	/**
	 * Persist the order history on the underlying data storage.
	 * @param orderHistory
	 */
	public void save(OrderHistory orderHistory);
}
