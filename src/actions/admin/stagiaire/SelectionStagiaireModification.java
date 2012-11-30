/**
 * 
 */
package actions.admin.stagiaire;

import java.util.List;

import services.StagiaireImplementService;
import services.UtilisateurService;

import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class SelectionStagiaireModification extends ActionSupport {
	// Variables pour jsp
	private String titre;
	private Stagiaire s;
	private List<Utilisateur> listeStagiaires;

	// service pour g�rer les utilisateurs
	UtilisateurService userv = new StagiaireImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.modification.selection");
		//liste des stagiaires
		setListeStagiaires(userv.liste());
		setTitre(getText("Titre.stagiaire.modification"));

		return SUCCESS;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Stagiaire getS() {
		return s;
	}

	public void setS(Stagiaire s) {
		this.s = s;
	}

	public List<Utilisateur> getListeStagiaires() {
		return listeStagiaires;
	}

	public void setListeStagiaires(List<Utilisateur> listeStagiaires) {
		this.listeStagiaires = listeStagiaires;
	}
}
