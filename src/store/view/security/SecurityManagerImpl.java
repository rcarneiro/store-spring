package store.view.security;

import org.springframework.security.context.SecurityContextHolder;

import store.model.entity.Customer;
import store.view.SecurityManager;

public class SecurityManagerImpl implements SecurityManager {

	@Override
	public Customer getLoggedUser() {
		return (Customer) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

	@Override
	public boolean isUserLogged() {
		return getLoggedUser() != null;
	}

}