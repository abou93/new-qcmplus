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
	public Utilisateur trouverParNomEtMdp(String nom, String mdp);
	public Utilisateur trouverParId(Long id);	
	
}
