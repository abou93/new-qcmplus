/**
 * 
 */
package services;

import java.util.List;

import beans.Stagiaire;
import beans.Utilisateur;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class StagiaireImplementService extends UtilisateurImplementService
		implements StagiaireService {

	@Override
	public long creer(Stagiaire s) {
		// l'utilisateur ne peut pas être null
		if (s == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas être vides
		if ("".equals(s.getSociete()) || "".equals(s.getPrenom()))
			return ERREUR_UTILISATEUR_INCOMPLET;
		// si tout ok on renvoie vers le parent pour finaliser
		return super.creer(s);
	}

	@Override
	public long modifier(Stagiaire s) {
		// l'utilisateur ne peut pas être null
		if (s == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas être vides
		if ("".equals(s.getSociete()) || "".equals(s.getPrenom()))
			return ERREUR_UTILISATEUR_INCOMPLET;
		// si tout ok on renvoie vers le parent pour finaliser
		return super.modifier(s);
	}

	@Override
	public List<Utilisateur> liste() {
		return this.maDAO.liste();
	}

}
