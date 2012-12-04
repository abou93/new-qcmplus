/**
 * 
 */
package actions.stagiaire.parcours;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

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
public class RechercheParcours extends ActionSupport implements SessionAware {
	// pour jsp
	//private List<Questionnaire> listeQuestionnaires;
	Set<Questionnaire> listeQuestionniairesStagiaire;

	// pour acc�s donn�es
	QuestionnaireService qrserv = new QuestionnaireImplementService();

	// gestion de la session
	private Map<String, Object> session;

	@Override
	public String execute() {
		// on r�cup�re la liste des questionniaires effectu� par le stagiaire
		// logg� (en session)
		Stagiaire s = (Stagiaire) session.get("utilisateurSession");
		//parcours du stagiaire
		List<Parcours> listeParcours = s.getListeParcours();
		
		//init du set pour la liste des questionnaires
		listeQuestionniairesStagiaire = new HashSet<Questionnaire>();
		//r�cup�ration des questionnaires effect�s par le stagiaire avec �limination des doublons
		Iterator<Parcours> it = listeParcours.iterator();
		while ( it.hasNext()) {
			listeQuestionniairesStagiaire.add(it.next().getQuestionnaire());			
		}		
		//mise en session des questionnaires du stagiaire;
		session.put("listeQuestionniairesStagiaire", listeQuestionniairesStagiaire);
		//System.out.println(listeQuestionniairesStagiaire);
		return SUCCESS;
	}

//	public List<Questionnaire> getListeQuestionnaires() {
//		return listeQuestionnaires;
//	}
//
//	public void setListeQuestionnaires(List<Questionnaire> listeQuestionnaires) {
//		this.listeQuestionnaires = listeQuestionnaires;
//	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	
}
