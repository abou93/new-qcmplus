/**
 * 
 */
package dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import beans.Parcours;
import beans.Questionnaire;
import beans.Stagiaire;
import dao.ParcoursDAO;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class ParcoursHibernateDAO implements ParcoursDAO {
	private final static long ECHEC_CREATION = 0;

	/**
	 * @param p
	 * @return id du parcours créé
	 */
	public long creer(Parcours p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			// début de transaction
			tx = session.beginTransaction();
			// persistance de l'objet
			session.save(p);
			// commit de la transaction
			tx.commit();
			return p.getId();
		} catch (RuntimeException e) {
			// if(tx != null) tx.rollback();
			// message d'erruer pour la console
			e.printStackTrace();
			return ECHEC_CREATION;
		} finally {
			// fermeture de session systématique
			session.close();
		}
	}

	/**
	 * @param id
	 * @return Le parcours
	 */
	public Parcours trouver(long id) {
		// récupération de la session hibernate
		Session session = HibernateUtil.getSession();
		// System.out.println("utilisateurHibernateDAO");
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

			Query q = session.createQuery("from Parcours as p where p.id =:id");
			q.setLong("id", id);

			return (Parcours) q.uniqueResult();
		} catch (RuntimeException e) {
			System.out.println(e);
			// if(tx != null) tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * @param p
	 * @return true si modif ok
	 */
	public boolean modifier(Parcours p) {
		Session session;
		session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(p);
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
	 * @param p
	 * @return true si suppression ok
	 */
	public boolean supprimer(Parcours p) {
		return supprimer(p.getId());
	}

	/**
	 * @param id
	 * @return true si suppression ok
	 */
	public boolean supprimer(long id) {
		/*
		 * suppression logique - recherche de l'utilisateur en base - mise à
		 * true de son attribut estSupprime - MAJ de l'utilisateur en base
		 */
		// verification id valide (>0)
		if (id > 0) {
			Parcours p = trouver(id);
			p.setEstSupprime(true);
			return modifier(p);
		}
		return false;
	}

	/**
	 * @return la liste des parcours
	 */
	public List<Parcours> liste(Questionnaire qr, Stagiaire s) {
		Session session = HibernateUtil.getSession();
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
			//"FROM User AS u INNER JOIN FETCH u.listProduct"

			Query q = session
					.createQuery("FROM Parcours AS p WHERE p.stagiaire=:stagiaire AND p.questionnaire=:questionnaire");
			q.setEntity("stagiaire", s);
			q.setEntity("questionnaire", qr);
			List<Parcours> listParcours = (List<Parcours>) q.list();
			System.out.println("Liste parcours"+listParcours);
			return listParcours;
		} catch (RuntimeException e) {
			// if(tx != null) tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}

}
