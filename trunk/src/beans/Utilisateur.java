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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
@Entity
@Table(name="utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Utilisateur implements Serializable {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	/**
	 * 
	 */
	@Column(name = "NOM", nullable=false, length=50)
	private String nom;
	
	/**
	 * 
	 */
	@Column(name = "MDP", nullable=false, length=50)
	private String motDePasse;
	
	/**
	 * 
	 */
	public Utilisateur() {
		super();
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	

	
}
