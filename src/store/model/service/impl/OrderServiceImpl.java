package store.model.service.impl;

import java.util.List;

import org.springframework.jms.core.JmsTemplate;

import store.model.dao.OrderDAO;
import store.model.entity.Customer;
import store.model.entity.Order;
import store.model.entity.Payment;
import store.model.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	
	private JmsTemplate jmsPaymentTemplate;
	
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public Order checkout(Order order) {
		if(order.getPayment()==null){			
			order.setPayment(new Payment());
		}
		order.getPayment().setStatus(Payment.ST_SUBMITTED);
		order.getPayment().setValue(order.getOrderValue());
		//some code
		order =  orderDAO.save(order);
		jmsPaymentTemplate.
		   convertAndSend(order.getPayment());
		//some code
		return order;
	}

	@Override
	public List<Order> getAll() {
		return orderDAO.findAll();
	}

	@Override
	public Order getLastByCustomer(Customer customer) {
		return orderDAO.findLastOrderByCustomer(customer);
	}

	@Override
	public List<Order> getAllOrdersByCustomer(Customer customer) {
		return orderDAO.findAllOrdersByCustomer(customer);
	}

	public JmsTemplate getJmsPaymentTemplate() {
		return jmsPaymentTemplate;
	}

	public void setJmsPaymentTemplate(JmsTemplate jmsPaymentTemplate) {
		this.jmsPaymentTemplate = jmsPaymentTemplate;
	}
	
	

}
