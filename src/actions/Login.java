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
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class Login extends ActionSupport implements SessionAware {
	// Variables pour jsp
	private Utilisateur u;
	private String nom;
	private String mdp;

	// session pour stocker les attributs
	private Map<String, Object> session;

	// service pour gerer les utilisateurs (on ne sait pas encore si admin ou stagiaire)
	UtilisateurService userv = new UtilisateurImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.login via execute");

		// jeu de test
//		System.out.println(userv.creer(new Stagiaire("alpha2", "beta2")));
//		System.out.println(userv.creer(new Administrateur("admin2", "pop")));
//		System.out.println(userv.creer(new Stagiaire("alpha2", "beta2")));
//		System.out.println(userv.creer(new Administrateur("admin2", "pop")));
		
		/*
		 * recuperaztion de l'authentification de l'utilisateur avec suppression des espaces et mise en
		 * minuslules prealables 
		 */
		this.setNom(this.getNom().toLowerCase().trim());
		this.setMdp(this.getMdp().toLowerCase().trim());
		u = userv.trouverParNomEtMdp(this.getNom(), this.getMdp());

		// utilisateur trouve
		if (u != null) {
			System.out.println(u + " de type " + u.getClass());
			/*
			 * L'utilisateur existe bien en bdd : on détermine s'il est de type Stagiaire 
			 * ou Administrateur puis on le place en session pour utilisation future
			 */				
			session.put("utilisateurSession", u);
			// redirection en fonction du r�le stagiaire ou admin ?
			if (u instanceof Stagiaire) {
				return "stagiaire";
			}
			if (u instanceof Administrateur) {
				return "admin";
			}
		}
		// sinon ajout message d'erreur et renvoi vers le formulaire
		final String MESSAGE = "Login.erreur";
		this.addActionError(getText(MESSAGE));
		return ERROR;

	}

	/**
	 * @return
	 */
	public Utilisateur getU() {
		return u;
	}

	/**
	 * @param u
	 */
	public void setU(Utilisateur u) {
		this.u = u;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
