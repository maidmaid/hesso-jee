package ch.hevs.workservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.hevs.businessobject.Department;
import ch.hevs.businessobject.Employee;
import ch.hevs.businessobject.Office;

@Stateless
public class WorkBean implements Work {

	@PersistenceContext(name = "WorkPU")
	private EntityManager em;
	
	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) em.createQuery("SELECT e FROM Employee e").getResultList();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return em.find(Employee.class, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		em.merge(employee);
		em.flush();
	}

	@Override
	public List<Office> getOffices() {
		return (List<Office>) em.createQuery("SELECT o FROM Office o").getResultList();
	}

	@Override
	public Office getOfficeById(long id) {
		return em.find(Office.class, id);
	}

	@Override
	public List<Department> getDepartments() {
		return (List<Department>) em.createQuery("SELECT d FROM Department d").getResultList();
	}
}
