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

public class NouveauQuestionnaire extends ActionSupport implements SessionAware{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Questionnaire qr = new Questionnaire();
	
	private Map<String, Object> session;
	
		@Override
		public void setSession(Map<String, Object> session) {
			// TODO Auto-generated method stub
			this.session = session;
		}

		public Questionnaire getQr() {
			return qr;
		}

		public void setQr(Questionnaire qr) {
			this.qr = qr;
		}
		
		
}
