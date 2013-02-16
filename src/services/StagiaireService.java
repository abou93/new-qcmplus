/**
 * 
 */
package services;

import java.util.List;

import beans.Stagiaire;

/**
 * @author Stephane Sikora & Frederic Aubry
 * 
 */
public interface StagiaireService {
	
	public long creer(Stagiaire s);
	
	public Stagiaire trouverParNomEtMdp(String nom, String mdp);
	
	public Stagiaire trouverParId(Long id);

	public long modifier(Stagiaire s);

	public long supprimer(Stagiaire s);

	public long supprimer(long id);

	public List<Stagiaire> liste();
}
