/**
 * 
 */
package dao.hibernate;

import dao.UtilisateurDAO;
import beans.Utilisateur;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class UtilisateurHibernateDAO implements UtilisateurDAO {

	/**
	 * @param u
	 * @return id de l'utilisateur créé
	 */
	public long creer(Utilisateur u){
		return 0;
		
	}

	/**
	 * @param id
	 * @return L'utilisateur
	 */
	public Utilisateur trouverUtilisateur(long id){
		return null;}
	/**
	 * @param nom
	 * @param mdp
	 * @return L'utilisateur
	 */
	public Utilisateur trouverUtilisateur(String nom, String mdp){
		return null;}

	/**
	 * @param u
	 * @return
	 */
	public boolean modifier(Utilisateur u){
		return false;}
	
	/**
	 * @param id
	 * @return
	 */
	public boolean modifier(long id){
		return false;}
	
	/**
	 * @param u
	 * @return
	 */
	public boolean supprimer(Utilisateur u){
		return false;}
	
	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id){
		return false;}
	
	
	
	
	
	
	

}
