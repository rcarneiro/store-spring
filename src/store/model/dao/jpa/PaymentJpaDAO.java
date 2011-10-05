package store.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import store.model.dao.PaymentDAO;
import store.model.entity.Payment;

public class PaymentJpaDAO extends JpaDaoSupport implements PaymentDAO {

	@Override
	public void update(final Payment payment) {
		getJpaTemplate().execute(new JpaCallback(){

			@Override
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Session session = (Session) em.getDelegate();
				session.update(payment);
				return null;
			}
		});
		
	}

}
