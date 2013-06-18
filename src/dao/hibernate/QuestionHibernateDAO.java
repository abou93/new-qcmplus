/**
 * 
 */
package dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import beans.Question;
import beans.Reponse;
import dao.QuestionDAO;

/**
 * @author Stephane Sikora & Frederic Aubry
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
			// debut de transaction
			tx = session.beginTransaction();
			
			//on sauvegarde d'abord les reponses (toutes validees par le service)
			List<Reponse> listeReponses = q.getListeReponses();
			Iterator<Reponse> it = listeReponses.iterator();
			while (it.hasNext()){
				Reponse rep= it.next();
				session.save(rep);
			}
			// persistance de l'objet
			session.save(q);
			// commit de la transaction
			tx.commit();
			return q.getId();
		} catch (RuntimeException e) {
			//quelque chose s'est mal passe, on annule tout
			 if(tx != null) tx.rollback();
			// message d'erreur pour la console
			e.printStackTrace();
			return ECHEC_CREATION;
		} finally {
			// fermeture de session systematique
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
			//MAJ des reponses
			List<Reponse> listeReponses = q.getListeReponses();
			Iterator<Reponse> it = listeReponses.iterator();
			while (it.hasNext()){
				Reponse rep= it.next();
				session.merge(rep);
			}
			//maj de la question
			System.out.println("DAO : intitule question avt:: "+q.getIntitule());
			session.merge(q);
			System.out.println("DAO : intitule question apr:: "+q.getIntitule());
			tx.commit();
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
