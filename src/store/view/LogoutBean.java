package store.view;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 * Class responsible for the logout.
 * @author Tarso Bessa
 *
 */
public class LogoutBean {
	/**
	 * Invaldates the HttpSession
	 * @param event
	 */
	public void logout(ActionEvent event){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();		
	}
}
