/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Administrateur;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface AdministrateurDAO {

	/**
	 * @return la liste des stagiaires
	 */
	public ArrayList<Administrateur> listeAdministrateurs();
}
