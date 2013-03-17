/**
 * 
 */
package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.Question;
import beans.Reponse;
import dao.QuestionDAO;
import dao.hibernate.QuestionHibernateDAO;


/**
 * @author Stephane Sikora & Frederic Aubry
 *
 */
public class QuestionImplementService implements QuestionService{
	
	QuestionDAO maDAO;
	//Erreur possibles 
	private final static long PAS_DE_LIBELLE = -1;
	private final static long AUCUNE_REPONSE_CORRECTE = -2;
	private final static long MOINS_DE_DEUX_REPONSES = -3;
	
	/**
	 * @param maDAO
	 */
	public QuestionImplementService() {
		this.maDAO = new QuestionHibernateDAO();
	}

	public long creer(Question q){
		//Libelle manquant
		if (q.getIntitule() == null || "".equals(q.getIntitule())) {
			return PAS_DE_LIBELLE;
		}
		
		
		//Controle de la validite des reponses (nombre et au moins une correcte
		int nbReponsesValides = 0;
		int nbReponsesCorrectes = 0;
		List<Reponse> listeReponses = q.getListeReponses();
		//list des reponses invalides
		List <Reponse> invalides = new ArrayList<Reponse>();
		//on crée l'iterateur de la liste des reponses
		Iterator<Reponse> itRep = listeReponses.listIterator();
		//on le parcours et on compte le nombre de reponses valides et de reponses correctes
		while (itRep.hasNext()){
			Reponse rep = itRep.next();
			//libelle non nul, on comptabilise comme valide.
			//Sinon, on marque cette reponse pour retrait ultérieur de la liste et on passe a la suivante
			if (rep.getLibelle() != null && !"".equals(rep.getLibelle())) {
				nbReponsesValides++;				
			} else {
				invalides.add(rep);
				continue;
			}
			//si valide, on verifie si correcte, on comptabilise
			if (rep.isEstCorrecte()) {
				nbReponsesCorrectes++;
			}
		}
		System.out.println("invalides :: "+invalides);
		//nombre de reponses valides KO ?
		if (nbReponsesValides < 2) {
			return MOINS_DE_DEUX_REPONSES;
		}
		//aucune reponse correcte ?
		if (nbReponsesCorrectes == 0) {
			return AUCUNE_REPONSE_CORRECTE;
		}
		//Tout est bon, on peut sauvegarder la question et ses réponses valides
		//retrait des reponses invalides
		Iterator<Reponse> itInv = invalides.iterator();
		while (itInv.hasNext()){
			System.out.println("avant :: "+listeReponses);
			listeReponses.remove(itInv.next());
			System.out.println("apres :: "+listeReponses);
			
			
		}
		System.out.println("listRep :: "+listeReponses);
		System.out.println("repQuest :: "+q.getListeReponses());
		return this.maDAO.creer(q);
	}
	
	public List<Question> listerQuestions(long idQuestionnaire){
		return this.maDAO.listerQuestionsQuestionnaire(idQuestionnaire);
	}

	@Override
	public boolean modifier(Question q) {
		return this.maDAO.modifier(q);
	}

	@Override
	public Question trouver(long qid) {
		return this.maDAO.trouver(qid);
	}
}
