/**
 * 
 */
package actions.admin.stagiaire;

import java.util.List;
import java.util.Set;

import services.StagiaireImplementService;
import services.StagiaireService;
import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class ListeStagiaires extends ActionSupport {
	// Variables pour jsp
	private Stagiaire s;
	private String titre;
	private List<Utilisateur> listeStagiaires;

	// service pour gérer les utilisateurs
	StagiaireService userv = new StagiaireImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.liste");
		// stagiaire vide pour champs jsp
		s = new Stagiaire();
		// liste récupérée en base
		setListeStagiaires(userv.liste());
		// titre de la fenêtre
		titre = getText("Titre.stagiaire.modifier");

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
	 * @return the listeStagiaires
	 */
	public List<Utilisateur> getListeStagiaires() {
		return listeStagiaires;
	}

	/**
	 * @param listeStagiaires the listeStagiaires to set
	 */
	public void setListeStagiaires(List<Utilisateur> listeStagiaires) {
		this.listeStagiaires = listeStagiaires;
	}

}
