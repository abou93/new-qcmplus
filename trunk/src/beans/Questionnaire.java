/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
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
	private Set<Question> listeQuestions;
	
	/**
	 * 
	 */
	@Column(name = "EST_SUPPRIME", nullable=false, columnDefinition = "Boolean default false")
	private boolean estSupprime = false;

	/**
	 * 
	 */
	public Questionnaire() {
		super();
	}
	
	/**
	 * 
	 */
	public Questionnaire(String nom, String desc) {
		super();
		this.nom = nom;
		this.description = desc;
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
	public Set<Question> getListeQuestions() {
		return listeQuestions;
	}

	/**
	 * @param listeQuestions
	 *            the listeQuestions to set
	 */
	public void setListeQuestions(Set<Question> listeQuestions) {
		this.listeQuestions = listeQuestions;
	}

}
