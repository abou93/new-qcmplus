package actions.admin.questionnaire;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import services.QuestionnaireImplementService;
import services.QuestionnaireService;

import beans.Questionnaire;

import com.opensymphony.xwork2.ActionSupport;

public class GestionQuestionnaires extends ActionSupport implements SessionAware{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Map<String, Object> session;

		@Override
		public void setSession(Map<String, Object> session) {
			// TODO Auto-generated method stub
			this.session = session;
		}
}
