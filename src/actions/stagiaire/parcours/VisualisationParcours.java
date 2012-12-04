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
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class VisualisationParcours extends ActionSupport implements SessionAware {
	
	//pour jsp
	private List<Parcours> listeParcours;
	private List<Questionnaire> listeQuestionnaires;
	private long qrid;
	
	//pour acc�s donn�es
	ParcoursService pserv = new ParcoursImplementService();
	QuestionnaireService qrserv = new QuestionnaireImplementService();

	//gestion de la session
	private Map<String, Object> session;
	
	@Override
	public String execute() {
		//on r�cup�re la liste des questionniaires effectu� par le stagiaire logg� (en session)
		listeQuestionnaires = qrserv.listerQuestionnaires();
		//on r�cup�re la liste des parcours effectu� par le stagiaire logg� (en session)
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
