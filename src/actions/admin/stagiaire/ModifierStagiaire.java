/**
 * 
 */
package actions.admin.stagiaire;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import services.StagiaireImplementService;
import services.StagiaireService;
import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class ModifierStagiaire extends ActionSupport implements SessionAware{
	// Variables pour jsp
	private Stagiaire s;
	private String titre;
	private List<Utilisateur> listeStagiaires;
	private long sid;

	// service pour gérer les utilisateurs
	StagiaireService userv = new StagiaireImplementService();
	private Map<String, Object> session;

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.modifier");
		// titre de la fenêtre
		titre = getText("Titre.stagiaire.modifier");
		setListeStagiaires(userv.liste());
		
		//récupération de l'id en session
		Stagiaire sSession = (Stagiaire)session.get("stagiaire");
		s.setId(sSession.getId());
		
		// tentative de modification du stagiaire
		long code = userv.modifier(s);
		System.out.println("code : "+code);
		
		if ( code <= 0) {
			addActionError(getText("Erreur.modificaion.stagiaire"));
			return ERROR;
		}
		// message de confirmation et retour à l'interface de gestion
		addActionMessage(getText("Confirmation.modificaion.stagiaire"));
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

	public List<Utilisateur> getListeStagiaires() {
		return listeStagiaires;
	}

	public void setListeStagiaires(List<Utilisateur> listeStagiaires) {
		this.listeStagiaires = listeStagiaires;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
}
