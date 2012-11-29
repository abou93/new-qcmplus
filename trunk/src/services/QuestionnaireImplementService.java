/**
 * 
 */
package services;

import dao.QuestionnaireDAO;
import dao.hibernate.QuestionnaireHibernateDAO;
import beans.Questionnaire;

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

	@Override
	public long creer(Questionnaire q) {
		// TODO Auto-generated method stub
			return this.maDAO.creer(q);
	}

}
