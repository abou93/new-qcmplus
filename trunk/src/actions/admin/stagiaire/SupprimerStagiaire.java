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

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stephane Sikora & Frederic Aubry
 * 
 */
public class SupprimerStagiaire extends ActionSupport implements SessionAware {
	// Variables pour jsp
	private Stagiaire s;
	private String titre;
	private List<Stagiaire> listeStagiaires;
	private long sid;

	// service pour g�rer les utilisateurs
	StagiaireService userv = new StagiaireImplementService();
	private Map<String, Object> session;

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.supprimer");
		// titre de la fen�tre
		titre = getText("Titre.stagiaire.supprimer" + " : �tape 3");
		setListeStagiaires(userv.liste());

		// r�cup�ration de l'id en session
		s.setId((Long)session.get("sid"));

		// tentative de modification du stagiaire
		long code = userv.supprimer(s);
		System.out.println("code : " + code);

		if (code <= 0) {
			addActionError(getText("Erreur.suppression.stagiaire"));
			return ERROR;
		}
		// message de confirmation et retour � l'interface de gestion
		addActionMessage(getText("Confirmation.suppression.stagiaire"));
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

	public List<Stagiaire> getListeStagiaires() {
		return listeStagiaires;
	}


	public void setListeStagiaires(List<Stagiaire> list) {
		this.listeStagiaires = list;
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
