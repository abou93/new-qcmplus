/**
 * 
 */
package actions.admin.stagiaire;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import services.StagiaireImplementService;
import services.UtilisateurService;
import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class NouveauStagiaire extends ActionSupport {
	// Variables pour jsp
	private Stagiaire s;
	private String titre;

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.nouveau");
		//stagiaire vide pour champs jsp
		s = new Stagiaire();
		//titre de la fenêtre
		titre = getText("Titre.stagiaire.nouveau");
				
		return SUCCESS;
	}

	/**
	 * @return the s
	 */
	public Stagiaire getS() {
		return s;
	}

	/**
	 * @param s the s to set
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
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
}
