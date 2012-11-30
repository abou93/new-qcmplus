/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Parcours;

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
	public Parcours trouverParcours(long id);
	

	/**
	 * @param p
	 * @return true si modif ok
	 */
	public boolean modifier(Parcours p);
	
	/**
	 * @param id
	 * @return true si modif ok
	 */
	public boolean modifier(long id);
	
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
	 * @return la liste des parcours
	 */
	public ArrayList<Parcours> listeParcours();

}
