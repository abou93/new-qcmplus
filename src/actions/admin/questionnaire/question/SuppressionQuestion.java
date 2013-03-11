/**
 * 
 */
package actions.admin.questionnaire.question;

import java.util.ArrayList;
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
public class SuppressionQuestion extends ActionSupport implements SessionAware {
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
	QuestionnaireService qrserv = new QuestionnaireImplementService();
	ReponseService rserv = new ReponseImplementService();
	QuestionService qserv = new QuestionImplementService();

	@Override
	public String execute() {
		//A remplacer éventuellement par une trace de log
				System.out.println(this.toString());
		// recuperation de la liste des questionnaires chargee dans l'action
		// initQuestionnaireNouvelleQuestion
		setListeQuestionnaires((List<Questionnaire>) session
				.get("listeQuestionnairesSession"));
		// on recupere le questionnaire selectionne en session
		setQr((Questionnaire) session.get("questionnaireSession"));

		// mise en correspondance avec le questionnaire
		q.setQuestionnaire(qr);

		// tentative sauvegarde question -recuperation de l'id de la question
		// sauvegarde
		long qid = qserv.creer(q);
		System.out.println("reponse creation question : " + qid);
		System.out.println("id de Q : " + q.getId());

		// ajout des reponses a la question
		// creation de la liste des reponses
		List<Reponse> listeReponses = new ArrayList<Reponse>();
		if (reponse1 != null && !"".equals(reponse1.getLibelle())) {
			reponse1.setQuestion(q);
			rserv.creer(reponse1);
			listeReponses.add(reponse1);

		}
		if (reponse2 != null && !"".equals(reponse2.getLibelle())) {
			reponse2.setQuestion(q);
			rserv.creer(reponse2);
			listeReponses.add(reponse2);
		}
		if (reponse3 != null && !"".equals(reponse3.getLibelle())) {
			reponse3.setQuestion(q);
			rserv.creer(reponse3);
			listeReponses.add(reponse3);
		}
		if (reponse4 != null && !"".equals(reponse4.getLibelle())) {
			reponse4.setQuestion(q);
			rserv.creer(reponse4);
			listeReponses.add(reponse4);
		}
		if (reponse5 != null && !"".equals(reponse5.getLibelle())) {
			reponse5.setQuestion(q);
			rserv.creer(reponse5);
			listeReponses.add(reponse5);
		}

		// affiche reponses pout ctrl
		// for (Reponse reponse : listeReponses) {
		// System.out.println(reponse);
		// }

		// q.setListeReponses(listeReponses);

		// update de question pour ajout reponses
		// qserv.modifier(q);

		// récupération de la liste des questions actuelles du questionnaire -
		// ArrayList vide si null
		setListeQuestionsQuestionnaire((List<Question>) session
				.get("listeQuestionsSession"));
		// ajout de la question a la liste (inutile puisque retour a la page de
		// gestion)
		listeQuestionsQuestionnaire.add(q);
		return SUCCESS;
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

	/**
	 * @return the reponse1
	 */
	public Reponse getReponse1() {
		return reponse1;
	}

	/**
	 * @param reponse1
	 *            the reponse1 to set
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
	 * @param reponse2
	 *            the reponse2 to set
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
	 * @param reponse3
	 *            the reponse3 to set
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
	 * @param reponse4
	 *            the reponse4 to set
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
	 * @param reponse5
	 *            the reponse5 to set
	 */
	public void setReponse5(Reponse reponse5) {
		this.reponse5 = reponse5;
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

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
