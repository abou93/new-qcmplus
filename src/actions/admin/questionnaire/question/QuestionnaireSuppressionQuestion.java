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

public class QuestionnaireSuppressionQuestion extends ActionSupport implements SessionAware{
		/**
	 * 
	 */

	private Map<String, Object> session;
	
	private List<Questionnaire> listeQuestionnaires;
	
	private List<Question> listeQuestionsQuestionnaire;
	//les reponses possibles 
	private Reponse reponse1;
	private Reponse reponse2;
	private Reponse reponse3;
	private Reponse reponse4;
	private Reponse reponse5;
	
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
			//recuperation de la liste des questionnaires chargee dans l'action initQuestionnaireNouvelleQuestion
			setListeQuestionnaires((List<Questionnaire>) session.get("listeQuestionnairesSession"));
			//on recupere le questionnaire selectionne
			setQr(qrserv.trouverQuestionnaire(qrid));
			//mise en session du questionnaire concerne
			session.put("questionnaireSession", qr);			
			//récupération de la liste des questions actuelles du questionnaire - ArrayList vide si null
			setListeQuestionsQuestionnaire(qserv.listerQuestions(qrid));
			System.out.println("listeQuestionsQuestionnaire : "+listeQuestionsQuestionnaire);
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
		 * @return the reponse1
		 */
		public Reponse getReponse1() {
			return reponse1;
		}

		/**
		 * @param reponse1 the reponse1 to set
		 */
		public void setReponse1(Reponse reponse1) {
			this.reponse1 = reponse1;
		}

		/**
		 * @return the reponse2
		 */
		public Reponse getReponse2() {
			return reponse2;
		}

		/**
		 * @param reponse2 the reponse2 to set
		 */
		public void setReponse2(Reponse reponse2) {
			this.reponse2 = reponse2;
		}

		/**
		 * @return the reponse3
		 */
		public Reponse getReponse3() {
			return reponse3;
		}

		/**
		 * @param reponse3 the reponse3 to set
		 */
		public void setReponse3(Reponse reponse3) {
			this.reponse3 = reponse3;
		}

		/**
		 * @return the reponse4
		 */
		public Reponse getReponse4() {
			return reponse4;
		}

		/**
		 * @param reponse4 the reponse4 to set
		 */
		public void setReponse4(Reponse reponse4) {
			this.reponse4 = reponse4;
		}

		/**
		 * @return the reponse5
		 */
		public Reponse getReponse5() {
			return reponse5;
		}

		/**
		 * @param reponse5 the reponse5 to set
		 */
		public void setReponse5(Reponse reponse5) {
			this.reponse5 = reponse5;
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
