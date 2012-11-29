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
	public long creer(Utilisateur u);
	public long modifier(Utilisateur u);
	public long supprimer(Utilisateur u);
	public long supprimer(long id);
	
	
}
