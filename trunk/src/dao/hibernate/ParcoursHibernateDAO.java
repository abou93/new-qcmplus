/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;

import beans.Parcours;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public class ParcoursHibernateDAO {
	/**
	 * @param p
	 * @return id du parcours cr��
	 */
	public long creer(Parcours p) {
		return 0;
	}

	/**
	 * @param id
	 * @return Le parcours
	 */
	public Parcours trouverParcours(long id) {
		return null;
	}
	

	/**
	 * @param p
	 * @return true si modif ok
	 */
	public boolean modifier(Parcours p) {
		return false;
	}
	
	/**
	 * @param id
	 * @return true si modif ok
	 */
	public boolean modifier(long id) {
		return false;
	}
	
	/**
	 * @param p
	 * @return true si suppression ok
	 */
	public boolean supprimer(Parcours p) {
		return false;
	}
	
	/**
	 * @param id
	 * @return true si suppression ok
	 */
	public boolean supprimer(long id) {
		return false;
	}
	
	/**
	 * @return la liste des parcours
	 */
	public ArrayList<Parcours> listeParcours() {
		return null;
	}

}
