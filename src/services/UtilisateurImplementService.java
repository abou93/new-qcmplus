/**
 * 
 */
package services;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import dao.hibernate.UtilisateurHibernateDAO;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class UtilisateurImplementService implements UtilisateurService {
	private UtilisateurDAO maDAO;

	/**
	 * @param maDAO
	 */
	public UtilisateurImplementService() {
		this.maDAO = new UtilisateurHibernateDAO();
	}

	@Override
	public Utilisateur trouverParNomEtMdp(String nom, String mdp) {
		// avec insensibilit� � la casse et suppression des espaces avant et
		// apr�s
		Utilisateur u = this.maDAO.trouver(nom.toLowerCase().trim(), mdp
				.toLowerCase().trim());
		// sauf supprim�s logiquement
		if (u == null || u.isEstSupprime()) {
			u = null;
		}
		// sinon rien
		return u;
	}

	@Override
	public Utilisateur trouverParId(Long id) {
		return this.maDAO.trouver(id);
	}

}
