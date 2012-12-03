/**
 * 
 */
package dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utils.HibernateUtil;
import beans.Utilisateur;
import dao.StagiaireDAO;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class StagiaireHibernateDAO extends UtilisateurHibernateDAO implements StagiaireDAO {

	/**
	 * @return la liste des stagiaires
	 */
	public List<Utilisateur> liste() {
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
			// sans les stagiaires supprimés
			q.setBoolean("suppr", false);
			// mise dans un Set du resultat
			List<Utilisateur> listeStagiaires = (List<Utilisateur>) q.list();

			// //récupération de l'utilisateur référencé - évite de passer à
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
