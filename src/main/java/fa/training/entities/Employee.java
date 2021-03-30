package fa.training.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	@Column(nullable = false)
	private String firsName;
	@Column(nullable = false)
	private String lastName;
	@Column(columnDefinition = "INT CHECK (gender = 0 or gender = 1)", nullable = false)
	private byte gender;
	@Column(nullable = false)
	private Date dateOfBirth;
	@Column(length = 20, nullable = false)
	private String phone;
	private String address;
	@Column(nullable = false)
	private String departmentName;
	@Column(length = 1000)
	private String remark;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId")
	private Account account;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String firsName, String lastName, byte gender, Date dateOfBirth, String phone,
			String address, String departmentName, String remark) {
		super();
		this.employeeId = employeeId;
		this.firsName = firsName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.departmentName = departmentName;
		this.remark = remark;
	}

	public Employee(int employeeId, String firsName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firsName = firsName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firsName=" + firsName + ", lastName=" + lastName + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", phone=" + phone + ", address=" + address
				+ ", departmentName=" + departmentName + ", remark=" + remark + ", account=" + account + "]";
	}

	public Employee(String firsName, String lastName, byte gender, Date dateOfBirth, String phone, String address,
			String departmentName, String remark) {
		super();
		this.firsName = firsName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.departmentName = departmentName;
		this.remark = remark;
	}
	

}
