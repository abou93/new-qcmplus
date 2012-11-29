/**
 * 
 */
package dao.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import beans.Utilisateur;
import dao.UtilisateurDAO;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class UtilisateurHibernateDAO implements UtilisateurDAO {
	private final static long ECHEC_CREATION = 0;

	/**
	 * @param u
	 * @return id de l'utilisateur créé
	 */
	public long creer(Utilisateur u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			// début de transaction
			tx = session.beginTransaction();
			// persistance de l'objet
			session.save(u);
			// commit de la transaction
			tx.commit();
			return u.getId();
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
	 * @return L'utilisateur
	 */
	public Utilisateur trouver(long id) {
		// récupération de la session hibernate
		Session session = HibernateUtil.getSession();
		// System.out.println("utilisateurHibernateDAO");
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

			Query q = session
					.createQuery("from Utilisateur as u where u.id =:id");
			q.setLong("id", id);

			return (Utilisateur) q.uniqueResult();
		} catch (RuntimeException e) {
			System.out.println(e);
			// if(tx != null) tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * @param nom
	 * @param mdp
	 * @return L'utilisateur
	 */
	public Utilisateur trouver(String nom, String mdp) {
		// récupération de la session hibernate
		Session session = HibernateUtil.getSession();
		// System.out.println("utilisateurHibernateDAO");
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

			Query q = session
					.createQuery("from Utilisateur as u where u.nom =:lenom and u.motDePasse =:lemdp");
			q.setString("lenom", nom);
			q.setString("lemdp", mdp);

			return (Utilisateur) q.uniqueResult();
		} catch (RuntimeException e) {
			System.out.println(e);
			// if(tx != null) tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * @param u
	 * @return true si modification ok
	 */
	public boolean modifier(Utilisateur u) {
		Session session;
		session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(u);
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
	 * @param u
	 * @return
	 */
	public boolean supprimer(Utilisateur u) {
		return supprimer(u.getId());
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id) {
		/*
		 * suppression logique - recherche de l'utilisateur en base - mise à
		 * true de son attribut estSupprime - MAJ de l'utilisateur en base
		 */
		// verification id valide (>0)
		if (id > 0) {
			Utilisateur u = trouver(id);
			u.setEstSupprime(true);
			return modifier(u);
		}
		return false;
	}
}
