/**
 * 
 */
package services;

import java.util.List;

import beans.Parcours;
import beans.Questionnaire;
import beans.Stagiaire;
import dao.ParcoursDAO;
import dao.hibernate.ParcoursHibernateDAO;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class ParcoursImplementService implements ParcoursService{

	private ParcoursDAO maDAO;
	
	/**
	 * 
	 */
	public ParcoursImplementService() {
		super();
		this.maDAO = new ParcoursHibernateDAO();
	}

	@Override
	public List<Parcours> liste(Questionnaire qr, Stagiaire s) {
		return this.maDAO.liste(qr, s);
	}

}
