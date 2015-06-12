package ch.hevs.workservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Department;
import ch.hevs.businessobject.Employee;
import ch.hevs.businessobject.Office;

@Local
public interface Work {
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByOffice(long id);
	public Employee getEmployeeById(long id);
	public void updateEmployee(Employee employee);
	public List<Office> getOffices();
	public List<Office> getOfficesByDepartment(long id);
	public Office getOfficeById(long id);
	public List<Department> getDepartments();
	public void removeEmployee(long id);
	public void updateOffice(Office office);
	public Department getDepartmentById(long id);
	public void removeOffice(long id);
	public void updateDepartment(Department departement);
}
