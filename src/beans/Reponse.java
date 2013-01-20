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
 * @author St�phane Sikora & Fr�d�ric Aubry
 *
 */
@Entity
@Table(name = "reponse")
public class Reponse implements Serializable{
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	/**
	 * 
	 */
	@Column(name = "LIBELLE", nullable=false)
	private String libelle;
	/**
	 * 
	 */
	@Column(name = "EST_CORRECTE", nullable=false)
	private boolean estCorrecte;
	
	
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name ="ID_QUESTION")
	private Question question;
	
	/**
	 * 
	 */
	@Column(name = "EST_SUPPRIME", nullable=false, columnDefinition = "Boolean default false")
	private boolean estSupprime = false;
	
	/**
	 * 
	 */
	public Reponse() {
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the estCorrecte
	 */
	public boolean isEstCorrecte() {
		return estCorrecte;
	}
	/**
	 * @param estCorrecte the estCorrecte to set
	 */
	public void setEstCorrecte(boolean estCorrecte) {
		this.estCorrecte = estCorrecte;
	}
	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reponse [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", estCorrecte=");
		builder.append(estCorrecte);
		builder.append(", question=");
		builder.append(question);
		builder.append(", estSupprime=");
		builder.append(estSupprime);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
