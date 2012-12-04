/**
 * 
 */
package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import beans.Question;


/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface QuestionService {
	public long creer(Question q);
	public ArrayList<Question> listerQuestions(long idQuestionnaire);
}
