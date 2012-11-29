/**
 * 
 */
package services;

import beans.Stagiaire;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface StagiaireService extends UtilisateurService {
	public long creer(Stagiaire u);
}
