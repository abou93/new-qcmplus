/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;

import beans.Question;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public class QuestionHibernateDAO {
	/**
	 * @param q
	 * @return id de la question cr��e
	 */
	public long creer(Question q) {
		return 0;
	}

	/**
	 * @param id
	 * @return La question
	 */
	public Question trouverQuestion(long id) {
		return null;
	}
	

	/**
	 * @param q
	 * @return
	 */
	public boolean modifier(Question q) {
		return false;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public boolean modifier(long id) {
		return false;
	}
	
	/**
	 * @param q
	 * @return
	 */
	public boolean supprimer(Question q) {
		return false;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id) {
		return false;
	}
	
	/**
	 * @return la liste des questions
	 */
	public ArrayList<Question> listeQuestions() {
		return null;
	}
}
