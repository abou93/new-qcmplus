/**
 * 
 */
package services;

import java.util.List;

import beans.Parcours;
import beans.Questionnaire;
import beans.Stagiaire;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
public interface ParcoursService {
	public List<Parcours> liste(Questionnaire qr, Stagiaire s);
}
