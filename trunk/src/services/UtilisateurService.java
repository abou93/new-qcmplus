/**
 * 
 */
package services;

import beans.Utilisateur;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface UtilisateurService {
	public Utilisateur trouverUtilisateur(String nom, String mdp);
	public long creer(Utilisateur u);
}
