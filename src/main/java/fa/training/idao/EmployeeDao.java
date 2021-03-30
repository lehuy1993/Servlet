package fa.training.idao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import fa.training.entities.Employee;

public interface EmployeeDao<T, ID> extends IDao<T, ID> {
	
	public   List<T> viewAllEmployees(int pageNumber, int pageSize) throws ClassNotFoundException, IOException, SQLException;
	public Employee finByID(int employeeId)throws ClassNotFoundException, IOException, SQLException;
	public int getTotalRecordsCount();
}
