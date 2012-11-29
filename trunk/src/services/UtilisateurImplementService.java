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
	UtilisateurDAO maDAO;
	protected final static long ERREUR_UTILISATEUR_EXISTANT = 0;
	protected static final long ERREUR_UTILISATEUR_VIDE = -1;
	protected static final long ERREUR_UTILISATEUR_INCOMPLET = -2;

	/**
	 * @param maDAO
	 */
	public UtilisateurImplementService() {
		this.maDAO = new UtilisateurHibernateDAO();
	}

	@Override
	public Utilisateur trouverParNomEtMdp(String nom, String mdp) {
		//avec insensibilit� � la casse et suppression des espaces avant et apr�s
		return this.maDAO.trouverParNomEtMdp(nom.toLowerCase().trim(), mdp.toLowerCase().trim());
	}

	@Override
	public long creer(Utilisateur u) {
		//l'utilisateur ne peut pas �tre null
		if (u == null)return ERREUR_UTILISATEUR_VIDE;
		//les attributs ne peuvent pas �tre vides
		if (u.getNom() == null || u.getMotDePasse() == null)return ERREUR_UTILISATEUR_INCOMPLET;
		// on ne cr�e un utilisateur que s'il n'existe pas d�j�
		if (this.maDAO.trouverParNomEtMdp(u.getNom().toLowerCase().trim(), u.getMotDePasse().toLowerCase().trim()) == null) {
			return this.maDAO.creer(u);
		}
		return ERREUR_UTILISATEUR_EXISTANT; //il faudrait mettre en place des constantes
	}

}
