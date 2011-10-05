package store.model.service.impl;

import java.util.Date;

import store.model.dao.OrderHistoryDAO;
import store.model.entity.Order;
import store.model.entity.OrderHistory;
import store.model.service.OrderHistoryService;

  public class OrderHistoryServiceImpl implements OrderHistoryService {

	/**
	 * Create a history object for Order and save it.
	 */
	@Override
	public void saveHistoryFor(Order order) {
		OrderHistory oh = new OrderHistory();
		oh.setOperation(OrderHistory.TP_INSERT);
		oh.setUsername(order.getCustomer().getName());
		oh.setDate(new Date());
		orderHistoryDAO.save(oh);
	}

	private OrderHistoryDAO orderHistoryDAO;

	public OrderHistoryDAO getOrderHistoryDAO() {
		return orderHistoryDAO;
	}

	public void setOrderHistoryDAO(OrderHistoryDAO orderHistoryDAO) {
		this.orderHistoryDAO = orderHistoryDAO;
	}

}
