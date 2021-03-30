package fa.training.idao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.utils.HibernateUtils;

public interface IDao<T, ID> {

	default boolean save(T t) throws ClassNotFoundException, SQLException {
		try (Session session = HibernateUtils.HIBERNATEUTIL.getSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			return true;
		}
	}

	default boolean update(T t) {
		try (Session session = HibernateUtils.HIBERNATEUTIL.getSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
			return true;
		}
	}

	default boolean delete(T t) {
		try (Session session = HibernateUtils.HIBERNATEUTIL.getSession()) {
			Transaction transaction = session.beginTransaction();
			session.delete(t.getClass().getName(), t);
			transaction.commit();
			return true;
		}
	}

	default List<T> getAll(Class<T> t) throws ClassNotFoundException, IOException, SQLException{
		List<T> result = null;
		try (Session session = HibernateUtils.HIBERNATEUTIL.getSession()) {
			Query<T> query = session.createQuery("FROM " + t.getSimpleName(), t);
			result = query.list();
			return result;
		}
	}

	default List<T> getAll(Class<T> t, int startPage, int sizeOfPage) {
		List<T> result = null;
		try (Session session = HibernateUtils.HIBERNATEUTIL.getSession()) {

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<T> criteriaQuery = builder.createQuery(t);

			Root<T> table = criteriaQuery.from(t);

			criteriaQuery.select(table);

			Query<T> query = session.createQuery(criteriaQuery);
			query.setFirstResult(startPage);
			query.setMaxResults(sizeOfPage);
			result = query.list();
			return result;
		}
	}

}
