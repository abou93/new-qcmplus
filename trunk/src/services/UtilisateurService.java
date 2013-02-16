/**
 * 
 */
package services;

import beans.Utilisateur;

/**
 * @author Stephane Sikora & Frederic Aubry
 *
 */
public interface UtilisateurService {
	public Utilisateur trouverParNomEtMdp(String nom, String mdp);
	public Utilisateur trouverParId(Long id);	
}
