package actions.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import services.QuestionnaireImplementService;
import services.QuestionnaireService;

import beans.Questionnaire;

import com.opensymphony.xwork2.ActionSupport;

public class TrouverQuestionnaire extends ActionSupport implements SessionAware{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Map<String, Object> session;
		QuestionnaireService testQuestionnaire = new QuestionnaireImplementService();

		@Override
		public String execute(){
			session.put("questionnaire", testQuestionnaire.trouverQuestionnaire(1));

			return SUCCESS;
		}

		@Override
		public void setSession(Map<String, Object> session) {
			// TODO Auto-generated method stub
			this.session = session;
		}
}
