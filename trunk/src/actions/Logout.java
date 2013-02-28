/**
 * 
 */
package actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import services.UtilisateurImplementService;
import services.UtilisateurService;
import beans.Administrateur;
import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stephane Sikora & Frederic Aubry
 * 
 */
public class Logout extends ActionSupport implements SessionAware {
	
	// session pour stocker les attributs
	private Map<String, Object> session;

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.logout");

		/*
		 * si l'utilisateur en session, on le delogue
		 */		
		if (session.containsKey("utilisateurSession")) {
			session.remove("utilisateurSession");
		}

		return SUCCESS;

	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
