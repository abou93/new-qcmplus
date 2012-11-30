/**
 * 
 */
package services;

import java.util.List;

import beans.Utilisateur;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface UtilisateurService {
	public Utilisateur trouverParNomEtMdp(String nom, String mdp);
	public Utilisateur trouverParId(Long id);
	public long creer(Utilisateur u);
	public long modifier(Utilisateur u);
	public long supprimer(Utilisateur u);
	public long supprimer(long id);
	public List<Utilisateur> liste();
	
	
}
