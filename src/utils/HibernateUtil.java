/**
 * 
 */
package utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Stephane Sikora & Frederic Aubry
 * 
 */
public class HibernateUtil {

	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		return configureSessionFactory().openSession();
	}
	
	private static SessionFactory configureSessionFactory() throws HibernateException {
	    //remplace new AnnotationConfiguration().configure().buildSessionFactory() depuis hibernate 3.6
		Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
}
