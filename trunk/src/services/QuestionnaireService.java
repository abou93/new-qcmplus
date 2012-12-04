/**
 * 
 */
package services;

import java.util.List;
import java.util.Set;

import beans.Questionnaire;;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface QuestionnaireService {
	public long creer(Questionnaire q);
	public Questionnaire trouverQuestionnaire(long id);
	public boolean modifier(Questionnaire q);
	public List<Questionnaire> listerQuestionnaires();
	public boolean supprimer(Questionnaire q);
}
