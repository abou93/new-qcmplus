/**
 * 
 */
package dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import beans.Stagiaire;
import dao.StagiaireDAO;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class StagiaireHibernateDAO implements StagiaireDAO {
	private final static long ECHEC_CREATION = 0;


	/**
	 * @param u
	 * @return id de l'utilisateur cr��
	 */
	public long creer(Stagiaire u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			// d�but de transaction
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
			// fermeture de session syst�matique
			session.close();
		}
	}

	/**
	 * @param id
	 * @return L'utilisateur
	 */
	public Stagiaire trouver(long id) {
		// r�cup�ration de la session hibernate
		Session session = HibernateUtil.getSession();
		// System.out.println("utilisateurHibernateDAO");
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

			Query q = session
					.createQuery("from Stagiaire as u where u.id =:id");
			q.setLong("id", id);

			return (Stagiaire) q.uniqueResult();
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
	public Stagiaire trouver(String nom, String mdp) {
		// r�cup�ration de la session hibernate
		Session session = HibernateUtil.getSession();
		// System.out.println("utilisateurHibernateDAO");
		try {
			// session.beginTransaction();
			// Query q =
			// session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

			Query q = session
					.createQuery("from Stagiaire as u where u.nom =:lenom and u.motDePasse =:lemdp");
			q.setString("lenom", nom);
			q.setString("lemdp", mdp);

			return (Stagiaire) q.uniqueResult();
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
	public boolean modifier(Stagiaire u) {
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
	public boolean supprimer(Stagiaire u) {
		return supprimer(u.getId());
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id) {
		/*
		 * suppression logique - recherche de l'utilisateur en base - mise �
		 * true de son attribut estSupprime - MAJ de l'utilisateur en base
		 */
		// verification id valide (>0)
		if (id > 0) {
			Stagiaire u = trouver(id);
			u.setEstSupprime(true);
			return modifier(u);
		}
		return false;
	}
	
	/**
	 * @return la liste des stagiaires
	 */
	@Override
	public List<Stagiaire> liste() {
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
			List<Stagiaire> listeStagiaires = (List<Stagiaire>) q.list();

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
