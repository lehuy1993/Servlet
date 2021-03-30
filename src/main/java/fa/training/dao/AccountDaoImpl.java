package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Account;
import fa.training.idao.AccountDao;
import fa.training.utils.HibernateUtils;

public class AccountDaoImpl implements AccountDao<Account, Integer> {

	@Override
	public boolean login(String username, String password) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.HIBERNATEUTIL.getSession();
			transaction = session.beginTransaction();
			Query<Account> namedQuery = session
					.createQuery("FROM Account  WHERE account = :account AND password = :password");
			namedQuery.setParameter("account", username);
			namedQuery.setParameter("password", password);
			namedQuery.uniqueResult();
		if (namedQuery.uniqueResult() != null) {
			return true;
		}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	
}
