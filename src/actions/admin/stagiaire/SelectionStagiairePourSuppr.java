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
 * @author Stephane Sikora & Frederic Aubry
 * 
 */
public class SelectionStagiairePourSuppr extends ActionSupport {
	// Variables pour jsp
	private String titre;
	//private Stagiaire s;
	private List<Stagiaire> listeStagiaires;

	// service pour g�rer les utilisateurs
	StagiaireService userv = new StagiaireImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.selection.suppr");
		//liste des stagiaires
		setListeStagiaires(userv.liste());
		//s = (Stagiaire) userv.trouverParId(sid);
		setTitre(getText("Titre.stagiaire.suppression" + " : �tape 1"));
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
