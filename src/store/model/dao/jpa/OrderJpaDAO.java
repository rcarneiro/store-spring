package store.model.dao.jpa;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import store.model.dao.OrderDAO;
import store.model.entity.Customer;
import store.model.entity.Order;

public class OrderJpaDAO extends JpaDaoSupport implements OrderDAO {

	@Override
	public List<Order> findAll() {
		return getJpaTemplate().find("FROM " + Order.class.getName());
	}

	@Override
	public Order save(Order order) {
		getJpaTemplate().persist(order);
		//Requerid 
		getJpaTemplate().flush();
		return order;
	}

	@Override
	public Order update(Order order) {
		getJpaTemplate().merge(order);
		return order;
	}

	@Override
	public Order findLastOrderByCustomer(Customer customer) {
		 List<Order> orders = findAllOrdersByCustomer(customer);
		 if(orders!=null && !orders.isEmpty()){
			return orders.get(0);
		 }
		 return null;
	}

	@Override
	public List<Order> findAllOrdersByCustomer(Customer customer) {
		return getJpaTemplate().find("FROM " + Order.class.getName() + " o WHERE o.customer = ? ORDER BY o.id DESC", customer);
	}

}
