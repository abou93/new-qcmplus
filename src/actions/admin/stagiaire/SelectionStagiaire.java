/**
 * 
 */
package actions.admin.stagiaire;

import java.util.List;

import services.StagiaireImplementService;
import services.StagiaireService;
import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class SelectionStagiaire extends ActionSupport {
	// Variables pour jsp
	private String titre;
	//private Stagiaire s;
	private List<Utilisateur> listeStagiaires;

	// service pour gérer les utilisateurs
	StagiaireService userv = new StagiaireImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.selection");
		//liste des stagiaires
		setListeStagiaires(userv.liste());
		//s = (Stagiaire) userv.trouverParId(sid);
		setTitre(getText("Titre.stagiaire.modification" + " : étape 2"));
		//System.out.println(s);
		return SUCCESS;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Utilisateur> getListeStagiaires() {
		return listeStagiaires;
	}

	public void setListeStagiaires(List<Utilisateur> listeStagiaires) {
		this.listeStagiaires = listeStagiaires;
	}
}
