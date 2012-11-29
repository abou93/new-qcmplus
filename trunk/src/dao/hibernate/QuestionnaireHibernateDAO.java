/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

import dao.QuestionnaireDAO;

import beans.Questionnaire;
import beans.Utilisateur;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class QuestionnaireHibernateDAO implements QuestionnaireDAO{

	private final static long ECHEC_CREATION = 0;
	/**
	 * @param u
	 * @return id du questionnaire créé
	 */
	public long creer(Questionnaire q) {
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		try {
			//début de transaction
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
			//fermeture de session systématique
			session.close();
		}

	}
	/**
	 * @param id
	 * @return Le questionnaire
	 */
	public Questionnaire trouverQuestionnaire(long id) {
		Session session = HibernateUtil.getSession();
		System.out.println("QuestionnaireHibernateDAO");
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
	 * @param q
	 * @return
	 */
	public boolean supprimer(Questionnaire q) {
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
	 * @return la liste des questionnaires
	 */
	public ArrayList<Questionnaire> listeQuestionnaires() {
		return null;
	}
}
