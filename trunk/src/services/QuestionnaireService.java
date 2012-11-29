/**
 * 
 */
package services;

import beans.Questionnaire;;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface QuestionnaireService {
	public long creer(Questionnaire q);
	public Questionnaire trouverQuestionnaire(long id);
	public boolean modifier(Questionnaire q);
}
