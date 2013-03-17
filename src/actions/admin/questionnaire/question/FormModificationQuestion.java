package actions.admin.questionnaire.question;

import java.util.ArrayList;
import java.util.Iterator;
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

public class FormModificationQuestion extends ActionSupport implements SessionAware{
		/**
	 * 
	 */

	private Map<String, Object> session;
	
	private List<Questionnaire> listeQuestionnaires;
	
	private List<Question> listeQuestionsQuestionnaire;
	//la liste des reponses possibles 
	private List<Reponse> listeReponsesQuestion;
	// les reponses possibles
		private Reponse reponse1;
		private Reponse reponse2;
		private Reponse reponse3;
		private Reponse reponse4;
		private Reponse reponse5;
	
	/**
	 * questionnaire selectionne
	 */
	private Questionnaire qr;
	
	private long qid;
	
	private Question q;
	
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
			//on recupere le questionnaire selectionne en session
			setQr((Questionnaire) session.get("questionnaireSession"));			
			//récupération de la liste des questions actuelles du questionnaire - ArrayList vide si null
			setListeQuestionsQuestionnaire((List<Question>) session.get("listeQuestionsSession"));
			System.out.println("listeQuestionsQuestionnaire : "+listeQuestionsQuestionnaire);
			//récupération de la question
			setQ(qserv.trouver(qid));
			session.put("questionSession", q);
			
			//reponses
			listeReponsesQuestion = q.getListeReponses();
			setReponse1(listeReponsesQuestion.get(0));
			setReponse2(listeReponsesQuestion.get(1));
			setReponse3(listeReponsesQuestion.get(2));
			setReponse4(listeReponsesQuestion.get(3));
			setReponse5(listeReponsesQuestion.get(4));
			//System.out.println("listeReponses : "+listeReponsesQuestion);			
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

		public Question getQ() {
			return q;
		}

		public void setQ(Question q) {
			this.q = q;
		}

		public long getQid() {
			return qid;
		}

		public void setQid(long qid) {
			this.qid = qid;
		}

		public Reponse getReponse1() {
			return reponse1;
		}

		public void setReponse1(Reponse reponse1) {
			this.reponse1 = reponse1;
		}

		public Reponse getReponse2() {
			return reponse2;
		}

		public void setReponse2(Reponse reponse2) {
			this.reponse2 = reponse2;
		}

		public Reponse getReponse3() {
			return reponse3;
		}

		public void setReponse3(Reponse reponse3) {
			this.reponse3 = reponse3;
		}

		public Reponse getReponse4() {
			return reponse4;
		}

		public void setReponse4(Reponse reponse4) {
			this.reponse4 = reponse4;
		}

		public Reponse getReponse5() {
			return reponse5;
		}

		public void setReponse5(Reponse reponse5) {
			this.reponse5 = reponse5;
		}
		
	
}
