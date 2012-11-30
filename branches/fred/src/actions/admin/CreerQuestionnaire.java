package actions.admin;

import java.util.Map;

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

public class CreerQuestionnaire extends ActionSupport implements SessionAware{
		/**
	 * 
	 */
	private Questionnaire q;
	
	private static final long serialVersionUID = 1L;
	
	QuestionnaireService qserv = new QuestionnaireImplementService();
	
	private Map<String, Object> session;
	
		@Override
		public String execute() {
			qserv.creer(q);
			return SUCCESS;
		}
		
		
		@Override
		public void setSession(Map<String, Object> session) {
			// TODO Auto-generated method stub
			this.session = session;
		}


		public Questionnaire getQ() {
			return q;
		}


		public void setQ(Questionnaire q) {
			this.q = q;
		}
		
}
