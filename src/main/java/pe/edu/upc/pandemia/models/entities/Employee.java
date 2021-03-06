package pe.edu.upc.pandemia.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employees",
indexes = {@Index(columnList = "last_name, first_name", 
name="employees_index_last_first_name" )},
uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})

@SequenceGenerator(name="genEmployee",initialValue=1,allocationSize = 1)
public class Employee { // upper camel case

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="genEmployee")
	@Column(name = "employee_id", columnDefinition = "NUMERIC(6)")
	private Integer id;

	@Column(name = "first_name", length = 20)
	private String firstName; // lower camel case
	
	@Column(name = "last_name", length = 25, nullable = false)
	private String lastName;
	
	@Column(name = "email", length = 25, nullable = false)
	private String email;
	
	@Column(name = "phone_number", length = 20, nullable = false)
	private String phoneNumber;

	@Column(name="hire_date")
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	

	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Job job;

	@Column(name = "salary", columnDefinition = "DECIMAL(8,2)")
	private Float salary;

	@Column(name = "commission_pct", columnDefinition = "DECIMAL(2,2)")
	private Float comissionPct;

	@ManyToOne
	@JoinColumn(name = "manager_ID", nullable = true)
	private Employee manager; // 

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = true)
	private Department department;

	
@OneToMany(mappedBy ="employee",fetch = FetchType.LAZY )
	private List<JobHistory> jobHistories;

	//se considera a uno de los manytomany el principal, en este caso se toma a employee

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "employee_language",
	joinColumns = {@JoinColumn(referencedColumnName = "employee_id",name="employee_id")}
	,inverseJoinColumns = {@JoinColumn(referencedColumnName = "language_id", name="language_id")})
	
	private List<Language> languages;

//si es manager:
	
	@OneToOne
	@JoinColumn(name = "manager_id", insertable = false,updatable = false)
	private Department departmentManager;

	
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
	private List<Employee> departmentEmployees;
	
	@OneToOne(mappedBy = "employee")
	private User user;

	
	//----constructor, getter y setter
	public Employee() {
		jobHistories=new ArrayList<JobHistory>();
		languages= new ArrayList<Language>();
		departmentEmployees=new ArrayList<Employee>();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}


	public Float getSalary() {
		return salary;
	}


	public void setSalary(Float salary) {
		this.salary = salary;
	}


	public Float getComissionPct() {
		return comissionPct;
	}


	public void setComissionPct(Float comissionPct) {
		this.comissionPct = comissionPct;
	}


	public Employee getManager() {
		return manager;
	}


	public void setManager(Employee manager) {
		this.manager = manager;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public List<JobHistory> getJobHistories() {
		return jobHistories;
	}


	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}


	public List<Language> getLanguages() {
		return languages;
	}


	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}


	public Department getDepartmentManager() {
		return departmentManager;
	}


	public void setDepartmentManager(Department departmentManager) {
		this.departmentManager = departmentManager;
	}


	public List<Employee> getDepartmentEmployees() {
		return departmentEmployees;
	}


	public void setDepartmentEmployees(List<Employee> departmentEmployees) {
		this.departmentEmployees = departmentEmployees;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
