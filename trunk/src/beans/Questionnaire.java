/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
@Entity
@Table(name = "questionnaire")
public class Questionnaire implements Serializable{

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * 
	 */
	@Column(name = "NOM", nullable = false, length = 50)
	private String nom;

	/**
	 * 
	 */
	@Column(name = "DESCRIPTION", nullable = false, length = 500)
	private String description;

	/**
	 * 
	 */
	@OneToMany(mappedBy="questionnaire")
	private ArrayList<Question> listeQuestions;

	/**
	 * 
	 */
	public Questionnaire() {
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the listeQuestions
	 */
	public ArrayList<Question> getListeQuestions() {
		return listeQuestions;
	}

	/**
	 * @param listeQuestions
	 *            the listeQuestions to set
	 */
	public void setListeQuestions(ArrayList<Question> listeQuestions) {
		this.listeQuestions = listeQuestions;
	}

}
