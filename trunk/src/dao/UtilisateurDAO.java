/**
 * 
 */
package dao;

import beans.Utilisateur;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public interface UtilisateurDAO {

	/**
	 * @param u
	 * @return id de l'utilisateur cr��
	 */
	public long creer(Utilisateur u);

	/**
	 * @param id
	 * @return L'utilisateur
	 */
	public Utilisateur trouver(long id);
	/**
	 * @param nom
	 * @param mdp
	 * @return L'utilisateur
	 */
	public Utilisateur trouver(String nom, String mdp);

	/**
	 * @param u
	 * @return
	 */
	public boolean modifier(Utilisateur u);
	
	/**
	 * @param u
	 * @return
	 */
	public boolean supprimer(Utilisateur u);
	
	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id);
	
	
	
	
	
	
	

}
