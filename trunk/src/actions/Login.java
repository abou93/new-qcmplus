/**
 * 
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrateur
 *
 */
public class Login extends ActionSupport{
	
	public String login() {
		System.out.println("action.login");
		return SUCCESS;
	}

}
