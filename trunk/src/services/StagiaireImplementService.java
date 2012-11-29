/**
 * 
 */
package services;

import beans.Stagiaire;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 * 
 */
public class StagiaireImplementService extends UtilisateurImplementService
		implements StagiaireService {

	@Override
	public long creer(Stagiaire s) {
		// l'utilisateur ne peut pas �tre null
		if (s == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas �tre vides
		if (s.getSociete() == null || s.getPrenom() == null)
			return ERREUR_UTILISATEUR_INCOMPLET;
		// si tout ok on renvoie vers le parent pour finaliser
		return super.creer(s);
	}

	@Override
	public long modifier(Stagiaire s) {
		// l'utilisateur ne peut pas �tre null
		if (s == null)
			return ERREUR_UTILISATEUR_VIDE;
		// les attributs ne peuvent pas �tre vides
		if (s.getSociete() == null || s.getPrenom() == null)
			return ERREUR_UTILISATEUR_INCOMPLET;
		// si tout ok on renvoie vers le parent pour finaliser
		return super.modifier(s);
	}

}
