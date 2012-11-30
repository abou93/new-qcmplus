/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Resultat;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public interface ResultatDAO {
	/**
	 * @param r
	 * @return id du r�sultat cr��
	 */
	public long creer(Resultat r);

	/**
	 * @param id
	 * @return Le r�sultat
	 */
	public Resultat trouverResultat(long id);

	/**
	 * @param r
	 * @return true si modification ok
	 */
	public boolean modifier(Resultat r);

	/**
	 * @param id
	 * @return true si modification ok
	 */
	public boolean modifier(long id);

	/**
	 * @param r
	 * @return true si suppression ok
	 */
	public boolean supprimer(Resultat r);

	/**
	 * @param id
	 * @return true si suppression ok
	 */
	public boolean supprimer(long id);

	/**
	 * @return la liste des r�sultats
	 */
	public ArrayList<Resultat> listeResultats();

}
