/**
 * 
 */
package services;

import java.util.List;

import beans.Stagiaire;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface StagiaireService extends UtilisateurService {
	public long creer(Stagiaire u);
	public long modifier(Stagiaire u);	
}
