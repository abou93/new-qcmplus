/**
 * 
 */
package services;

import beans.Questionnaire;;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface QuestionnaireService {
	public long creer(Questionnaire q);
	public Questionnaire trouverQuestionnaire(long id);
	public boolean modifier(Questionnaire q);
}
