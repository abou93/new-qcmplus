/**
 * 
 */
package bean;

import java.util.Date;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class Parcours {

		private long id;
		private Date datedebut;
		private Date datefin;
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
		 * @param id the id to set
		 */
		public void setId(long id) {
			this.id = id;
		}
		/**
		 * @return the datedebut
		 */
		public Date getDatedebut() {
			return datedebut;
		}
		/**
		 * @param datedebut the datedebut to set
		 */
		public void setDatedebut(Date datedebut) {
			this.datedebut = datedebut;
		}
		/**
		 * @return the datefin
		 */
		public Date getDatefin() {
			return datefin;
		}
		/**
		 * @param datefin the datefin to set
		 */
		public void setDatefin(Date datefin) {
			this.datefin = datefin;
		}
		
		
}
