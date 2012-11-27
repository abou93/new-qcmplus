/**
 * 
 */
package actions;

import services.UtilisateurImplementService;
import services.UtilisateurService;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrateur
 *
 */
public class Login extends ActionSupport{
	private Utilisateur u;
	private String nom;
	private String mdp;
	
	UtilisateurService userv = new UtilisateurImplementService();
	
	public String accueil() {
		setNom("nom");
		setMdp("mdp");
		System.out.println("actions.accueil");
		return SUCCESS;
	}
	
	public String login() {
		System.out.println("actions.login");
		u = userv.trouverUtilisateur(this.getNom(), this.getMdp());

		if (u != null) {
			System.out.println(u);
			if (u.getMotDePasse().equals(u.getMotDePasse()) &&
					u.getNom().equals(u.getNom())) {
				//session.put("login", u.getLogin());
				return SUCCESS;
			}
		}
		return ERROR;

	}

	public Utilisateur getU() {
		return u;
	}

	public void setU(Utilisateur u) {
		this.u = u;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
