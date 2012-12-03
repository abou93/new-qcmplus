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
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class StagiaireImplementService extends UtilisateurImplementService
		implements StagiaireService {
	
	private StagiaireDAO maDAO; 
	
	

	/**
	 * @param maDAO
	 */
	public StagiaireImplementService() {
		this.maDAO = new StagiaireHibernateDAO();
	}

	@Override
	public long creer(Utilisateur s) {
		// l'utilisateur ne peut pas être null
		if (s == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas être vides
		if ("".equals(((Stagiaire) s).getSociete()) || "".equals(((Stagiaire) s).getPrenom()))
			return ERREUR_UTILISATEUR_INCOMPLET;
		// si tout ok on renvoie vers le parent pour finaliser
		return super.creer(s);
	}

	@Override
	public long modifier(Utilisateur s) {
		// l'utilisateur ne peut pas être null
		if (s == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas être vides
		if ("".equals(((Stagiaire) s).getSociete()) || "".equals(((Stagiaire) s).getPrenom()))
			return ERREUR_UTILISATEUR_INCOMPLET;
		// si tout ok on renvoie vers le parent pour finaliser
		return super.modifier(s);
	}

	@Override
	public List<Utilisateur> liste() {
		return this.maDAO.liste();
	}

}
