package actions.admin.questionnaire;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import services.QuestionnaireImplementService;
import services.QuestionnaireService;
import services.UtilisateurImplementService;
import services.UtilisateurService;

import beans.Administrateur;
import beans.Questionnaire;
import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

public class ModifierQuestionnaire extends ActionSupport implements SessionAware{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Questionnaire> listeQuestionnaires;
	
	private Questionnaire qr;
	
	private long questionnaireSelected;
	
	private Map<String, Object> session;
	

	QuestionnaireService qserv = new QuestionnaireImplementService();
	

		@Override
		public String execute() {
			listeQuestionnaires = qserv.listerQuestionnaires();
			setQr(qserv.trouverQuestionnaire(questionnaireSelected));
			return SUCCESS;
		}
		
		@Override
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

		public List<Questionnaire> getListeQuestionnaires() {
			return listeQuestionnaires;
		}

		public void setListeQuestionnaires(List<Questionnaire> listeQuestionnaire) {
			this.listeQuestionnaires = listeQuestionnaire;
		}

		public long getQuestionnaireSelected() {
			return questionnaireSelected;
		}

		public void setQuestionnaireSelected(long questionnaireSelected) {
			this.questionnaireSelected = questionnaireSelected;
		}

		public Questionnaire getQr() {
			return qr;
		}

		public void setQr(Questionnaire qr) {
			this.qr = qr;
		}

	
}
