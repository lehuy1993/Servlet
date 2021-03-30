package fa.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	@Column(unique = true, nullable = false, length = 255)
	private String account;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false, length = 255)
	private String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId")
	private Employee employee;

	private byte status;
	

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}



	public Account(String account, String email, String password) {
		super();
		this.account = account;
		this.email = email;
		this.password = password;
	}

	public Account(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	
	public Account(String account, String email, String password, Employee employee, byte status) {
		super();
		this.account = account;
		this.email = email;
		this.password = password;
		this.employee = employee;
		this.status = status;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, String account, String email, String password, Employee employee,
			List<Employee> employees) {
		super();
		this.accountId = accountId;
		this.account = account;
		this.email = email;
		this.password = password;
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
