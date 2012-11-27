/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;

import beans.Resultat;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class ResultatHibernateDAO {
	/**
	 * @param r
	 * @return id du résultat créé
	 */
	public long creer(Resultat r){
		return 0;}

	/**
	 * @param id
	 * @return Le résultat
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
	 * @return la liste des résultats
	 */
	public ArrayList<Resultat> listeResultats(){
		return null;}

}
