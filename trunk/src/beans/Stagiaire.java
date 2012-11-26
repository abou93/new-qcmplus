/**
 * 
 */
package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
@Entity
@Table(name="stagiaire")
@PrimaryKeyJoinColumn(name ="ID_STAGIAIRE")
public class Stagiaire extends Utilisateur implements Serializable{
	
	/**
	 * 
	 */
	@Column(name = "PRENOM", nullable=false, length=50)
	private String prenom;
	
	/**
	 * 
	 */
	@Column(name = "SOCIETE", nullable=false)
	private String societe;
	
		
	/**
	 * 
	 */
	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the societe
	 */
	public String getSociete() {
		return societe;
	}
	/**
	 * @param societe the societe to set
	 */
	public void setSociete(String societe) {
		this.societe = societe;
	}
	
	
}
