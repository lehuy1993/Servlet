package fa.training.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Employee;
import fa.training.idao.EmployeeDao;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao<Employee, Integer> {
	Session session = null;
	Transaction transaction = null;

	@Override
	public List<Employee> viewAllEmployees(int pageNumber, int pageSize)
			throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		try {
			session = HibernateUtils.HIBERNATEUTIL.getSession();
			transaction = session.beginTransaction();

			Query selectQuery = session.createQuery("From Employee");
			selectQuery.setFirstResult((pageNumber - 1) * pageSize);
			selectQuery.setMaxResults(pageSize);
			return selectQuery.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Employee finByID(int employeeId) throws ClassNotFoundException, IOException, SQLException {
		try {
			session = HibernateUtils.HIBERNATEUTIL.getSession();
			transaction = session.beginTransaction();
			String hql = "FROM Employee WHERE employeeId = :employeeId";

			Query<Employee> query = session.createQuery(hql);
			query.setParameter("employeeId", employeeId);
			query.getSingleResult();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;

	}

	@Override
	public int getTotalRecordsCount() {
		try {
			session = HibernateUtils.HIBERNATEUTIL.getSession();
			transaction = session.beginTransaction();
			String countQ = "SELECT COUNT(employeeId) FROM Employee";
			Query countQuery = session.createQuery(countQ);
			Long countResults = (Long) countQuery.uniqueResult();

			return (int) (long) countResults;
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
