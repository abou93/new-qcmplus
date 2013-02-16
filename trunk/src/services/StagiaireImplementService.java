/**
 * 
 */
package services;

import java.util.List;

import beans.Stagiaire;
import dao.StagiaireDAO;
import dao.hibernate.StagiaireHibernateDAO;

/**
 * @author Stephane Sikora & Frederic Aubry
 * 
 */
public class StagiaireImplementService implements StagiaireService {

	protected static final long MODIFICATION_OK = 1;
	protected final static long ERREUR_UTILISATEUR_EXISTANT = 0;
	protected static final long ERREUR_UTILISATEUR_NULL = -1;
	protected static final long ERREUR_UTILISATEUR_INCOMPLET = -2;
	protected static final long MODIFICATION_BDD_PB = -3;
	protected static final long UTILISATEUR_SANS_ID = -4;

	private StagiaireDAO maDAO;

	/**
	 * @param maDAO
	 */
	public StagiaireImplementService() {
		this.maDAO = new StagiaireHibernateDAO();
	}

	@Override
	public long creer(Stagiaire s) {
		// l'utilisateur ne peut pas �tre null
		if (s == null)
			return ERREUR_UTILISATEUR_NULL;
		// les attributs ne peuvent pas �tre vides
		if ("".equals(s.getNom()) || "".equals(s.getMotDePasse())
				|| "".equals(((Stagiaire) s).getSociete())
				|| "".equals(((Stagiaire) s).getPrenom()))
			return ERREUR_UTILISATEUR_INCOMPLET;
		// on verifie qu'un tel stagaire n'existe pas encore
		if (this.maDAO.trouver(s.getNom().toLowerCase().trim(), s
				.getMotDePasse().toLowerCase().trim()) != null) {
			return ERREUR_UTILISATEUR_EXISTANT;
		}
		// si tout ok, on cree le stagaire en base
		return this.maDAO.creer(s);
	}

	@Override
	public Stagiaire trouverParNomEtMdp(String nom, String mdp) {
		// avec insensibilit� � la casse et suppression des espaces avant et
		// apr�s
		Stagiaire s = this.maDAO.trouver(nom.toLowerCase().trim(), mdp
				.toLowerCase().trim());
		// sauf supprim�s logiquement
		if (s == null || s.isEstSupprime()) {
			s = null;
		}
		// sinon rien
		return s;
	}

	@Override
	public Stagiaire trouverParId(Long id) {
		return this.maDAO.trouver(id);
	}
	
	@Override
	public long modifier(Stagiaire s) {
		// l'utilisateur ne peut pas �tre null
		if (s == null)
			return ERREUR_UTILISATEUR_NULL;
		// les attributs ne peuvent pas �tre vides
		if (s.getId() <= 0 || "".equals(s.getNom())
				|| "".equals(s.getMotDePasse()) || "".equals(((Stagiaire) s).getSociete())
				|| "".equals(((Stagiaire) s).getPrenom()))
			return ERREUR_UTILISATEUR_INCOMPLET;
		//la stagiaire n'existe pas en base
		if (this.maDAO.trouver(s.getId()) == null) {
			return ERREUR_UTILISATEUR_EXISTANT;
		}		
		// si tout ok on effectue la modification
		return this.maDAO.modifier(s) ? MODIFICATION_OK : MODIFICATION_BDD_PB;
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
		return (maDAO.supprimer(id)) ? MODIFICATION_OK : MODIFICATION_BDD_PB;
	}
	
	@Override
	public List<Stagiaire> liste() {
		return this.maDAO.liste();
	}


}
