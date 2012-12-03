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
public class SelectionStagiaireSuppression extends ActionSupport implements SessionAware{
	// Variables pour jsp
	private String titre;
	private Stagiaire s;
	private List<Utilisateur> listeStagiaires;
	//select
	private long sid;
	// session pour stocker les attributs
		private Map<String, Object> session;
	

	// service pour gérer les utilisateurs
	StagiaireService userv = new StagiaireImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.modification.selection");
		//liste des stagiaires
		setListeStagiaires(userv.liste());
		System.out.println(listeStagiaires);
		setTitre(getText("Titre.stagiaire.modification"));
		s = (Stagiaire) userv.trouverParId(sid);
		System.out.println("selection : "+s + " id:"+s.getId());
		session.put("stagiaire", s);
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
