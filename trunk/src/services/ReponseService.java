/**
 * 
 */
package services;

import beans.Reponse;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public interface ReponseService {
	public long creer(Reponse r);

	public boolean modifier(Reponse next);
}
