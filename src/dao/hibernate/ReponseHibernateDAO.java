/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;

import beans.Question;
import beans.Reponse;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class ReponseHibernateDAO {
	/**
	 * @param r
	 * @return id de la reponse créée
	 */
	public long creer(Reponse r){
		return 0;}

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
	 * @return la liste des reponses à une question
	 */
	public ArrayList<Reponse> listeReponses(Question q) {
		return null;
	}
}
