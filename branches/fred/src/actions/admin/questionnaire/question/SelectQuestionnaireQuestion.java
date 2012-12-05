package actions.admin.questionnaire.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import services.QuestionImplementService;
import services.QuestionService;
import services.QuestionnaireImplementService;
import services.QuestionnaireService;
import services.UtilisateurImplementService;
import services.UtilisateurService;

import beans.Administrateur;
import beans.Question;
import beans.Questionnaire;
import beans.Stagiaire;
import beans.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

public class SelectQuestionnaireQuestion extends ActionSupport implements SessionAware{
		/**
	 * 
	 */

	private Map<String, Object> session;
	
	private List<Questionnaire> listeQuestionnaires;
	private Questionnaire monQuestionnaire;
	private long lgQuestionnaireSelected;
	QuestionnaireService qserv = new QuestionnaireImplementService();
	
	private ArrayList<Question> listeMesQuestions;
	QuestionService questionServ = new QuestionImplementService();

		@Override
		public String execute() {
			setListeQuestionnaires(qserv.listerQuestionnaires());
			setMonQuestionnaire(qserv.trouverQuestionnaire(lgQuestionnaireSelected));
			
			if(questionServ.listerQuestions(lgQuestionnaireSelected)==null){
				setListeMesQuestions(new ArrayList<Question>());
			}else{
				setListeMesQuestions(questionServ.listerQuestions(lgQuestionnaireSelected));
			}
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
		 * @return the monQuestionnaire
		 */
		public Questionnaire getMonQuestionnaire() {
			return monQuestionnaire;
		}

		/**
		 * @param monQuestionnaire the monQuestionnaire to set
		 */
		public void setMonQuestionnaire(Questionnaire monQuestionnaire) {
			this.monQuestionnaire = monQuestionnaire;
		}

		/**
		 * @return the lgQuestionnaireSelected
		 */
		public long getLgQuestionnaireSelected() {
			return lgQuestionnaireSelected;
		}

		/**
		 * @param lgQuestionnaireSelected the lgQuestionnaireSelected to set
		 */
		public void setLgQuestionnaireSelected(long lgQuestionnaireSelected) {
			this.lgQuestionnaireSelected = lgQuestionnaireSelected;
		}

		/**
		 * @return the listeMesQuestions
		 */
		public ArrayList<Question> getListeMesQuestions() {
			return listeMesQuestions;
		}

		/**
		 * @param listeMesQuestions the listeMesQuestions to set
		 */
		public void setListeMesQuestions(ArrayList<Question> listeMesQuestions) {
			this.listeMesQuestions = listeMesQuestions;
		}

		/**
		 * @param session the session to set
		 */
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}
		
	
}
