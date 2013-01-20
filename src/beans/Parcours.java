/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
@Entity
@Table(name = "parcours")
public class Parcours implements Serializable{

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/**
	 * 
	 */
	@Column(name = "DATE_DEBUT", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;
	/**
	 * 
	 */
	@Column(name = "DATE_FIN", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	/**
	 * 
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="ID_QUESTIONNAIRE")
	private Questionnaire questionnaire;
	/**
	 * 
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="ID_STAGIAIRE")
	private Stagiaire stagiaire;
	/**
	 * 
	 */
	@OneToMany(mappedBy = "parcours", fetch = FetchType.EAGER)
	private Set<Resultat> listeResultats;
	
	/**
	 * 
	 */
	@Column(name = "EST_SUPPRIME", nullable=false, columnDefinition = "Boolean default false")
	private boolean estSupprime = false;

	/**
		 * 
		 */
	public Parcours() {
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
	 * @return the datedebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param datedebut
	 *            the datedebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the datefin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param datefin
	 *            the datefin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
	 * @return the stagiaire
	 */
	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	/**
	 * @param stagiaire the stagiaire to set
	 */
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	/**
	 * @return the listeResultats
	 */
	public Set<Resultat> getListeResultats() {
		return listeResultats;
	}

	/**
	 * @param listeResultats the listeResultats to set
	 */
	public void setListeResultats(Set<Resultat> listeResultats) {
		this.listeResultats = listeResultats;
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
