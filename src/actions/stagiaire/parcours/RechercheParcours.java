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
import services.StagiaireImplementService;
import services.UtilisateurService;
import beans.Parcours;
import beans.Questionnaire;
import beans.Stagiaire;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class RechercheParcours extends ActionSupport {
	// pour jsp
	private List<Questionnaire> listeQuestionnaires;

	// pour accès données
	QuestionnaireService qrserv = new QuestionnaireImplementService();
	
	@Override
	public String execute() {
		//on récupère la liste des questionniaires effectué par le stagiaire loggé (en session)
		listeQuestionnaires = qrserv.listerQuestionnaires();
		//System.out.println(listeQuestionnaires);
		return SUCCESS;
	}

	public List<Questionnaire> getListeQuestionnaires() {
		return listeQuestionnaires;
	}

	public void setListeQuestionnaires(List<Questionnaire> listeQuestionnaires) {
		this.listeQuestionnaires = listeQuestionnaires;
	}
}
