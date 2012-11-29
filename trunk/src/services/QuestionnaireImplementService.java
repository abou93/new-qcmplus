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

	@Override
	public long creer(Questionnaire q) {
		// TODO Auto-generated method stub
			return this.maDAO.creer(q);
	}

	public Questionnaire trouverQuestionnaire(long id){
		// récupération de la session hibernate
		Session session = HibernateUtil.getSession();
		System.out.println("QuestionnaireHibernateDAO");
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

			Query q = session
					.createQuery("from Questionnaire as questionnaire where questionnaire.id =:id");
			q.setLong("id",id);

			return (Questionnaire) q.uniqueResult();
		} catch (RuntimeException e) {
			System.out.println(e);
			// if(tx != null) tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}

}
