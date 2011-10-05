package store.model.service;

import store.model.entity.Payment;

/**
 * A contract definition for a payment processor.
 * 
 * @author Tarso Bessa
 * 
 */
public interface PaymentProcessor {
	/**
	 * Process the payment. If the processment was succesful,
	 * the status of the payment changes to 'processed', otherwise
	 * 'refused'.
	 * 
	 * @param payment
	 */
	public void processPayment(Payment payment);
}
