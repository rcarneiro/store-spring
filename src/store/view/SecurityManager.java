package store.view;

import store.model.entity.Customer;

/**
 * 
 * @author Tarso Bessa
 * @author Rafael Carneiro
 *
 */
public interface SecurityManager {
	/**
	 * Returns the logged customer.
	 * @return
	 */
	public Customer getLoggedUser();
	/**
	 * Returns true if the user has logged in.
	 * @return
	 */
	public boolean isUserLogged();
}
