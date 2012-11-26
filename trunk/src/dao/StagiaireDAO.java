/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Stagiaire;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface StagiaireDAO extends UtilisateurDAO {
	
	/**
	 * @return la liste des stagiaires
	 */
	public ArrayList<Stagiaire> listeStagiaires();

}
