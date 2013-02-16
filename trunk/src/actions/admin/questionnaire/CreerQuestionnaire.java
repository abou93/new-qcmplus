package actions.admin.questionnaire;

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
	private Questionnaire qr;
	
	private static final long serialVersionUID = 1L;
	
	QuestionnaireService qserv = new QuestionnaireImplementService();
	
	private Map<String, Object> session;
	
		@Override
		public String execute() {
			qserv.creer(qr);
			return SUCCESS;
		}
		
		
		@Override
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}


		public Questionnaire getQr() {
			return qr;
		}


		public void setQr(Questionnaire qr) {
			this.qr = qr;
		}
		
}
