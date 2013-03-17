/**
 * 
 */
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
import services.ReponseImplementService;
import services.ReponseService;
import beans.Question;
import beans.Questionnaire;
import beans.Reponse;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class ModificationQuestion extends ActionSupport implements SessionAware {
	/**
	 * 
	 */

	private Map<String, Object> session;

	private List<Questionnaire> listeQuestionnaires;

	private List<Question> listeQuestionsQuestionnaire;

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

	/**
	 * id questionnaire selectionne
	 */
	private long qrid;

	private Question q;

	// pour acces bdd
	// QuestionnaireService qrserv = new QuestionnaireImplementService();
	// ReponseService rserv = new ReponseImplementService();
	QuestionService qserv = new QuestionImplementService();

	@Override
	public String execute() {
		// A remplacer éventuellement par une trace de log
		System.out.println(this.toString());
		System.out.println("liste reponses Question : " + q.getListeReponses());
		// recuperation de la liste des questionnaires chargee dans l'action
		// initQuestionnaireNouvelleQuestion
		setListeQuestionnaires((List<Questionnaire>) session.get("listeQuestionnairesSession"));
		// on recupere le questionnaire selectionne en session
		setQr((Questionnaire) session.get("questionnaireSession"));

		// mise en correspondance avec le questionnaire
		setQ((Question) session.get("questionSession"));

		// on associe les nouvelles reponses a la question
		// recuperation de la liste des reponses 
		List<Reponse> listeReponses = q.getListeReponses();
		//on reconstitue la liste avec les nouvelles reponses
		// association des reponses a la question et ajout a la liste
		reponse1.setQuestion(q);
		//recuperation de l'id de la reponse 1 de la question
		reponse1.setId(listeReponses.get(0).getId());
		listeReponses.add(reponse1);

		reponse2.setQuestion(q);
		//recuperation de l'id de la reponse21 de la question
		reponse2.setId(listeReponses.get(1).getId());
		listeReponses.add(reponse2);

		reponse3.setQuestion(q);
		//recuperation de l'id de la reponse 3 de la question
		reponse3.setId(listeReponses.get(2).getId());
		listeReponses.add(reponse3);

		reponse4.setQuestion(q);
		//recuperation de l'id de la reponse 4 de la question
		reponse4.setId(listeReponses.get(3).getId());
		listeReponses.add(reponse4);

		reponse5.setQuestion(q);
		//recuperation de l'id de la reponse 5 de la question
		reponse5.setId(listeReponses.get(4).getId());
		listeReponses.add(reponse5);
		
		//retrait des anciennes reponses de la liste
		for (int i=0;i<5;i++){
			listeReponses.remove(i);
		}

		if (qserv.modifier(q)){
			//modification valide
			return SUCCESS;
		} else {
			//la question ou ses reponses sont invalides
			final String MESSAGE = "Question.invalide";
			this.addActionError(getText(MESSAGE));
			return ERROR;
		}
		
	}

	/**
	 * @return the listeQuestionnaires
	 */
	public List<Questionnaire> getListeQuestionnaires() {
		return listeQuestionnaires;
	}

	/**
	 * @param listeQuestionnaires
	 *            the listeQuestionnaires to set
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
	 * @param qr
	 *            the qr to set
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
	 * @param qrid
	 *            the qrid to set
	 */
	public void setQrid(long qrid) {
		this.qrid = qrid;
	}

	public List<Question> getListeQuestionsQuestionnaire() {
		return listeQuestionsQuestionnaire;
	}

	// pour eviter d'avoir null dans listeQuestionsQuestionnaire
	public void setListeQuestionsQuestionnaire(
			List<Question> listeQuestionsQuestionnaire) {
		List<Question> listeQ = listeQuestionsQuestionnaire;
		if (listeQ == null)
			listeQ = new ArrayList<Question>();
		this.listeQuestionsQuestionnaire = listeQ;
	}

	public Question getQ() {
		return q;
	}

	public void setQ(Question q) {
		this.q = q;
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

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
