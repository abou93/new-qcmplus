/**
 * 
 */
package services;

import java.util.List;

import beans.Question;
import dao.QuestionDAO;
import dao.hibernate.QuestionHibernateDAO;


/**
 * @author St�phane Sikora & Fr�d�ric Aubry
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
		return this.maDAO.creer(q);
	}
	
	public List<Question> listerQuestions(long idQuestionnaire){
		return this.maDAO.listerQuestionsQuestionnaire(idQuestionnaire);
	}

	@Override
	public boolean modifier(Question q) {
		return this.maDAO.modifier(q);
	}
}
