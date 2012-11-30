/**
 * 
 */
package services;

import java.util.Set;

import beans.Stagiaire;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface StagiaireService extends UtilisateurService {
	public long creer(Stagiaire u);
	public long modifier(Stagiaire u);
	public Set<Stagiaire> liste();
	
}
