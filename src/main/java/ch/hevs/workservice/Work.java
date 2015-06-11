package ch.hevs.workservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Employee;
import ch.hevs.businessobject.Office;

@Local
public interface Work {
	public List<Employee> getEmployees();
	public Employee getEmployeeById(long id);
	public void updateEmployee(Employee employee);
	public List<Office> getOffices();
	public Office getOfficeById(long id);
}
