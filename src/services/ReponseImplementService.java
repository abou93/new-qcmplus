/**
 * 
 */
package services;

import java.util.List;

import beans.Question;
import beans.Reponse;
import dao.ReponseDAO;
import dao.hibernate.ReponseHibernateDAO;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class ReponseImplementService implements ReponseService {

	ReponseDAO maDAO;	
	
	/**
	 * @param maDAO
	 */
	public ReponseImplementService() {
		this.maDAO = new ReponseHibernateDAO();
	}

	@Override
	public long creer(Reponse r) {
		return this.maDAO.creer(r);
	}

	@Override
	public boolean modifier(Reponse r) {
		return this.maDAO.modifier(r);
		
	}

	@Override
	public List<Reponse> listeReponses(Question q) {
		return this.maDAO.listeReponses(q);
	}
	

}
