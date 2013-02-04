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
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class SelectionStagiaireModification extends ActionSupport implements SessionAware{
	// Variables pour jsp
	private String titre;
	private Stagiaire s;
	private List<Stagiaire> listeStagiaires;
	//select
	private long sid;
	// session pour stocker les attributs
		private Map<String, Object> session;
	

	// service pour g�rer les utilisateurs
	StagiaireService sserv = new StagiaireImplementService();

	// action de login
	@Override
	public String execute() {
		System.out.println("actions.admin.stagiaire.modification.selection");
		//liste des stagiaires
		setListeStagiaires(sserv.liste());
		//titre de la page
		setTitre(getText("Titre.stagiaire.modification"));
		s = (Stagiaire) sserv.trouverParId(sid);
		//mise en session de l'id
		session.put("sid", sid);
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
