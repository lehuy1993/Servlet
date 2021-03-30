package fa.training.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* Using enum class */
public enum HibernateUtils {
	HIBERNATEUTIL;

	private static SessionFactory sessionFactory;
	private Session session;

	static {
		Configuration cfg = new Configuration();
		cfg.configure();

		if (sessionFactory == null) {
			sessionFactory = cfg.buildSessionFactory();
		}
	}

	private static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		if (session == null || !session.isOpen()) {
			session = getSessionFactory().openSession();
		}
		return session;
	}
}

