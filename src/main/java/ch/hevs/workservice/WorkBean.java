package ch.hevs.workservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.hevs.businessobject.Employee;

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
}
