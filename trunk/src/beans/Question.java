/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
@Entity
@Table(name = "question")
public class Question implements Serializable{

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/**
	 * 
	 */
	@Column(name = "INTITULE", nullable = false, length = 500)
	private String intitule;
	
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="ID_QUESTIONNAIRE")
	private Questionnaire questionnaire;
	
	/**
	 * 
	 */
	@OneToMany(mappedBy = "question")
	private List<Reponse> listeReponses;
	

	/**
		 * 
		 */
	public Question() {
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
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @param intitule
	 *            the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	/**
	 * @return the questionnaire
	 */
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	/**
	 * @param questionnaire the questionnaire to set
	 */
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	/**
	 * @return the listeReponses
	 */
	public List<Reponse> getListeReponses() {
		return listeReponses;
	}

	/**
	 * @param listeReponses the listeReponses to set
	 */
	public void setListeReponses(List<Reponse> listeReponses) {
		this.listeReponses = listeReponses;
	}
	
	

}
