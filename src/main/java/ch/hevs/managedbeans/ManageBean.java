package ch.hevs.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ch.hevs.businessobject.Department;
import ch.hevs.businessobject.Employee;
import ch.hevs.businessobject.Office;
import ch.hevs.workservice.Work;

@ManagedBean(name="manageBean")
@RequestScoped
public class ManageBean {
	
	@EJB(name = "ManageBean") 
	private Work work;
	
	private List<Employee> employees;
	private long employeeId;
	private Employee employee;
	
	private List<Office> offices;
	private long officeId;
	
	private List<Department> departments;

	@PostConstruct
    public void initialize() {
		employees = work.getEmployees();
		offices = work.getOffices();
		departments = work.getDepartments();
		employee = new Employee();
    }

	// employees
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	// employee id
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	// employee
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void loadEmployee() {
		this.employee = work.getEmployeeById(employeeId);
	}
	
	public String updateEmployee() {		
		Office office = work.getOfficeById(officeId);
		employee.setOffice(office);
		work.updateEmployee(employee);
		return "index";
	}

	public List<Office> getOffices() {
		return offices;
	}

	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}

	public long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
}
