/**
 * 
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * redirection vers la page d'accueil
 */
public class Accueil extends ActionSupport{	
	@Override
	public String execute() {		
		return SUCCESS;
	}
}
