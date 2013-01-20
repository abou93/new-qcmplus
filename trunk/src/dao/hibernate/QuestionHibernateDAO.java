/**
 * 
 */
package dao.hibernate;

import java.util.List;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import beans.Question;
import beans.Questionnaire;
import dao.QuestionDAO;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class QuestionHibernateDAO implements QuestionDAO {

	private final static long ECHEC_CREATION = 0;

	/**
	 * @param q
	 * @return id de la question creee
	 */
	public long creer(Question q) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			// d�but de transaction
			tx = session.beginTransaction();
			// persistance de l'objet
			session.save(q);
			// commit de la transaction
			tx.commit();
			return q.getId();
		} catch (RuntimeException e) {
			// if(tx != null) tx.rollback();
			// message d'erreur pour la console
			e.printStackTrace();
			return ECHEC_CREATION;
		} finally {
			// fermeture de session syst�matique
			session.close();
		}
	}

	@Override
	public Question trouver(long qid) {
		Session session = HibernateUtil.getSession();
		// System.out.println("QuestionnaireHibernateDAO");
		try {

			Query q = session
					.createQuery("from Question as question where question.id =:id");
			q.setLong("id", qid);

			return (Question) q.uniqueResult();
		} catch (RuntimeException e) {
			System.out.println(e);
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * @param q
	 * @return
	 */
	public boolean modifier(Question q) {
		Session session;
		session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(q);
			session.getTransaction().commit();
		} catch (Exception e) {
			// rollback si erreur
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean modifier(long id) {
		return false;
	}

	/**
	 * @param q
	 * @return
	 */
	public boolean supprimer(Question q) {
		return false;
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id) {
		return false;
	}

	/**
	 * @return la liste des questions
	 */
	public List<Question> listerQuestionsQuestionnaire(long idQuestionnaire) {
		Session session = HibernateUtil.getSession();
		try {
			Query q = session
					.createQuery("FROM Question AS question WHERE question.estSupprime=:suppr and question.questionnaire.id=:id");
			q.setBoolean("suppr", false);
			q.setLong("id", idQuestionnaire);
			List<Question> maListeQuestions = (List<Question>) q.list();
			return maListeQuestions;
		} catch (RuntimeException e) {
			return null;
		} finally {
			session.close();
		}
	}
}
