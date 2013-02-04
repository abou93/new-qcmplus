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
	 * @param s
	 * @return id du stagiaire crée
	 */
	public long creer(Stagiaire s);

	/**
	 * @param id
	 * @return L'utilisateur
	 */
	public Stagiaire trouver(long id);
	/**
	 * @param nom
	 * @param mdp
	 * @return L'utilisateur
	 */
	public Stagiaire trouver(String nom, String mdp);

	/**
	 * @param s
	 * @return
	 */
	public boolean modifier(Stagiaire s);
	
	/**
	 * @param s
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
