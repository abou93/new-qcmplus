/**
 * 
 */
package beans;

import java.util.ArrayList;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class Questionnaire {
	
	/**
	 * 
	 */
	private long id;
	
	/**
	 * 
	 */
	private String nom;
	
	/**
	 * 
	 */
	private String description;
	
	/**
	 * 
	 */
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
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
	 * @param listeQuestions the listeQuestions to set
	 */
	public void setListeQuestions(ArrayList<Question> listeQuestions) {
		this.listeQuestions = listeQuestions;
	}
	
}
