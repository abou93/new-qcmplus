/**
 * 
 */
package beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
@Entity
@Table(name="administrateur")
@PrimaryKeyJoinColumn(name ="ID_ADMIN")
public class Administrateur extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	public Administrateur() {
		super();
	}

	public Administrateur(String nom, String mdp) {
		super(nom, mdp);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Administrateur []");
		return builder.toString();
	}	
	
	
}
