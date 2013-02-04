/**
 * 
 */
package services;

import java.util.List;

import beans.Stagiaire;


/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface StagiaireService {

	long creer(Stagiaire s);

	long modifier(Stagiaire s);

	long supprimer(Stagiaire s);

	long supprimer(long id);

	List<Stagiaire> liste();

	Stagiaire trouverParId(long sid);

	Stagiaire trouverParNomEtMdp(String nom, String mdp);
	
}
