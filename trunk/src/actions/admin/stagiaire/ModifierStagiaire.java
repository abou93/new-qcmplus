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
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class ModifierStagiaire extends ActionSupport implements SessionAware {
	// Variables pour jsp
	private Stagiaire s;
	private String titre;
	private List<Stagiaire> listeStagiaires;
	private long sid;

	// service pour g�rer les utilisateurs
	StagiaireService sserv = new StagiaireImplementService();
	private Map<String, Object> session;

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.modifier");
		// titre de la fen�tre
		titre = getText("Titre.stagiaire.modifier");
		setListeStagiaires(sserv.liste());

		// r�cup�ration de l'id en session
		s.setId((Long) session.get("sid"));
		//tous les champs en minuscule
		s.setNom(s.getNom().trim().toLowerCase());
		s.setPrenom(s.getPrenom().trim().toLowerCase());
		s.setSociete(s.getSociete().trim().toLowerCase());
		s.setMotDePasse(s.getMotDePasse().trim().toLowerCase());
		// tentative de modification du stagiaire
		long code = sserv.modifier(s);
		System.out.println("code : " + code);

		if (code <= 0) {
			addActionError(getText("Erreur.modification.stagiaire"));

			return ERROR;
		}
		// message de confirmation et retour � l'interface de gestion
		addActionMessage(getText("Confirmation.modification.stagiaire"));
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
