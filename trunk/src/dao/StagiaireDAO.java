/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Stagiaire;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface StagiaireDAO extends UtilisateurDAO {
	
	/**
	 * @return la liste des stagiaires
	 */
	public ArrayList<Stagiaire> listeStagiaires();

}
