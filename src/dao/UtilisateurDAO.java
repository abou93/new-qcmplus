/**
 * 
 */
package dao;

import java.util.List;

import beans.Utilisateur;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public interface UtilisateurDAO {

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

}
