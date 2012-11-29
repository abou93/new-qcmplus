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
		//avec insensibilité à la casse et suppression des espaces avant et après
		return this.maDAO.trouverParNomEtMdp(nom.toLowerCase().trim(), mdp.toLowerCase().trim());
	}

	@Override
	public long creer(Utilisateur u) {
		//l'utilisateur ne peut pas être null
		if (u == null)return ERREUR_UTILISATEUR_VIDE;
		//les attributs ne peuvent pas être vides
		if (u.getNom() == null || u.getMotDePasse() == null)return ERREUR_UTILISATEUR_INCOMPLET;
		// on ne crée un utilisateur que s'il n'existe pas déjà
		if (this.maDAO.trouverParNomEtMdp(u.getNom().toLowerCase().trim(), u.getMotDePasse().toLowerCase().trim()) == null) {
			return this.maDAO.creer(u);
		}
		return ERREUR_UTILISATEUR_EXISTANT; //il faudrait mettre en place des constantes
	}

}
