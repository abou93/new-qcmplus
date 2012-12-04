/**
 * 
 */
package dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.QuestionDAO;

import utils.HibernateUtil;

import beans.Question;
import beans.Questionnaire;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class QuestionHibernateDAO implements QuestionDAO {
	/**
	 * @param q
	 * @return id de la question créée
	 */
	public long creer(Question q) {
		return 0;
	}

	/**
	 * @param id
	 * @return La question
	 */
	public Question trouverQuestion(long id) {
		return null;
	}
	

	/**
	 * @param q
	 * @return
	 */
	public boolean modifier(Question q) {
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
	public boolean supprimer(Question q) {
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
	 * @return la liste des questions
	 */
	public ArrayList<Question> listerQuestionsQuestionnaire(long idQuestionnaire) {
		Session session = HibernateUtil.getSession();
		try {
			Query q = session
					.createQuery("FROM Question AS question WHERE question.estSupprime=:suppr and question.id_questionnaire=:id");
			q.setBoolean("suppr", false);
			q.setLong("id", idQuestionnaire);
			ArrayList<Question> maListeQuestions = (ArrayList<Question>) q.list();
			return maListeQuestions;
		} catch (RuntimeException e) {
			return null;
		} finally {
			session.close();
		}
	}
}
