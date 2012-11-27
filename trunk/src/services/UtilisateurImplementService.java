/**
 * 
 */
package services;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import dao.hibernate.UtilisateurHibernateDAO;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class UtilisateurImplementService implements UtilisateurService {
	UtilisateurDAO maDAO;

	/**
	 * @param maDAO
	 */
	public UtilisateurImplementService() {
		this.maDAO = new UtilisateurHibernateDAO();
	}

	@Override
	public Utilisateur trouverUtilisateur(String nom, String mdp) {

		return this.maDAO.trouverUtilisateur(nom, mdp);
	}

}
