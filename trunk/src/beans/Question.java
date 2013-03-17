/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author St�phane Sikora & Fr�d�ric Aubry
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
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Reponse> listeReponses;

	/**
	 * 
	 */
	@Column(name = "EST_SUPPRIME", nullable=false, columnDefinition = "Boolean default false")
	private boolean estSupprime = false;
	

	/**
		 * 
		 */
	public Question() {
		super();
		//initialisation de la liste des réponses
		setListeReponses(new ArrayList<Reponse>());
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
