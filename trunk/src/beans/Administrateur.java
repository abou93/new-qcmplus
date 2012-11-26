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

	
}
