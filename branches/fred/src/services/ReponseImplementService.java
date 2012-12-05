/**
 * 
 */
package services;

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
		super();
		this.maDAO = new ReponseHibernateDAO();
	}

	@Override
	public long creer(Reponse r) {
		return this.maDAO.creer(r);
	}
	

}
