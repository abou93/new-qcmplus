/**
 * 
 */
package actions.admin.stagiaire;

import java.util.Map;

import services.StagiaireImplementService;
import services.UtilisateurService;
import beans.Stagiaire;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class CreerStagiaire extends ActionSupport {
	// Variables pour jsp
	private Stagiaire s;
	private String titre;

	// session pour stocker les attributs
	private Map<String, Object> session;

	// service pour gérer les utilisateurs
	UtilisateurService userv = new StagiaireImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire");
		// stagiaire vide pour champs jsp
		userv.creer(s);
		// titre de la fenêtre
		titre = getText("Titre.stagiaire.nouveau");
		// mise de l'utilisateur en session pour utilisation future
		// session.put("stagiaire", s);
		return SUCCESS;
	}

	/**
	 * @return the s
	 */
	public Stagiaire getS() {
		return s;
	}

	/**
	 * @param s
	 *            the s to set
	 */
	public void setS(Stagiaire s) {
		this.s = s;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
