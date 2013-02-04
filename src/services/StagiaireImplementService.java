/**
 * 
 */
package services;

import java.util.List;

import beans.Stagiaire;
import beans.Utilisateur;
import dao.StagiaireDAO;
import dao.hibernate.StagiaireHibernateDAO;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class StagiaireImplementService implements StagiaireService {

	private StagiaireDAO maDAO;
	protected static final long MODIFICATION_OK = 1;
	protected final static long ERREUR_UTILISATEUR_EXISTANT = 0;
	protected static final long ERREUR_UTILISATEUR_VIDE = -1;
	protected static final long ERREUR_UTILISATEUR_INCOMPLET = -2;
	protected static final long MODIFICATION_BDD_PB = -3;
	protected static final long UTILISATEUR_SANS_ID = -4;
	protected static final long ERREUR_UTILISATEUR_NULL = -5;

	/**
	 * @param maDAO
	 */
	public StagiaireImplementService() {
		this.maDAO = new StagiaireHibernateDAO();
	}

	@Override
	public Stagiaire trouverParNomEtMdp(String nom, String mdp) {
		// avec insensibilit� � la casse et suppression des espaces avant et
		// apr�s
		Stagiaire u = this.maDAO.trouver(nom.toLowerCase().trim(), mdp
				.toLowerCase().trim());
		// sauf supprim�s logiquement
		if (u == null || u.isEstSupprime()) {
			u = null;
		}
		// sinon rien
		return u;
	}

	@Override
	public Stagiaire trouverParId(long id) {
		return this.maDAO.trouver(id);
	}



	@Override
	public long creer(Stagiaire s) {
		// l'utilisateur ne peut pas �tre null
		if (s == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas �tre vides
		if ("".equals(s.getNom()) || "".equals(s.getMotDePasse())
				|| "".equals(((Stagiaire) s).getSociete())
				|| "".equals(((Stagiaire) s).getPrenom()))
			return ERREUR_UTILISATEUR_INCOMPLET;
		// on ne cr�e un utilisateur que s'il n'existe pas d�j�
		if (this.maDAO.trouver(s.getNom().toLowerCase().trim(), s
				.getMotDePasse().toLowerCase().trim()) == null) {
			return this.maDAO.creer(s);
		}
		return ERREUR_UTILISATEUR_EXISTANT; // il faudrait mettre en place des
											// constantes
	}

	@Override
	public long modifier(Stagiaire s) {
		// l'utilisateur ne peut pas �tre null
		if (s == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas �tre vides
		if ("".equals(((Stagiaire) s).getSociete())
				|| "".equals(((Stagiaire) s).getPrenom()) || s.getId() <= 0
				|| "".equals(s.getNom()) || "".equals(s.getMotDePasse()))
			return ERREUR_UTILISATEUR_INCOMPLET;
		// le couple nom/mdp ne peut d�j� exister en base
		if (this.maDAO.trouver(s.getId()) == null) {
			return ERREUR_UTILISATEUR_EXISTANT;
		}
		// tout est ok, on peut faire la modification
		if (maDAO.modifier(s))
			return MODIFICATION_OK;
		// Il y a eu un probl�me lmors de l'op�ration en bdd
		return MODIFICATION_BDD_PB;
	}

	@Override
	public long supprimer(Stagiaire s) {
		// l'utilisateur a bien un id
		if (s.getId() >= 0) {
			return supprimer(s.getId());
		}
		// Il y a eu un probl�me lmors de l'op�ration en bdd
		return UTILISATEUR_SANS_ID;
	}

	@Override
	public long supprimer(long id) {
		if (maDAO.supprimer(id))
			return MODIFICATION_OK;
		// Il y a eu un probl�me lmors de l'op�ration en bdd
		return MODIFICATION_BDD_PB;
	}

	@Override
	public List<Stagiaire> liste() {
		return this.maDAO.liste();
	}

}
