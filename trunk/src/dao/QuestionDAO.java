/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Question;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface QuestionDAO {
	/**
	 * @param q
	 * @return id de la question créée
	 */
	public long creer(Question q);

	/**
	 * @param id
	 * @return La question
	 */
	public Question trouverQuestion(long id);
	

	/**
	 * @param q
	 * @return
	 */
	public boolean modifier(Question q);
	
	/**
	 * @param id
	 * @return
	 */
	public boolean modifier(long id);
	
	/**
	 * @param q
	 * @return
	 */
	public boolean supprimer(Question q);
	
	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id);
	
	/**
	 * @return la liste des questions
	 */
	public ArrayList<Question> listeQuestions();
}
