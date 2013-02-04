/**
 * 
 */
package actions.admin.stagiaire;

import java.util.List;

import services.StagiaireImplementService;
import services.StagiaireService;
import beans.Stagiaire;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class SelectionStagiaire extends ActionSupport {
	// Variables pour jsp
	private String titre;
	//private Stagiaire s;
	private List<Stagiaire> listeStagiaires;

	// service pour g�rer les utilisateurs
	StagiaireService sserv = new StagiaireImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.selection");
		//liste des stagiaires
		setListeStagiaires(sserv.liste());
		//s = (Stagiaire) userv.trouverParId(sid);
		setTitre(getText("Titre.stagiaire.modification" + " : �tape 1"));
		//System.out.println(s);
		return SUCCESS;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Stagiaire> getListeStagiaires() {
		return listeStagiaires;
	}

	public void setListeStagiaires(List<Stagiaire> list) {
		this.listeStagiaires = list;
	}
}
