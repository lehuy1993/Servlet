package fa.training.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fa.training.dao.EmployeeDaoImpl;
import fa.training.entities.Employee;

public class EmployeeTest {

	private EmployeeDaoImpl  employeeDaoImpl = null;
	
	@Before
	public void init() {
		employeeDaoImpl = new EmployeeDaoImpl();
	}
	@Test
	public void testEmployee() throws ClassNotFoundException, IOException, SQLException {
		List<Employee> employees = employeeDaoImpl.getAll(Employee.class);
		assertEquals(1, employees.size());
	}
}
