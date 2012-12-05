package actions.admin.questionnaire.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import services.QuestionnaireImplementService;
import services.QuestionnaireService;
import beans.Questionnaire;

import com.opensymphony.xwork2.ActionSupport;

public class InitQuestionnaireNouvelleQuestion extends ActionSupport implements
		SessionAware {
	/**
	 * 
	 */

	private Map<String, Object> session;

	private List<Questionnaire> listeQuestionnaires;
	// private Questionnaire monQuestionnaire;
	// private long lgQuestionnaireSelected;
	QuestionnaireService qserv = new QuestionnaireImplementService();

	// private ArrayList<Question> listeMesQuestions;
	// QuestionService qserv = new QuestionImplementService();

	@Override
	public String execute() {
		setListeQuestionnaires(qserv.listerQuestionnaires());
		// mise en session de la liste des questionnaires
		session.put("listeQuestionnairesSession", listeQuestionnaires);
		// setMonQuestionnaire(qrserv.trouverQuestionnaire(lgQuestionnaireSelected));

		// setListeMesQuestions(qserv.listerQuestions(lgQuestionnaireSelected));
		// System.out.println("nombre de questions: "+qserv.listerQuestions(lgQuestionnaireSelected));

		return SUCCESS;
	}

	/**
	 * @return the listeQuestionnaires
	 */
	public List<Questionnaire> getListeQuestionnaires() {
		return listeQuestionnaires;
	}

	/**
	 * Si la liste en argument est inexistante(null) on renvoie un ArrayList vide
	 * @param listeQuestionnaires
	 *            the listeQuestionnaires to set
	 */
	public void setListeQuestionnaires(List<Questionnaire> listeQuestionnaires) {
		List<Questionnaire> listeQ;
		listeQ = listeQuestionnaires;
		if (listeQ == null) listeQ = new ArrayList<Questionnaire>();
		this.listeQuestionnaires = listeQ;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
