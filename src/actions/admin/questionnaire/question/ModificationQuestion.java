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
	
	private List<Reponse> listeReponsesQuestion;

	// les reponses possibles
	// private Reponse reponse1;
	// private Reponse reponse2;
	// private Reponse reponse3;
	// private Reponse reponse4;
	// private Reponse reponse5;

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
		System.out.println("liste reponses Question : "+listeReponsesQuestion);
		// recuperation de la liste des questionnaires chargee dans l'action
		// initQuestionnaireNouvelleQuestion
		setListeQuestionnaires((List<Questionnaire>) session
				.get("listeQuestionnairesSession"));
		// on recupere le questionnaire selectionne en session
		setQr((Questionnaire) session.get("questionnaireSession"));

		// mise en correspondance avec le questionnaire
		setQ((Question) session.get("questionSession"));

		// controle des reponses a la question : il doit y en avoir au moins 2 valides dont une correcte
		int countValid = 0;
		for (Iterator<Reponse> iterator = listeReponsesQuestion.iterator(); iterator.hasNext();) {
			Reponse rep = (Reponse) iterator.next();
			//si la reponse est valide, on la comptabilise
			if (rep.getLibelle() != null && !"".equals(rep.getLibelle())) {
				
			}	
			else {
				// sinon ajout message d'erreur et renvoi vers le formulaire
				//final String MESSAGE = "Reponse.erreur";
				//this.addActionError(getText(MESSAGE));
				//return ERROR;
			}
		}
		//on associe les nouvelles reponses a la question
		q.setListeReponses(listeReponsesQuestion);
		

		// affiche reponses pout ctrl
		int i=0;
		for (Reponse reponse : listeReponsesQuestion) {
			i++;
		 System.out.println("reponse "+i+ " : "+reponse);
		}

		// tentative sauvegarde question -recuperation de l'id de la question
		// sauvegarde
		boolean modOk = qserv.modifier(q);
		System.out.println("modification question : " + modOk);
		
		

//		// récupération de la liste des questions actuelles du questionnaire -
//		// ArrayList vide si null
//		setListeQuestionsQuestionnaire((List<Question>) session
//				.get("listeQuestionsSession"));
//		// ajout de la question a la liste (inutile puisque retour a la page de
//		// gestion)
//		// listeQuestionsQuestionnaire.add(q);
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

	public List<Reponse> getListeReponsesQuestion() {
		return listeReponsesQuestion;
	}

	public void setListeReponsesQuestion(List<Reponse> listeReponsesQuestion) {
		this.listeReponsesQuestion = listeReponsesQuestion;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
