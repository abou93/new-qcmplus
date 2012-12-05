/**
 * 
 */
package services;

import java.util.ArrayList;
import java.util.List;

import dao.QuestionDAO;
import dao.hibernate.QuestionHibernateDAO;

import beans.Question;


/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class QuestionImplementService implements QuestionService{
	
	QuestionDAO maDAO;
	
	/**
	 * @param maDAO
	 */
	public QuestionImplementService() {
		this.maDAO = new QuestionHibernateDAO();
	}

	public long creer(Question q){
		return 0;
	}
	
	public ArrayList<Question> listerQuestions(long idQuestionnaire){
		return this.maDAO.listerQuestionsQuestionnaire(idQuestionnaire);
	}
}
