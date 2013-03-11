/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ReponseDAO;

import utils.HibernateUtil;

import beans.Parcours;
import beans.Question;
import beans.Reponse;
import beans.Stagiaire;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class ReponseHibernateDAO implements ReponseDAO {
	private static final long ECHEC_CREATION = 0;

	/**
	 * @param r
	 * @return id de la reponse creee
	 */
	public long creer(Reponse r) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			// d�but de transaction
			tx = session.beginTransaction();
			// persistance de l'objet
			session.save(r);
			// commit de la transaction
			tx.commit();
			return r.getId();
		} catch (RuntimeException e) {
			// if(tx != null) tx.rollback();
			// message d'erreur pour la console
			e.printStackTrace();
			return ECHEC_CREATION;
		} finally {
			// fermeture de session systematique
			session.close();
		}
	}

	/**
	 * @param id
	 * @return La reponse
	 */
	public Reponse trouverReponse(long id) {
		return null;
	}

	/**
	 * @param r
	 * @return
	 */
	public boolean modifier(Reponse r) {
		Session session;
		session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.merge(r);
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
	 * @param r
	 * @return
	 */
	public boolean supprimer(Reponse r) {
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
	 * @return la liste des reponses
	 */
	public ArrayList<Reponse> listeReponses() {
		return null;
	}

	/**
	 * @return la liste des reponses � une question
	 */
	public List<Reponse> listeReponses(Question q) {
		Session session = HibernateUtil.getSession();
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
			//"FROM User AS u INNER JOIN FETCH u.listProduct"

			Query query = session
					.createQuery("FROM Reponse AS r WHERE r.question=:question AND r.estSupprime=:suppr");
			query.setEntity("question", q);
			query.setBoolean("suppr", false);
			List<Reponse> listeReponses = (List<Reponse>) query.list();
			System.out.println("Liste reponses (base)"+listeReponses);
			return listeReponses;
		} catch (RuntimeException e) {
			// if(tx != null) tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}
}
