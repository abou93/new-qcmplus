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
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class Login extends ActionSupport implements SessionAware {
	// Variables pour jsp
	private Utilisateur u;
	private String nom;
	private String mdp;

	// session pour stocker les attributs
	private Map<String, Object> session;

	// service pour gérer les utilisateurs
	UtilisateurService userv = new UtilisateurImplementService();

	 public String accueil() {
//	 setNom("nom");
//	 setMdp("mdp");
	 System.out.println("actions.accueil");
	 return SUCCESS;
	 }

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.login via execute");

		// pour provoquer la création de la base
		//System.out.println(userv.creer(new Stagiaire("alpha", "beta")));

		/*
		 * récupération de l'utilisateur avec suppression des espaces et mise en
		 * minuslules préalables *
		 */
		this.setNom(this.getNom().toLowerCase().trim());
		this.setMdp(this.getMdp().toLowerCase().trim());
		u = userv.trouverUtilisateur(this.getNom(), this.getMdp());

		// utilisateur trouvé
		if (u != null) {
			System.out.println(u + " de type " + u.getClass());
			/*
			 * L'utilisateur existe bien en bdd : - verification de la paire
			 * nom/mdp - avec mise en minuscules et suppression des espaces des
			 * infos entrées par l'utilisateur = insensibilité à la casse
			 */
			if (u.getMotDePasse().equals(this.getMdp())
					&& u.getNom().equals(this.getNom())) {
				// mise de l'utilisateur en session pour utilisation future
				session.put("utilisateur", u);
				// redirection en fonction du rôle stagiaire ou admin ?
				if (u instanceof Stagiaire) {
					return "stagiaire";
				}
				if (u instanceof Administrateur) {
					return "admin";
				}
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
