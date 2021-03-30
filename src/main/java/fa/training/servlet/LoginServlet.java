package fa.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.AccountDaoImpl;
import fa.training.entities.Account;
import fa.training.idao.AccountDao;
import fa.training.utils.Constants;
import fa.training.utils.Log4J;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter outPrintWriter = response.getWriter();

		String account = request.getParameter("userName");
		String password = request.getParameter("password");
		AccountDao accountDao = new AccountDaoImpl();
		try {
			if (accountDao.login(account, password)) {
				
				HttpSession session = request.getSession();				
				session.setAttribute("userLogin", account);
				response.sendRedirect(request.getContextPath() + "/list-employees");

			} else {
//				outPrintWriter.print(Constants.LOGIN_FAIL_MESSAGE);
				request.setAttribute("msg", Constants.LOGIN_FAIL_MESSAGE);

				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		outPrintWriter.close();

	}
}
