/**
 * 
 */
package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
@Entity
@Table(name = "resultat")
public class Resultat implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "ID_PARCOURS")
	private Parcours parcours;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "ID_REPONSE")
	private Reponse reponse;
	
	/**
	 * 
	 */
	@Column(name = "EST_SUPPRIME", nullable=false, columnDefinition = "Boolean default false")
	private boolean estSupprime = false;
	

	/**
	 * 
	 */
	public Resultat() {
		super();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the parcours
	 */
	public Parcours getParcours() {
		return parcours;
	}

	/**
	 * @param parcours the parcours to set
	 */
	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}

	/**
	 * @return the reponse
	 */
	public Reponse getReponse() {
		return reponse;
	}

	/**
	 * @param reponse the reponse to set
	 */
	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

	/**
	 * @return the estSupprime
	 */
	public boolean isEstSupprime() {
		return estSupprime;
	}

	/**
	 * @param estSupprime the estSupprime to set
	 */
	public void setEstSupprime(boolean estSupprime) {
		this.estSupprime = estSupprime;
	}
	
	

}
