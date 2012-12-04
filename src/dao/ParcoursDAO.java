/**
 * 
 */
package dao;

import java.util.List;

import beans.Parcours;
import beans.Questionnaire;
import beans.Stagiaire;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface ParcoursDAO {
	/**
	 * @param p
	 * @return id du parcours créé
	 */
	public long creer(Parcours p);

	/**
	 * @param id
	 * @return Le parcours
	 */
	public Parcours trouver(long id);
	

	/**
	 * @param p
	 * @return true si modif ok
	 */
	public boolean modifier(Parcours p);
	
	/**
	 * @param p
	 * @return true si suppression ok
	 */
	public boolean supprimer(Parcours p);
	
	/**
	 * @param id
	 * @return true si suppression ok
	 */
	public boolean supprimer(long id);
	

	/**
	 * @param q
	 * @param s
	 * @return
	 */
	public List<Parcours> liste(Questionnaire q, Stagiaire s);

}
