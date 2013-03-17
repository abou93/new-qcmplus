package actions.admin.questionnaire.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import services.QuestionImplementService;
import services.QuestionService;
import services.QuestionnaireImplementService;
import services.QuestionnaireService;
import beans.Question;
import beans.Questionnaire;
import beans.Reponse;

import com.opensymphony.xwork2.ActionSupport;

public class QuestionnaireNouvelleQuestion extends ActionSupport implements SessionAware{
		/**
	 * 
	 */

	private Map<String, Object> session;
	
	private List<Questionnaire> listeQuestionnaires;
	
	private List<Question> listeQuestionsQuestionnaire;
	
	/**
	 * questionnaire selectionne
	 */
	private Questionnaire qr;
	
	/**
	 * id questionnaire selectionne
	 */
	private long qrid;
	
	//pour acces bdd
	QuestionnaireService qrserv = new QuestionnaireImplementService();
	QuestionService qserv = new QuestionImplementService();
	
		@Override
		public String execute() {
			//A remplacer éventuellement par une trace de log
			System.out.println(this.toString());
			//recuperation de la liste des questionnaires chargee dans l'action initQuestionnaireNouvelleQuestion
			setListeQuestionnaires((List<Questionnaire>) session.get("listeQuestionnairesSession"));
			//on recupere le questionnaire selectionne
			setQr(qrserv.trouverQuestionnaire(qrid));
			//mise en session du questionnaire concerne
			session.put("questionnaireSession", qr);			
			//récupération de la liste des questions actuelles du questionnaire - ArrayList vide si null
			setListeQuestionsQuestionnaire(qserv.listerQuestions(qrid));
			//System.out.println("listeQuestionsQuestionnaire : "+listeQuestionsQuestionnaire);
			//mise en session de la liste des questions
			session.put("listeQuestionsSession", listeQuestionsQuestionnaire);	
			return SUCCESS;
		}
		
		/**
		 * @return the listeQuestionnaires
		 */
		public List<Questionnaire> getListeQuestionnaires() {
			return listeQuestionnaires;
		}



		/**
		 * @param listeQuestionnaires the listeQuestionnaires to set
		 */
		public void setListeQuestionnaires(List<Questionnaire> listeQuestionnaires) {
			this.listeQuestionnaires = listeQuestionnaires;
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



		/**
		 * @return the qrid
		 */
		public long getQrid() {
			return qrid;
		}



		/**
		 * @param qrid the qrid to set
		 */
		public void setQrid(long qrid) {
			this.qrid = qrid;
		}

		/**
		 * @param session the session to set
		 */
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

		public List<Question> getListeQuestionsQuestionnaire() {
			return listeQuestionsQuestionnaire;
		}

		//pour eviter d'avoir null dans listeQuestionsQuestionnaire
		public void setListeQuestionsQuestionnaire(
				List<Question> listeQuestionsQuestionnaire) {
			List<Question> listeQ = listeQuestionsQuestionnaire;
			if (listeQ == null) listeQ = new ArrayList<Question>();
			this.listeQuestionsQuestionnaire = listeQ;
		}
		
	
}
