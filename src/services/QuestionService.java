/**
 * 
 */
package services;

import java.util.List;

import beans.Question;


/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface QuestionService {
	public long creer(Question q);
	public boolean modifier(Question q);
	public List<Question> listerQuestions(long idQuestionnaire);
}
