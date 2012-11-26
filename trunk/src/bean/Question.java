/**
 * 
 */
package bean;

/**
 * @author Stéphane Sikora & Frédéric Aubry
 *
 */
public class Question {

		private long id;
		private String intitule;
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
		 * @param id the id to set
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
		 * @param intitule the intitule to set
		 */
		public void setIntitule(String intitule) {
			this.intitule = intitule;
		}
		
		
}
