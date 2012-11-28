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

	/**
	 * @param u
	 * @return id de l'utilisateur créé
	 */
	public long creer(Utilisateur u) {
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		try {
			//System.out.println("heeee"+u.getLogin());
			tx = session.beginTransaction();
			session.save(u);
			tx.commit();
			return 1;
		} catch (RuntimeException e) {
			//if(tx != null) tx.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}

	}

	/**
	 * @param id
	 * @return L'utilisateur
	 */
	public Utilisateur trouverUtilisateur(long id) {
		return null;
	}

	/**
	 * @param nom
	 * @param mdp
	 * @return L'utilisateur
	 */
	public Utilisateur trouverUtilisateur(String nom, String mdp) {
		// récupération de la session hibernate
		Session session = HibernateUtil.getSession();
		System.out.println("utilisateurHibernateDAO");
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
	 * @return
	 */
	public boolean modifier(Utilisateur u) {
		return false;
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean modifier(long id) {
		return false;
	}

	/**
	 * @param u
	 * @return
	 */
	public boolean supprimer(Utilisateur u) {
		return false;
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id) {
		return false;
	}

}
