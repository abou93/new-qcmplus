/**
 * 
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stephane Sikora & Frederic Aubry
 * redirection vers la page d'accueil
 */
public class Accueil extends ActionSupport{	
	@Override
	public String execute() {		
		return SUCCESS;
	}
}
