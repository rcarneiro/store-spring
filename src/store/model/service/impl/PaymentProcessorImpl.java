package store.model.service.impl;

import store.model.dao.PaymentDAO;
import store.model.entity.Payment;
import store.model.service.PaymentProcessor;

public class PaymentProcessorImpl implements PaymentProcessor {

	private PaymentDAO paymentDAO;

	@Override
	public void processPayment(
			Payment payment) {
		boolean success = (((int)(Math.random() * 10)) % 2 == 0);
		if(success){
		  payment.setStatus(Payment.ST_PROCESSED);
		}else{
			payment.setStatus(Payment.ST_REFUSED);
		}
		paymentDAO.update(payment);		
	}

	public PaymentDAO getPaymentDAO() {
		return paymentDAO;
	}

	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

}
