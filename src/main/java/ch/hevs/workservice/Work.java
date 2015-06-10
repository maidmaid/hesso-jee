package ch.hevs.workservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Employee;

@Local
public interface Work {
	public List<Employee> getEmployees();
	public Employee getEmployeeById(long id);
}
