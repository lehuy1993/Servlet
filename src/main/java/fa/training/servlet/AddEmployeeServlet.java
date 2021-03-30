package fa.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.AccountDaoImpl;
import fa.training.dao.EmployeeDaoImpl;
import fa.training.entities.Account;
import fa.training.entities.Employee;
import fa.training.utils.DateUtils;
import fa.training.utils.Log4J;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/add-emp")

public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	private AccountDaoImpl accountDaoImpl = new AccountDaoImpl();

	public AddEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter outPrintWriter = response.getWriter();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/add-employee.jsp");
		dispatcher.forward(request, response);
		outPrintWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firsName = request.getParameter("firsName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		byte gender = Byte.parseByte(request.getParameter("gender"));
		Date dateOfBirth = null;
		try {
			dateOfBirth = DateUtils.convertStringToDate(request.getParameter("dateOfBirth"));
		} catch (ParseException e) {
			// TODO: handle exception
			Log4J.getLogger().error("Parse Exception when convert string to date");
		}
		String account = request.getParameter("account");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		byte status = 1;
		String departmentName = request.getParameter("departmentName");
		String remark = request.getParameter("remark");
		Employee employee = new Employee(firsName, lastName, gender, dateOfBirth, phone, address, departmentName,
				remark);
		Account account2 = new Account(account, email, password, employee, status);

		try {
			accountDaoImpl.save(account2);
			employeeDaoImpl.save(employee);
			request.setAttribute("employee", employee);
			request.setAttribute("account2", account2);
			request.setAttribute("message", "Add new employee successfully");
			request.getRequestDispatcher("/views/add-employee.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			Log4J.getLogger().error("An exception occurs");

		}

	}

}
