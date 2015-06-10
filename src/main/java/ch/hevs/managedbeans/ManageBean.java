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

	@PostConstruct
    public void initialize() {
		employees = work.getEmployees();
    }
	
	public List<Employee> getEmployees() {
		return employees;
	}
}
