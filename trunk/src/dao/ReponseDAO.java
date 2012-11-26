/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Question;
import beans.Reponse;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface ReponseDAO {
	/**
	 * @param r
	 * @return id de la reponse cr��e
	 */
	public long creer(Reponse r);

	/**
	 * @param id
	 * @return La reponse
	 */
	public Reponse trouverReponse(long id);
	

	/**
	 * @param r
	 * @return
	 */
	public boolean modifier(Reponse r);
	
	/**
	 * @param id
	 * @return
	 */
	public boolean modifier(long id);
	
	/**
	 * @param q
	 * @return
	 */
	public boolean supprimer(Reponse r);
	
	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id);
	
	/**
	 * @return la liste des reponses
	 */
	public ArrayList<Reponse> listeReponses();
	
	/**
	 * @return la liste des reponses � une question
	 */
	public ArrayList<Reponse> listeReponses(Question q);
}
