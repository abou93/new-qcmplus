/**
 * 
 */
package services;

import java.util.List;

import beans.Question;
import beans.Reponse;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface ReponseService {
	public long creer(Reponse r);

	public boolean modifier(Reponse r);
	
	public List<Reponse> listeReponses(Question q);
	
}
