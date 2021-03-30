package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import antlr.debug.NewLineEvent;
import fa.training.dao.AccountDaoImpl;
import fa.training.dao.EmployeeDaoImpl;
import fa.training.entities.Employee;
import fa.training.idao.EmployeeDao;
import fa.training.utils.Log4J;

/**
 * Servlet implementation class ListEmployeeServlet
 */
@WebServlet("/list-employees")
public class ListEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	private AccountDaoImpl accountDaoImpl = new AccountDaoImpl();

	public ListEmployeeServlet() {
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
		try {
			int page = 1;
			int pageSize = 1;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			int totalRow=employeeDaoImpl.getTotalRecordsCount();
			int numberOfPages=totalRow/pageSize + (totalRow%pageSize>0?1:0);
			List<Employee> employees = employeeDaoImpl.viewAllEmployees(page, pageSize);
			request.setAttribute("numberOfPages", numberOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("employees", employees);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list-employee.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			Log4J.getLogger().error(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
