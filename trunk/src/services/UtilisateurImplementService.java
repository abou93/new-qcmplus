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
	protected UtilisateurDAO maDAO;
	protected static final long MODIFICATION_OK = 1;
	protected final static long ERREUR_UTILISATEUR_EXISTANT = 0;
	protected static final long ERREUR_UTILISATEUR_VIDE = -1;
	protected static final long ERREUR_UTILISATEUR_INCOMPLET = -2;
	protected static final long MODIFICATION_BDD_PB = -3;
	protected static final long UTILISATEUR_SANS_ID = -4;

	/**
	 * @param maDAO
	 */
	public UtilisateurImplementService() {
		this.maDAO = new UtilisateurHibernateDAO();
	}

	@Override
	public Utilisateur trouverParNomEtMdp(String nom, String mdp) {
		// avec insensibilité à la casse et suppression des espaces avant et après
		Utilisateur u = this.maDAO.trouver(nom.toLowerCase().trim(), mdp.toLowerCase()
				.trim());
		//sauf supprimés logiquement
		if (!u.isEstSupprime()) {
		return this.maDAO.trouver(nom.toLowerCase().trim(), mdp.toLowerCase()
				.trim());} 
		//sinon rien
		return null;
	}

	@Override
	public Utilisateur trouverParId(Long id) {
		return this.maDAO.trouver(id);
	}

	@Override
	public long creer(Utilisateur u) {
		// l'utilisateur ne peut pas être null
		if (u == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas être vides
		if (u.getNom() == null || u.getMotDePasse() == null)
			return ERREUR_UTILISATEUR_INCOMPLET;
		// on ne crée un utilisateur que s'il n'existe pas déjà
		if (this.maDAO.trouver(u.getNom().toLowerCase().trim(), u
				.getMotDePasse().toLowerCase().trim()) == null) {
			return this.maDAO.creer(u);
		}
		return ERREUR_UTILISATEUR_EXISTANT; // il faudrait mettre en place des
											// constantes
	}

	@Override
	public long modifier(Utilisateur u) {
		// les attributs ne peuvent pas être vides
		if (u.getId() <= 0 || u.getNom() == null || u.getMotDePasse() == null)
			return ERREUR_UTILISATEUR_INCOMPLET;
		// le couple nom/mdp ne peut déjà exister en base
		if (this.maDAO.trouver(u.getNom().toLowerCase().trim(), u
				.getMotDePasse().toLowerCase().trim()) == null) {
			return ERREUR_UTILISATEUR_EXISTANT;
		}
		// tout est ok, on peut faire la modification
		if (maDAO.modifier(u))
			return MODIFICATION_OK;
		// Il y a eu un problème lmors de l'opération en bdd
		return MODIFICATION_BDD_PB;
	}

	@Override
	public long supprimer(Utilisateur u) {
		//l'utilisateur a bien un id
		if (u.getId() >= 0) {
			return supprimer(u.getId());
		}
		// Il y a eu un problème lmors de l'opération en bdd
		return UTILISATEUR_SANS_ID;
	}

	@Override
	public long supprimer(long id) {
		if (maDAO.supprimer(id))
			return MODIFICATION_OK;
		// Il y a eu un problème lmors de l'opération en bdd
		return MODIFICATION_BDD_PB;
	}

}
