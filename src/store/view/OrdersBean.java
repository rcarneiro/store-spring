package store.view;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.myfaces.trinidad.context.RequestContext;

import store.model.entity.Order;
import store.model.service.OrderService;

/**
 * Managed Bean class for orders
 * 
 * @author Tarso Bessa
 * 
 */
public class OrdersBean {
	/**
	 * The order service
	 */
	private OrderService orderService;
	/**
	 * The security manager used to get the logged user.
	 */
	private SecurityManager securityManager;

	public OrdersBean() {
	}
	
	@PostConstruct
	public void init(){
		if (securityManager.isUserLogged()) {
			RequestContext.getCurrentInstance().getPageFlowScope().put(
					"lastOrder",
					orderService.getLastByCustomer(securityManager
							.getLoggedUser()));
			RequestContext.getCurrentInstance().getPageFlowScope().put("allOrders",
			orderService.getAllOrdersByCustomer(securityManager
					.getLoggedUser()));
		}
	}

	/**
	 * Returns the last order made by the customer.
	 * 
	 * @return
	 */
	public Order getLastOrder() {
		return (Order) RequestContext.getCurrentInstance().getPageFlowScope()
				.get("lastOrder");
	}

	/**
	 * Returns all the orders from the logged customer
	 * 
	 * @return
	 */
	public List<Order> getAllOrders() {
		return  (List<Order>) RequestContext.getCurrentInstance().getPageFlowScope()
		.get("allOrders");
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public SecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(SecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
