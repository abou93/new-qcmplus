/**
 * 
 */
package services;

import beans.Utilisateur;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface UtilisateurService {
	public Utilisateur trouverUtilisateur(String nom, String mdp);
	public long creer(Utilisateur u);
}
