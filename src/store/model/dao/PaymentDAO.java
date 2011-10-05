package store.model.dao;

import store.model.entity.Payment;

public interface PaymentDAO {
	/**
	 * Updates the payment object
	 * @param payment
	 */
	public void update(Payment payment);
}
