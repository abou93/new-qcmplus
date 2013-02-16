/**
 * 
 */
package dao;

import java.util.List;

import beans.Stagiaire;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface StagiaireDAO {
	
	/**
	 * @param u
	 * @return id du stagiaire cree
	 */
	public long creer(Stagiaire s);
	
	/**
	 * @param id
	 * @return Le stagiaire
	 */
	public Stagiaire trouver(long id);
	
	/**
	 * @param nom
	 * @param mdp
	 * @return Le stagiaire
	 */
	public Stagiaire trouver(String nom, String mdp);
	
	/**
	 * @param u
	 * @return
	 */
	public boolean modifier(Stagiaire s);
	
	/**
	 * @param u
	 * @return
	 */
	public boolean supprimer(Stagiaire s);
	
	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id);
	
	/**
	 * @return la liste des stagiaires
	 */
	public List<Stagiaire> liste();

}
