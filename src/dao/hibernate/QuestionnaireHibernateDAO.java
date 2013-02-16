/**
 * 
 */
package dao.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import beans.Questionnaire;
import dao.QuestionnaireDAO;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public class QuestionnaireHibernateDAO implements QuestionnaireDAO{

	private final static long ECHEC_CREATION = 0;
	/**
	 * @param u
	 * @return id du questionnaire cr��
	 */
	public long creer(Questionnaire q) {
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		try {
			//d�but de transaction
			tx = session.beginTransaction();
			//persistance de l'objet
			session.save(q);
			//commit de la transaction
			tx.commit();
			return q.getId();
		} catch (RuntimeException e) {
			//if(tx != null) tx.rollback();
			//message d'erreur pour la console
			e.printStackTrace();
			return ECHEC_CREATION;
		} finally {
			//fermeture de session syst�matique
			session.close();
		}

	}
	/**
	 * @param id
	 * @return Le questionnaire
	 */
	public Questionnaire trouverQuestionnaire(long id) {
		Session session = HibernateUtil.getSession();
		//System.out.println("QuestionnaireHibernateDAO");
		try {

			Query q = session
					.createQuery("from Questionnaire as questionnaire where questionnaire.id =:id");
			q.setLong("id",id);

			return (Questionnaire) q.uniqueResult();
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
	public boolean modifier(Questionnaire q) {
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
	public boolean supprimer(Questionnaire q) {
		return supprimer(q.getId());
	}
	
	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id) {
		if (id > 0) {
			Questionnaire q = trouverQuestionnaire(id);
			q.setEstSupprime(true);
			return modifier(q);
		}
		return false;
	}
	
	/**
	 * @return la liste des questionnaires
	 */
	public List<Questionnaire> listerQuestionnaires() {
		Session session = HibernateUtil.getSession();
		try {
			Query q = session
					.createQuery("FROM Questionnaire AS q WHERE q.estSupprime=:suppr");
			q.setBoolean("suppr", false);
			List<Questionnaire> maListeQuestionnaire = (List<Questionnaire>) q.list();
			System.out.println("Nombre d'�l�ments de ma liste:" +maListeQuestionnaire.size());
			return maListeQuestionnaire;
		} catch (RuntimeException e) {
			return null;
		} finally {
			session.close();
		}
	}
}

