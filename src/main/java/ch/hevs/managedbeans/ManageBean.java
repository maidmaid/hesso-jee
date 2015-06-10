package ch.hevs.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ch.hevs.businessobject.Employee;
import ch.hevs.workservice.Work;

@ManagedBean(name="manageBean")
@RequestScoped
public class ManageBean {
	
	@EJB(name = "ManageBean") 
	private Work work;
	
	private List<Employee> employees;
	private long employeeId;
	private Employee employee;

	@PostConstruct
    public void initialize() {
		setEmployees(work.getEmployees());
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
}
