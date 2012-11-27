/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;

import beans.Questionnaire;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class QuestionnaireHibernateDAO {

	/**
	 * @param q
	 * @return id du questionnaire créé
	 */
	public long creer(Questionnaire q) {
		return 0;
	}

	/**
	 * @param id
	 * @return Le questionnaire
	 */
	public Questionnaire trouverQuestionnaire(long id) {
		return null;
	}
	

	/**
	 * @param q
	 * @return
	 */
	public boolean modifier(Questionnaire q) {
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
	public boolean supprimer(Questionnaire q) {
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
	 * @return la liste des questionnaires
	 */
	public ArrayList<Questionnaire> listeQuestionnaires() {
		return null;
	}
}
