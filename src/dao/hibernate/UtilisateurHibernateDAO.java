/**
 * 
 */
package dao.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;

import utils.HibernateUtil;
import beans.Utilisateur;
import dao.UtilisateurDAO;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class UtilisateurHibernateDAO implements UtilisateurDAO {

	/**
	 * @param id
	 * @return L'utilisateur
	 */
	public Utilisateur trouver(long id) {
		// r�cup�ration de la session hibernate
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
		// r�cup�ration de la session hibernate
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

}
