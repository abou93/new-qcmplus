/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;

import beans.Resultat;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class ResultatHibernateDAO {
	/**
	 * @param r
	 * @return id du r�sultat cr��
	 */
	public long creer(Resultat r){
		return 0;}

	/**
	 * @param id
	 * @return Le r�sultat
	 */
	public Resultat trouverResultat(long id){
		return null;}

	/**
	 * @param r
	 * @return true si modification ok
	 */
	public boolean modifier(Resultat r){
		return false;}

	/**
	 * @param id
	 * @return true si modification ok
	 */
	public boolean modifier(long id){
		return false;}

	/**
	 * @param r
	 * @return true si suppression ok
	 */
	public boolean supprimer(Resultat r){
		return false;}

	/**
	 * @param id
	 * @return true si suppression ok
	 */
	public boolean supprimer(long id){
		return false;}

	/**
	 * @return la liste des r�sultats
	 */
	public ArrayList<Resultat> listeResultats(){
		return null;}

}
