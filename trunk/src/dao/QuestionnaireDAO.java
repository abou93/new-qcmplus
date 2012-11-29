/**
 * 
 */
package dao;

import java.util.ArrayList;

import beans.Questionnaire;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface QuestionnaireDAO {

	/**
	 * @param q
	 * @return id du questionnaire créé
	 */
	public long creer(Questionnaire q);

	/**
	 * @param id
	 * @return Le questionnaire
	 */
	public Questionnaire trouverQuestionnaire(long id);
	

	/**
	 * @param q
	 * @return
	 */
	public boolean modifier(Questionnaire q);
	

	
	/**
	 * @param q
	 * @return
	 */
	public boolean supprimer(Questionnaire q);
	
	/**
	 * @param id
	 * @return
	 */
	public boolean supprimer(long id);
	
	/**
	 * @return la liste des questionnaires
	 */
	public ArrayList<Questionnaire> listeQuestionnaires();
}
