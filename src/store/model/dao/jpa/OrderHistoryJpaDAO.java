package store.model.dao.jpa;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import store.model.dao.OrderHistoryDAO;
import store.model.entity.OrderHistory;

public class OrderHistoryJpaDAO extends JpaDaoSupport implements
		OrderHistoryDAO {
	/**
	 * Inserts the orderHistory on the database.
	 */
	@Override
	public void save(OrderHistory orderHistory) {
		getJpaTemplate().persist(orderHistory);
	}

}
