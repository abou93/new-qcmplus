/**
 * 
 */
package dao;

import java.util.List;

import beans.Question;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface QuestionDAO {
	/**
	 * @param q
	 * @return id de la question cr��e
	 */
	public long creer(Question q);

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
	public List<Question> listerQuestionsQuestionnaire(long idQuestionnaire);

	public Question trouver(long qid);
}
