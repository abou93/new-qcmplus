/**
 * 
 */
package services;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import utils.HibernateUtil;
import dao.QuestionnaireDAO;
import dao.hibernate.QuestionnaireHibernateDAO;
import beans.Questionnaire;
import beans.Utilisateur;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class QuestionnaireImplementService implements QuestionnaireService {

	/* (non-Javadoc)
	 * @see services.QuestionnaireService#creer(beans.Questionnaire)
	 */
	
	private static final long ERREUR_CHAMPS_INCOMPLETS = 0;
	
	QuestionnaireDAO maDAO;


	/**
	 * @param maDAO
	 */
	public QuestionnaireImplementService() {
		this.maDAO = new QuestionnaireHibernateDAO();
	}

	public long creer(Questionnaire q) {
		if (q != null){
			if ("".equals(q.getNom())||"".equals(q.getDescription())){
				return ERREUR_CHAMPS_INCOMPLETS;
			}else{
				System.out.println("testActionMan");
				return this.maDAO.creer(q);
			}
		}else{
			return 0;
		}
	}

	public Questionnaire trouverQuestionnaire(long id){
		return this.maDAO.trouverQuestionnaire(id);
	}

	public boolean modifier(Questionnaire q){
		if ((q.getNom()==null && q.getNom()=="")||(q.getDescription()==null && q.getDescription()=="")){
			return false;
		}else{
			return this.maDAO.modifier(q);
		}
	}
	
	public List<Questionnaire> listerQuestionnaires(){
		return this.maDAO.listerQuestionnaires();
	}
	
	public boolean supprimer(Questionnaire q){
		return this.maDAO.supprimer(q.getId());
	}
	
}
