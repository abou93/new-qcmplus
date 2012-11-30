/**
 * 
 */
package actions.admin.stagiaire;

import beans.Stagiaire;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class SelectionStagiaireModification extends ActionSupport {
	// Variables pour jsp
	private String titre;
	private Stagiaire s;
	
	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.modification.selection");
		
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
}
