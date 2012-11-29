/**
 * 
 */
package services;

import org.hibernate.Query;
import org.hibernate.Session;

import utils.HibernateUtil;
import dao.QuestionnaireDAO;
import dao.hibernate.QuestionnaireHibernateDAO;
import beans.Questionnaire;
import beans.Utilisateur;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class QuestionnaireImplementService implements QuestionnaireService {

	/* (non-Javadoc)
	 * @see services.QuestionnaireService#creer(beans.Questionnaire)
	 */
	
	QuestionnaireDAO maDAO;


	/**
	 * @param maDAO
	 */
	public QuestionnaireImplementService() {
		this.maDAO = new QuestionnaireHibernateDAO();
	}

	public long creer(Questionnaire q) {
			return this.maDAO.creer(q);
	}

	public Questionnaire trouverQuestionnaire(long id){
		return this.maDAO.trouverQuestionnaire(id);
	}

	public boolean modifier(Questionnaire q){
		return false;
		
	}
}
