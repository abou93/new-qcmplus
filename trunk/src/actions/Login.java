/**
 * 
 */
package actions;

import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrateur
 *
 */
public class Login extends ActionSupport{
	
	public String accueil() {
		System.out.println("action.accueil");
		return SUCCESS;
	}
	
	public String login() {
		System.out.println("action.login");
		
		return SUCCESS;
	}

}
