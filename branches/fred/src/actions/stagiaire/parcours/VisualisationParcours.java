/**
 * 
 */
package actions.stagiaire.parcours;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import services.ParcoursImplementService;
import services.ParcoursService;
import services.QuestionnaireImplementService;
import services.QuestionnaireService;
import beans.Parcours;
import beans.Questionnaire;
import beans.Stagiaire;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class VisualisationParcours extends ActionSupport implements SessionAware {
	
	//pour jsp
	private List<Parcours> listeParcours;
	private List<Questionnaire> listeQuestionnaires;
	private long qrid;
	
	//pour accès données
	ParcoursService pserv = new ParcoursImplementService();
	QuestionnaireService qrserv = new QuestionnaireImplementService();

	//gestion de la session
	private Map<String, Object> session;
	
	@Override
	public String execute() {
		//on récupère la liste des questionniaires effectué par le stagiaire loggé (en session)
		listeQuestionnaires = qrserv.listerQuestionnaires();
		//on récupère la liste des parcours effectué par le stagiaire loggé (en session)
		Stagiaire s = (Stagiaire) session.get("utilisateurSession");
		System.out.println("s : " + s);
		Questionnaire qr = qrserv.trouverQuestionnaire(qrid);
		System.out.println("QR : "+qr);
		listeParcours = pserv.liste(qr, s);
		System.out.println("liste parcours : "+ listeParcours);
		return SUCCESS;
	}

	/**
	 * @return the listeParcours
	 */
	public List<Parcours> getListeParcours() {
		return listeParcours;
	}

	/**
	 * @param listeParcours the listeParcours to set
	 */
	public void setListeParcours(List<Parcours> listeParcours) {
		this.listeParcours = listeParcours;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public long getQrid() {
		return qrid;
	}

	public void setQrid(long qrid) {
		this.qrid = qrid;
	}

	public List<Questionnaire> getListeQuestionnaires() {
		return listeQuestionnaires;
	}

	public void setListeQuestionnaires(List<Questionnaire> listeQuestionnaires) {
		this.listeQuestionnaires = listeQuestionnaires;
	}
}
