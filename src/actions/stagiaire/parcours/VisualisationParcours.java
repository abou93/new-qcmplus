/**
 * 
 */
package actions.stagiaire.parcours;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class VisualisationParcours extends ActionSupport implements
		SessionAware {

	// pour jsp
	// liste des parcours pour le questionnaire selectionne
	private List<Parcours> listeParcoursQuestionnaire;
	// id du questionnaire selectionne
	private long qrid;
	//questionnaire s�lectionn�
	private Questionnaire qr;
	//liste des questionnaires du stagiaire
	private Set<Questionnaire> listeQuestionniairesStagiaire;

	// pour acc�s donn�es
	ParcoursService pserv = new ParcoursImplementService();
	QuestionnaireService qrserv = new QuestionnaireImplementService();

	// gestion de la session
	private Map<String, Object> session;

	@Override
	public String execute() {
		// on r�cup�re la liste des parcours effectu� par le stagiaire logg� (en
		// session)
		Stagiaire s = (Stagiaire) session.get("utilisateurSession");
		System.out.println("s : " + s);
		// r�cup�ration des parcours pour le questionnaire s�lectionn�
		List<Parcours> listeParcours = s.getListeParcours();
		//iterateur pour parcours de tous les parcours
		Iterator<Parcours> it = listeParcours.iterator();
		//init de la liste des parcours pour le questionnaire selectionne
		listeParcoursQuestionnaire = new ArrayList<Parcours>();
		while ( it.hasNext()) {
			Parcours p = it.next();
			if (p.getQuestionnaire().getId() == qrid)
			listeParcoursQuestionnaire.add(p);			
		}
		System.out.println("liste parcours pour le questionnaire(" + qrid
				+ ") : " + listeParcoursQuestionnaire);
		//r�cupration de la liste des questionnaires du stagiaire pour affichage
		setListeQuestionniairesStagiaire((Set<Questionnaire>) session.get("listeQuestionniairesStagiaire"));
		//Questionnaire conccern�
		qr = qrserv.trouverQuestionnaire(qrid);
		return SUCCESS;
	}
	
	/**
	 * @return the listeParcoursQuestionnaire
	 */
	public List<Parcours> getListeParcoursQuestionnaire() {
		return listeParcoursQuestionnaire;
	}

	/**
	 * @param listeParcoursQuestionnaire
	 *            the listeParcoursQuestionnaire to set
	 */
	public void setListeParcoursQuestionnaire(
			List<Parcours> listeParcoursQuestionnaire) {
		this.listeParcoursQuestionnaire = listeParcoursQuestionnaire;
	}

	/**
	 * @return the listeQuestionniairesStagiaire
	 */
	public Set<Questionnaire> getListeQuestionniairesStagiaire() {
		return listeQuestionniairesStagiaire;
	}

	/**
	 * @param listeQuestionniairesStagiaire the listeQuestionniairesStagiaire to set
	 */
	public void setListeQuestionniairesStagiaire(
			Set<Questionnaire> listeQuestionniairesStagiaire) {
		this.listeQuestionniairesStagiaire = listeQuestionniairesStagiaire;
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

	/**
	 * @return the qr
	 */
	public Questionnaire getQr() {
		return qr;
	}

	/**
	 * @param qr the qr to set
	 */
	public void setQr(Questionnaire qr) {
		this.qr = qr;
	}
	
	
}
