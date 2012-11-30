/**
 * 
 */
package dao.hibernate;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import utils.HibernateUtil;
import beans.Stagiaire;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class StagiaireHibernateDAO extends UtilisateurHibernateDAO {

	/**
	 * @return la liste des stagiaires
	 */
	public Set<Stagiaire> listeStagiaires() {
		Session session = HibernateUtil.getSession();
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

			// //before fetch
			// Query q = session.createQuery("from Product as p ");

			// utilisation de fetch dans une equijointure pur charger
			// l'utilisateur avec le produit
			Query q = session
					.createQuery("FROM Stagiaire AS s WHERE s.estSupprime=:suppr");
			// sans les stagiaires supprim�s
			q.setBoolean("suppr", false);
			// mise dans un Set du resultat
			Set<Stagiaire> listeStagiaires = (Set<Stagiaire>) q.list();

			// //r�cup�ration de l'utilisateur r�f�renc� - �vite de passer �
			// lazy=false
			// for (Product p:lprod){
			// Hibernate.initialize(p.getCreateur());
			// }
			return listeStagiaires;
		} catch (RuntimeException e) {
			// if(tx != null) tx.rollback();
			return null;
		} finally {
			session.close();
		}
	}
}
