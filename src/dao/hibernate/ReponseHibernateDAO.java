/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ReponseDAO;

import utils.HibernateUtil;

import beans.Question;
import beans.Reponse;

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
	public long creer(Reponse r){
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
	public Reponse trouverReponse(long id){
		return null;}
	

	/**
	 * @param r
	 * @return
	 */
	public boolean modifier(Reponse r){
		return false;}
	
	/**
	 * @param id
	 * @return
	 */
	public boolean modifier(long id){
		return false;}
	
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
	public ArrayList<Reponse> listeReponses(Question q) {
		return null;
	}
}
