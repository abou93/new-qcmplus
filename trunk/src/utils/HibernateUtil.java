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
 * @author Stéphane Sikora & Frédéric Aubry
 * 
 */
public class HibernateUtil {
//	private static SessionFactory sessionFactory;
//	static {
//		try {
//			// Create the SessionFactory from hibernate.cfg.xml
//			sessionFactory = new Configuration().configure()
//					.buildSessionFactory();
//		} catch (Throwable ex) {
//			// Make sure you log the exception, as it might be swallowed
//			System.err.println("Initial SessionFactory creation failed." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
//
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	
	
	public static Session getSession() {
		return configureSessionFactory().openSession();
	}
	
	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
}
