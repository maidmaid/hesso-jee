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

	@Override
	public void removeEmployee(long id) {
		Employee employee = em.find(Employee.class, id);
		
		em.merge(employee);
		em.remove(employee);
		em.flush();
	}

	@Override
	public void updateOffice(Office office) {
		em.merge(office);
		em.flush();
	}
	
	public Department getDepartmentById(long id) {
		return em.find(Department.class, id);
	}

	@Override
	public List<Employee> getEmployeesByOffice(long id) {
		return (List<Employee>) em.createQuery("SELECT e FROM Employee e WHERE e.office.id = :id").setParameter("id", id).getResultList();
	}

	@Override
	public void removeOffice(long id) {
		Office office = em.find(Office.class, id);
		
		em.remove(office);
		em.flush();
	}

	@Override
	public List<Office> getOfficesByDepartment(long id) {
		return (List<Office>) em.createQuery("SELECT o FROM Office o WHERE o.department.id = :id").setParameter("id", id).getResultList();
	}

	@Override
	public void updateDepartment(Department departement) {
		em.merge(departement);
		em.flush();
	}
}
