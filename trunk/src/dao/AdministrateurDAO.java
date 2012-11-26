/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Administrateur;
import beans.Stagiaire;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface AdministrateurDAO extends UtilisateurDAO {

	/**
	 * @return la liste des stagiaires
	 */
	public ArrayList<Administrateur> listeAdministrateurs();
}
