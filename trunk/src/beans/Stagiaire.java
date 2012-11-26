/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy="stagiaire")
	private ArrayList<Question> listeParcours;
	
		
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

	/**
	 * @return the listeParcours
	 */
	public ArrayList<Question> getListeParcours() {
		return listeParcours;
	}

	/**
	 * @param listeParcours the listeParcours to set
	 */
	public void setListeParcours(ArrayList<Question> listeParcours) {
		this.listeParcours = listeParcours;
	}
	
	
}
