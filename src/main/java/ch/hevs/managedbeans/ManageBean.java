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
	private Office office;
	
	private List<Department> departments;
	private long departmentId;
	private Department department;

	@PostConstruct
    public void initialize() {
		employees = work.getEmployees();
		offices = work.getOffices();
		departments = work.getDepartments();
		employee = new Employee();
		setOffice(new Office());
		department = new Department();
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
		employee = work.getEmployeeById(employeeId);
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
	
	public String removeEmployee(long id) {
		work.removeEmployee(id);
		return "index";
	}
	
	public void loadOffice() {
		setOffice(work.getOfficeById(officeId));
	}
	
	public String updateOffice() {
		Department department = work.getDepartmentById(getDepartmentId());
		office.setDepartment(department);
		
		List<Employee> employees = work.getEmployeesByOffice(office.getId());
		office.setEmployees(employees);
		
		work.updateOffice(getOffice());
		return "index";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	
	public String removeOffice(long id) {
		work.removeOffice(id);
		return "index";
	}
	
	public String updateDepartment() {		
		List<Office> offices = work.getOfficesByDepartment(departmentId);
		department.setOffices(offices);
		work.updateDepartment(department);
		return "index";
	}
	
	public void loadDepartment() {
		department = work.getDepartmentById(departmentId);
	}
	
	public String removeDepartment(long id) {
		work.removeDepartment(id);
		return "index";
	}
}
