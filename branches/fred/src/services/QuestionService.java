/**
 * 
 */
package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import beans.Question;


/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface QuestionService {
	public long creer(Question q);
	public ArrayList<Question> listerQuestions(long idQuestionnaire);
}
